package io.github.vm.patlego.blogs.dao.repo;

import java.util.List;

import io.github.vm.patlego.blogs.dao.tables.Blog;

public interface BlogsDS {

    public List<Blog> getBlogs();
    
    public Blog getBlog(long id);
}
