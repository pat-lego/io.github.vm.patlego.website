package io.github.vm.patlego.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import io.github.vm.patlego.website.core.blogs.BlogTemplater;


public class TestBlogTemplater {

    @Test
    public void testBlog() {
        Map<String, String> mapper = new HashMap<String, String>();
        mapper.put("name", "Pat");

        String content = "Hello my name is ${name}";
        BlogTemplater templater = new BlogTemplater(mapper);

        assertEquals("Hello my name is Pat", templater.templateString(content));
    }

    @Test
    public void testBlog_nullString() {
        Map<String, String> mapper = new HashMap<String, String>();
        mapper.put("name", "Pat");

        String content = null;
        BlogTemplater templater = new BlogTemplater(mapper);

        assertEquals(StringUtils.EMPTY, templater.templateString(content));
    }

    @Test
    public void testBlog_emptyMap() {
        Map<String, String> mapper = new HashMap<String, String>();
        
        String content = "Hello my name is ${name}";
        BlogTemplater templater = new BlogTemplater(mapper);

        assertEquals("Hello my name is ${name}", templater.templateString(content));
    }

    @Test
    public void testBlog_null() { 
        String content = "Hello my name is ${name}";
        BlogTemplater templater = new BlogTemplater(null);

        assertEquals("Hello my name is ${name}", templater.templateString(content));
    }
    
}
