package io.github.vm.patlego.website.core.blogs;

import java.util.List;

import io.github.vm.patlego.website.datasource.blogs.tables.Blog;

public interface BlogsService {

    public List<Blog> getBlogs();

    public Blog getBlog(Long id);
    
}
