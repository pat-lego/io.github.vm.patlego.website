package io.github.vm.patlego.servlets.blog;

import java.util.List;

import io.github.vm.patlego.datasource.blogs.tables.Blog;

public interface BlogsService {

    public List<Blog> getBlogs();

    public Blog getBlog(Long id);
    
}
