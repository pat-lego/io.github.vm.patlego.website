package io.github.vm.patlego.datasource.blogs.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.vm.patlego.datasource.blogs.tables.Blog;

@Component(service = BlogsDS.class, immediate = true)
public class BlogsDSImpl implements BlogsDS {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference(target = "(osgi.unit.name=karafdb-hibernate-blogs)")
    private JpaTemplate jpaTemplate;

    @Override
    public List<Blog> getBlogs() {
        return this.jpaTemplate.txExpr(TransactionType.RequiresNew, emFunction -> {
            CriteriaQuery<Blog> criteriaQueryBlogs = emFunction.getCriteriaBuilder().createQuery(Blog.class);
            Root<Blog> variableRoot = criteriaQueryBlogs.from(Blog.class);
            
            criteriaQueryBlogs.select(variableRoot);
            return emFunction.createQuery(criteriaQueryBlogs).getResultList();
        });
    }

    @Override
    public Blog getBlog(Long id) {
        if (id != null && id <= 0) {
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
    protected void modified() {
        logger.info(String.format("%s has been modified", this.getClass().getName()));
    }

    @Deactivate
    protected void deactivate() {
        logger.info(String.format("%s has been deactivated", this.getClass().getName()));
    }
}
