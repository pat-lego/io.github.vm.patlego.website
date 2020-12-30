package io.github.vm.patlego.servlets.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestBlogServletPath {

    @Test
    public void testGetBlogPath() {
        new BlogServletPath();
        assertEquals("/blogs", BlogServletPath.BLOG_METHOD_PATH);
        assertEquals("/patlegovm/1.0/site", BlogServletPath.SITE_CLASS_PATH);
    }
    
}
