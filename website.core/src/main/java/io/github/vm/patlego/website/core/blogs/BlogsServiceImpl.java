package io.github.vm.patlego.website.core.blogs;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

import javax.ws.rs.GET;

import io.github.vm.patlego.website.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.website.datasource.blogs.tables.Blog;
import io.github.vm.patlego.website.core.blogs.BlogServletPath;
import io.github.vm.patlego.website.core.blogs.BlogsService;

@Path(BlogServletPath.BLOG_METHOD_PATH)
public class BlogsServiceImpl implements BlogsService {

    private BlogsDS blogsDS;

    public BlogsServiceImpl(BlogsDS ds) {
        this.blogsDS = ds;
    }

    @Path("/")
    @Produces("application/json")
    @GET
    @Override
    public List<Blog> getBlogs() {
        List<Blog> blogs = blogsDS.getBlogs();
        return blogs;
    }

    @Path("/{id}")
    @Produces("application/json")
    @GET
    @Override
    public Blog getBlog(@PathParam("id") Long id) {
        if (id != null && id > 0) {
            return this.blogsDS.getBlog(id);
        }
        throw new IllegalArgumentException("id for blog must be bigger then 0");
    }

}
