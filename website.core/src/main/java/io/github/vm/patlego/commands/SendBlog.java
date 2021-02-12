package io.github.vm.patlego.commands;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.vm.patlego.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.datasource.subscribe.tables.Subscribe;
import io.github.vm.patlego.email.EmailService;
import io.github.vm.patlego.email.bean.EmailContent;
import io.github.vm.patlego.email.template.Templater;
import io.github.vm.patlego.impl.blogs.BlogTemplater;
import io.github.vm.patlego.impl.blogs.DefaultEmailRecipient;
import io.github.vm.patlego.runmodes.RunMode;
import io.github.vm.patlego.urls.ProdSystemURL;
import io.github.vm.patlego.urls.DevSystemURL;
import io.github.vm.patlego.urls.SystemURL;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

@Service
@Command(scope = "patlego", name = "sendblog", description = "Sends out a blog to all of the users who subscribed to receive our blog")
public class SendBlog implements Action {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    public RunMode runMode;

    @Reference
    public BlogsDS blogDS;

    @Reference
    public SubscribeDS subscribeDS;

    @Reference(filter = "(email.name=patlego-vm)")
    public EmailService emailService;

    @Argument(index = 0, name = "blogId", description = "Blog to be sent to all users", required = true, multiValued = false)
    public Long blogId = 0L;

    @Override
    public Object execute() throws Exception {
        // Nothing to do incorrect blogId
        if (blogId == null || blogId <= 0) {
            logger.warn("Submitted a blog id smaller then 0, please provide a valid blog id");
            return "Submitted a blog id smaller then 0, please provide a valid blog id";
        }

        List<Subscribe> subscriptions = this.getSubscriptions();

        if (subscriptions.size() == 0) {
            return "No blogs to send since there are no subscribers";
        }

        Integer sentBlogs = subscriptions.size();

        for (Subscribe subscribe : subscriptions) {
            try {
                EmailContent.Builder content = new EmailContent.Builder().setHTML(Boolean.TRUE)
                        .addSubject(String.format("Enjoy reading this new Blog - %s", this.getBlogTitle(blogId)))
                        .addMessage(getEmailContent());

                if (subscribe.getFirstName() != null && !subscribe.getFirstName().isEmpty()
                        && subscribe.getLastName() != null && !subscribe.getLastName().isEmpty()) {
                    content.addTo(new InternetAddress(subscribe.getEmail(),
                            String.format("%s %s", subscribe.getFirstName(), subscribe.getLastName())));
                } else if (subscribe.getFirstName() != null && !subscribe.getFirstName().isEmpty()) {
                    content.addTo(new InternetAddress(subscribe.getEmail(), subscribe.getFirstName()));
                } else {
                    content.addTo(new InternetAddress(subscribe.getEmail()));
                }

                this.emailService.send(new DefaultEmailRecipient(), getTemplater(subscribe), content.build());
            } catch (Exception e) {
                logger.warn(String.format("Failed to send email to %s moving through the other subscriptions",
                        subscribe.getEmail()));
                sentBlogs = sentBlogs - 1;
            }

        }

        if (sentBlogs == 0) {
            return String.format("Sent no blogs to any users, please check the logs as this might be caused by an internal issue", this.getBlogTitle(blogId), sentBlogs);
        }

        if (sentBlogs == 1) {
            return String.format("Sent blog %s to %d user", this.getBlogTitle(blogId), sentBlogs);
        }

        return String.format("Sent blog %s to %d users", this.getBlogTitle(blogId), sentBlogs);

    }

    public String getEmailContent() throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream("/blog-templates/blog.html"), StandardCharsets.UTF_8);
    }

    public String getBlogTitle(Long blogId) {
        return this.blogDS.getBlog(blogId).getBlogTitle();
    }

    public List<Subscribe> getSubscriptions() {
        return this.subscribeDS.getSubscriptions();
    }

    public Templater getTemplater(Subscribe subscribe) throws IOException {
        Map<String, String> mapValues = new HashMap<String, String>();
        if (subscribe.getFirstName() != null && !subscribe.getFirstName().isEmpty() && subscribe.getLastName() != null
                && !subscribe.getLastName().isEmpty()) {
            mapValues.put("name", String.format(" %s %s", subscribe.getFirstName(), subscribe.getLastName()));
        } else if (subscribe.getFirstName() != null && !subscribe.getFirstName().isEmpty()) {
            mapValues.put("name", String.format(" %s", subscribe.getFirstName()));
        } else {
            mapValues.put("name", StringUtils.EMPTY);
        }

        mapValues.put("blogId", this.blogId.toString());
        mapValues.put("email", subscribe.getEmail());

        switch (this.runMode.getRunMode()) {
            case PROD:
                SystemURL prodUrls = new ProdSystemURL();
                mapValues.put("serverHost", prodUrls.getHostName());
                mapValues.put("serverPort", prodUrls.getPort().toString());
                break;
            default:
                SystemURL devUrls = new DevSystemURL();
                mapValues.put("serverHost", devUrls.getHostName());
                mapValues.put("serverPort", devUrls.getPort().toString());
                break;
        }

        Templater templater = new BlogTemplater(mapValues);

        return templater;
    }

}
