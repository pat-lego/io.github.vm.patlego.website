package io.github.vm.patlego.blogs.servlets;

import javax.ws.rs.Path;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.github.vm.patlego.blogs.dao.repo.BlogsDS;
import io.github.vm.patlego.blogs.dao.tables.Blog;

@Path("/")
@Component(service = BlogsService.class, immediate =  true)
public class BlogsServiceImpl implements BlogsService {   

    @Reference
    private BlogsDS blogDS;

    @Path("/blogs")
    @Produces("application/json")
    @GET
    public List<Blog> getBlogs() {
        return this.blogDS.getBlogs();
    }
}
