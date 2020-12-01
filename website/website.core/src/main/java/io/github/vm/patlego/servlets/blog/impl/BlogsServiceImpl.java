package io.github.vm.patlego.servlets.blog.impl;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import javax.ws.rs.GET;

import io.github.vm.patlego.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.datasource.blogs.tables.Blog;
import io.github.vm.patlego.servlets.blog.BlogServletPath;
import io.github.vm.patlego.servlets.blog.BlogsService;

@Path(BlogServletPath.BLOG_METHOD_PATH)
public class BlogsServiceImpl implements BlogsService {

    private BlogsDS blogsDS;

    public BlogsServiceImpl(BlogsDS ds) {
        this.blogsDS = ds;
    }

    @Path("/")
    @Produces("application/json")
    @GET
    public List<Blog> getBlogs() {
        List<Blog> blogs = blogsDS.getBlogs();
        return blogs;
    }

}
