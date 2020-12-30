package io.github.vm.patlego.servlets;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import io.github.vm.patlego.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.servlets.blog.impl.BlogsServiceImpl;
import io.github.vm.patlego.servlets.subscribe.impl.SubscriberServiceImpl;

@Component
public class SiteRestService {
    
    public Server server;

    @Reference
    public BlogsDS blogsDS;

    @Reference
    public SubscribeDS subscribeDS;

    @Activate
    public void activate() throws Exception {
        JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
        bean.setAddress(SiteServletPath.SITE_CLASS_PATH);
        bean.setBus(BusFactory.getDefaultBus());
        bean.setProvider(new JacksonJsonProvider());
        bean.setServiceBean(new BlogsServiceImpl(blogsDS));
        bean.setServiceBean(new SubscriberServiceImpl(subscribeDS));
        server = bean.create();
    }

    @Modified
    public void modified() throws Exception {
        deactivate();
        activate();
    }

    @Deactivate
    public void deactivate() throws Exception {
        if (server != null) {
            server.destroy();
        }
    }
}
