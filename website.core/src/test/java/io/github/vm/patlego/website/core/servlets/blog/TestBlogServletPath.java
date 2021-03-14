package io.github.vm.patlego.website.core.servlets.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.vm.patlego.website.core.blogs.BlogServletPath;

public class TestBlogServletPath {

    @Test
    public void testGetBlogPath() {
        new BlogServletPath();
        assertEquals("/blogs", BlogServletPath.BLOG_METHOD_PATH);
        assertEquals("/patlegovm/1.0/site", BlogServletPath.SITE_CLASS_PATH);
    }
    
}
