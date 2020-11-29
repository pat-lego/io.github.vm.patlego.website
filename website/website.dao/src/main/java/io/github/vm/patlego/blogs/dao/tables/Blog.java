package io.github.vm.patlego.blogs.dao.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "blogs")
@Table(name = "blogs", schema = "patlegovm")
public class Blog {
    
    @Id
    @Column(name = "blog_id", nullable = false, unique = true)
    private long blogId;

    @Column(name = "blog_title", nullable = false)
    private String blogTitle;

    @Column(name = "blog", columnDefinition = "TEXT", nullable = false)
    private String blog;

    @Column(name = "blog_author", nullable = false)
    private String blogAuthor;

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }
}
