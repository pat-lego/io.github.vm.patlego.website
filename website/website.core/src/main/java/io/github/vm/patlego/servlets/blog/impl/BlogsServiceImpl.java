package io.github.vm.patlego.servlets.blog.impl;

import javax.ws.rs.Path;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.github.vm.patlego.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.datasource.blogs.tables.Blog;
import io.github.vm.patlego.servlets.blog.BlogServletPath;
import io.github.vm.patlego.servlets.blog.BlogsService;

@Path(BlogServletPath.BLOG_CLASS_PATH)
@Component(service = BlogsService.class, immediate = true)
public class BlogsServiceImpl implements BlogsService {   

    @Reference
    private BlogsDS blogDS;

    @Path(BlogServletPath.BLOG_METHOD_PATH)
    @Produces("application/json")
    @GET
    public List<Blog> getBlogs() {
        return this.blogDS.getBlogs();
    }
}
