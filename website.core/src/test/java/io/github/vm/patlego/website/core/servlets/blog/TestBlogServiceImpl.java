package io.github.vm.patlego.website.core.servlets.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.vm.patlego.website.core.blogs.BlogsServiceImpl;
import io.github.vm.patlego.website.datasource.blogs.repo.BlogsDS;
import io.github.vm.patlego.website.datasource.blogs.tables.Blog;



public class TestBlogServiceImpl {

    @Test
    public void testGetBlogs() {
        BlogsDS ds = Mockito.mock(BlogsDS.class);
        Mockito.when(ds.getBlogs()).thenReturn(new ArrayList<Blog>());

        BlogsServiceImpl blogServiceImpl = new BlogsServiceImpl(ds);

        assertEquals(0, blogServiceImpl.getBlogs().size());
    }

    @Test
    public void testGetBlog() {
        BlogsDS ds = Mockito.mock(BlogsDS.class);
        Blog blog = new Blog();
        Mockito.when(ds.getBlog(1L)).thenReturn(blog);

        BlogsServiceImpl blogServiceImpl = new BlogsServiceImpl(ds);

        assertEquals(blog, blogServiceImpl.getBlog(1L));
    }

    @Test
    public void testGetBlog_Exception() {
        BlogsServiceImpl blogServiceImpl = new BlogsServiceImpl(null);

        assertThrows(IllegalArgumentException.class, () -> {
            blogServiceImpl.getBlog(-1L);
        });
     }

}
