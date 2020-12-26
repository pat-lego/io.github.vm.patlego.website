package io.github.vm.patlego.commands;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.Option;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.vm.patlego.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.email.EmailService;
import io.github.vm.patlego.email.bean.EmailContent;
import io.github.vm.patlego.impl.DefaultEmailRecipient;

import javax.mail.internet.InternetAddress;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

@Service
@Command(scope = "patlego", name = "sendblog", description = "Sends out a blog to all of the users who subscribed to receive our blog")
public class SendBlog implements Action {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private SubscribeDS subscribeDS;

    @Reference(filter = "(patlego.email=default)")
    private EmailService emailService;

    @Argument(index = 0, name = "blogId", description = "Blog to be sent to all users", required = true, multiValued = false)
    public Integer blogId = 0;

    @Option(name = "-e", aliases = "--email", description = "Send blog to a specific address", required = false, multiValued = false)
    public String email = StringUtils.EMPTY;

    @Override
    public Object execute() throws Exception {
        // Nothing to do incorrect blogId
        if (blogId == null || blogId <= 0) {
            logger.warn("Submitted a blog id smaller then 0, please provide a valid blog id");
            return null;
        }

        EmailContent content = new EmailContent.Builder().addTo(new InternetAddress("patrique.legault@aftia.com"))
                .setHTML(Boolean.TRUE)
                .addSubject("Hello World")
                .addMessage(IOUtils.toString(this.getClass().getResourceAsStream("/blog-templates/blog.html"), "UTF-8"))
                .build();

        this.emailService.send(new DefaultEmailRecipient(), null, content);

        return "Success";

    }

}
