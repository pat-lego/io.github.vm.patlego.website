package io.github.vm.patlego.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.vm.patlego.mail.EmailService;
import io.github.vm.patlego.runmodes.RunMode;
import io.github.vm.patlego.runmodes.RunModes;
import io.github.vm.patlego.website.core.blogs.commands.SendBlog;
import io.github.vm.patlego.website.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.website.datasource.blogs.tables.Blog;
import io.github.vm.patlego.website.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.website.datasource.subscribe.tables.Subscribe;

public class TestSendBlog {

    @Test
    public void testGetEmailContent() throws IOException {
        SendBlog sendBlog = new SendBlog();
        sendBlog.getEmailContent();
    }

    @Test
    public void testGetBlogTitle() {
        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        SendBlog sendBlog = new SendBlog();
        sendBlog.blogDS = blogDS;

        assertEquals("My first blog", sendBlog.getBlogTitle(1L));
    }

    @Test
    public void testGetsubscriptions() {
        List<Subscribe> list = new ArrayList<Subscribe>();
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        SendBlog sendBlog = new SendBlog();
        sendBlog.subscribeDS = subscribeDS;

        assertEquals(0, sendBlog.getSubscriptions().size());
    }

    @Test
    public void testGetTemplater_fname() throws IOException {
        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;

        Subscribe subscribe = new Subscribe();
        subscribe.setFirstName("Patrique");

        assertNotNull(sendBlog.getTemplater(subscribe));

        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.PROD);

        assertNotNull(sendBlog.getTemplater(subscribe));
    }

    @Test
    public void testGetTemplater_fname_lname() throws IOException {
        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;

        Subscribe subscribe = new Subscribe();
        subscribe.setFirstName("Patrique");
        subscribe.setLastName("Patrique");

        assertNotNull(sendBlog.getTemplater(subscribe));

        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.PROD);

        assertNotNull(sendBlog.getTemplater(subscribe));
    }

    @Test
    public void testGetTemplater_empty() throws IOException {
        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;

        Subscribe subscribe = new Subscribe();

        assertNotNull(sendBlog.getTemplater(subscribe));

        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.PROD);

        assertNotNull(sendBlog.getTemplater(subscribe));
    }
    
    @Test
    public void testExecute_exception() throws Exception {
        SendBlog sendBlog = new SendBlog();
        sendBlog.blogId = -1L;

        assertEquals("Submitted a blog id smaller then 0, please provide a valid blog id", sendBlog.execute());
    }

    @Test
    public void testExecute_one_subscriber() throws Exception {
        EmailService emailService = Mockito.mock(EmailService.class);
        
        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        List<Subscribe> list = new ArrayList<Subscribe>();
        Subscribe subscribe = new Subscribe();
        subscribe.setEmail("pat@pat.com");
        subscribe.setFirstName("Pat");
        subscribe.setLastName("Lego");
        list.add(subscribe);
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;
        sendBlog.subscribeDS = subscribeDS;
        sendBlog.blogDS = blogDS;
        sendBlog.emailService = emailService;
        sendBlog.blogId = 1L;

       assertEquals("Sent blog My first blog to 1 user", sendBlog.execute());
    }

    @Test
    public void testExecute_one_subscriber_fname() throws Exception {
        EmailService emailService = Mockito.mock(EmailService.class);
        
        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        List<Subscribe> list = new ArrayList<Subscribe>();
        Subscribe subscribe = new Subscribe();
        subscribe.setEmail("pat@pat.com");
        subscribe.setFirstName("Pat");
        list.add(subscribe);
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;
        sendBlog.subscribeDS = subscribeDS;
        sendBlog.blogDS = blogDS;
        sendBlog.emailService = emailService;
        sendBlog.blogId = 1L;

       assertEquals("Sent blog My first blog to 1 user", sendBlog.execute());
    }

    @Test
    public void testExecute_one_subscriber_no_name() throws Exception {
        EmailService emailService = Mockito.mock(EmailService.class);
        
        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        List<Subscribe> list = new ArrayList<Subscribe>();
        Subscribe subscribe = new Subscribe();
        subscribe.setEmail("pat@pat.com");
        list.add(subscribe);
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;
        sendBlog.subscribeDS = subscribeDS;
        sendBlog.blogDS = blogDS;
        sendBlog.emailService = emailService;
        sendBlog.blogId = 1L;

       assertEquals("Sent blog My first blog to 1 user", sendBlog.execute());
    }

    @Test
    public void testExecute_two_subscribers() throws Exception {
        EmailService emailService = Mockito.mock(EmailService.class);
        
        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        List<Subscribe> list = new ArrayList<Subscribe>();
        
        Subscribe subscribe_1 = new Subscribe();
        subscribe_1.setEmail("pat@pat.com");
        subscribe_1.setFirstName("Pat");
        subscribe_1.setLastName("Lego");
        list.add(subscribe_1);

        Subscribe subscribe_2 = new Subscribe();
        subscribe_2.setEmail("pat@pat.com");
        subscribe_2.setFirstName("Pat");
        subscribe_2.setLastName("Lego");
        list.add(subscribe_2);
        
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;
        sendBlog.subscribeDS = subscribeDS;
        sendBlog.blogDS = blogDS;
        sendBlog.emailService = emailService;
        sendBlog.blogId = 1L;

       assertEquals("Sent blog My first blog to 2 users", sendBlog.execute());
    }

    @Test
    public void testExecute_empty() throws Exception {
        EmailService emailService = Mockito.mock(EmailService.class);
        
        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        List<Subscribe> list = new ArrayList<Subscribe>();
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;
        sendBlog.subscribeDS = subscribeDS;
        sendBlog.blogDS = blogDS;
        sendBlog.emailService = emailService;
        sendBlog.blogId = 1L;

       assertEquals("No blogs to send since there are no subscribers", sendBlog.execute());
    }

    @Test
    public void testExecute_throws() throws Exception {
        EmailService emailService = Mockito.mock(EmailService.class);
        Mockito.doThrow(IllegalArgumentException.class).when(emailService).send(Mockito.any(), Mockito.any(), Mockito.any());

        Blog blog = new Blog();
        blog.setBlogTitle("My first blog");
        BlogsDS blogDS = Mockito.mock(BlogsDS.class);
        Mockito.when(blogDS.getBlog(Mockito.anyLong())).thenReturn(blog);

        List<Subscribe> list = new ArrayList<Subscribe>();

        Subscribe subscribe_1 = new Subscribe();
        subscribe_1.setEmail("pat@pat.com");
        subscribe_1.setFirstName("Pat");
        subscribe_1.setLastName("Lego");
        list.add(subscribe_1);

        Subscribe subscribe_2 = new Subscribe();
        subscribe_2.setEmail("pat@pat.com");
        subscribe_2.setFirstName("Pat");
        subscribe_2.setLastName("Lego");
        list.add(subscribe_2);
        
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        Mockito.when(subscribeDS.getSubscriptions()).thenReturn(list);

        RunMode runMode = Mockito.mock(RunMode.class);
        Mockito.when(runMode.getRunMode()).thenReturn(RunModes.DEV);

        SendBlog sendBlog = new SendBlog();
        sendBlog.runMode = runMode;
        sendBlog.subscribeDS = subscribeDS;
        sendBlog.blogDS = blogDS;
        sendBlog.emailService = emailService;
        sendBlog.blogId = 1L;

       assertEquals("Sent no blogs to any users, please check the logs as this might be caused by an internal issue", sendBlog.execute());
    }
}
