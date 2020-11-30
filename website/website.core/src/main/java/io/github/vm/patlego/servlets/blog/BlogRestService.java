package io.github.vm.patlego.servlets.blog;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import io.github.vm.patlego.servlets.blog.impl.BlogsServiceImpl;

@Component
public class BlogRestService {

    private Server server;

    @Activate
    protected void activate() throws Exception {
        JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
        bean.setAddress(BlogServletPath.BLOG_CLASS_PATH + BlogServletPath.BLOG_METHOD_PATH);
        bean.setBus(BusFactory.getDefaultBus());
        bean.setProvider(new JacksonJsonProvider());
        bean.setServiceBean(new BlogsServiceImpl());
        this.server = bean.create();
    }

    @Modified
    protected void modified() throws Exception {
        this.deactivate();
        this.activate();
    }

    @Deactivate
    protected void deactivate() throws Exception {
        if (server != null) {
            this.server.destroy();
        }
    }
} 
