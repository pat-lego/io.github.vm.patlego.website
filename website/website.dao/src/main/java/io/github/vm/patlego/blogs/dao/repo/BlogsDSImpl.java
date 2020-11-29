package io.github.vm.patlego.blogs.dao.repo;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.vm.patlego.blogs.dao.tables.Blog;

@Component(service = BlogsDS.class, immediate = true)
public class BlogsDSImpl implements BlogsDS {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(target = "(osgi.unit.name=karafdb-hibernate)")
    private JpaTemplate jpaTemplate;

    @Override
    public List<Blog> getBlogs() {
        return this.jpaTemplate.txExpr(TransactionType.RequiresNew, emFunction -> {
            CriteriaQuery<Blog> criteriaQueryBlogs = emFunction.getCriteriaBuilder()
                    .createQuery(Blog.class);
            TypedQuery<Blog> typedQuery = emFunction.createQuery(criteriaQueryBlogs);
            return typedQuery.getResultList();
        });
    }

    @Override
    public Blog getBlog(long id) {
        if (id > 0) {
            throw new IllegalArgumentException(
                    "Cannot supply an empty or null blog id in the getBlog function definition");
        }

        return this.jpaTemplate.txExpr(TransactionType.RequiresNew, emFunction -> {
            return emFunction.find(Blog.class, id);
        });
    }

    @Activate
    protected void activate() {
        logger.info(String.format("%s is now active", this.getClass().getName()));
    }

    @Modified
    protected void Modified() {
        logger.info(String.format("%s has been modified", this.getClass().getName()));
    }

    @Deactivate
    protected void deactivate() {
        logger.info(String.format("%s has been deactivated", this.getClass().getName()));
    }
}
