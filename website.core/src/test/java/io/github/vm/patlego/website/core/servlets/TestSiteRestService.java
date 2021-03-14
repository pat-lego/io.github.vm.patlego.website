package io.github.vm.patlego.website.core.servlets;

import org.apache.cxf.endpoint.Server;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.vm.patlego.website.core.SiteRestService;
import io.github.vm.patlego.website.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.website.datasource.subscribe.repo.SubscribeDS;


public class TestSiteRestService {

    @Test
    public void testDestroy() throws Exception {
        Server server = Mockito.mock(Server.class);
        SiteRestService restService = new SiteRestService();
        restService.server = server;
        restService.deactivate();
    }

    @Test
    public void testActivate() throws Exception {
        Server server = Mockito.mock(Server.class);
        BlogsDS blogsDS = Mockito.mock(BlogsDS.class);
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        SiteRestService restService = new SiteRestService();
        restService.server = server;
        restService.blogsDS = blogsDS;
        restService.subscribeDS = subscribeDS;

        restService.activate();
        restService.deactivate();
    }

    @Test
    public void testModified() throws Exception {
        Server server = Mockito.mock(Server.class);
        BlogsDS blogsDS = Mockito.mock(BlogsDS.class);
        SubscribeDS subscribeDS = Mockito.mock(SubscribeDS.class);

        SiteRestService restService = new SiteRestService();
        restService.server = server;
        restService.blogsDS = blogsDS;
        restService.subscribeDS = subscribeDS;

        restService.modified();
    }
    
}
