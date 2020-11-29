package io.github.vm.patlego.blogs.servlets;

import java.util.List;

import io.github.vm.patlego.blogs.dao.tables.Blog;

public interface BlogsService {

    public List<Blog> getBlogs();
    
}
