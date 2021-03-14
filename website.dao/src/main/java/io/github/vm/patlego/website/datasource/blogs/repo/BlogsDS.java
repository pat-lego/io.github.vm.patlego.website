package io.github.vm.patlego.website.datasource.blogs.repo;

import java.util.List;

import io.github.vm.patlego.website.datasource.blogs.tables.Blog;

public interface BlogsDS {

    public List<Blog> getBlogs();
    
    public Blog getBlog(Long id);
}
