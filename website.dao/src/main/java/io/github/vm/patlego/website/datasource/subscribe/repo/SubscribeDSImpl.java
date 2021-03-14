package io.github.vm.patlego.website.datasource.subscribe.repo;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.github.vm.patlego.website.datasource.subscribe.tables.Subscribe;

@Component(service = SubscribeDS.class, immediate = true)
public class SubscribeDSImpl implements SubscribeDS {

    @Reference(target = "(osgi.unit.name=karafdb-hibernate-blogs)")
    private JpaTemplate jpaTemplate;

    public Subscribe lowerCaseEmail(Subscribe subscribe) {
        subscribe.setEmail(subscribe.getEmail().toLowerCase());
        return subscribe;
    }

    @Override
    public Subscribe createSubscription(Subscribe subscribe) {
        if (subscribe == null || subscribe.getEmail() == null || subscribe.getEmail().isEmpty()) {
            throw new IllegalArgumentException(
                    "Cannot create an empty subscription, please make sure that the email is present");
        }

        this.lowerCaseEmail(subscribe);
        jpaTemplate.tx(TransactionType.RequiresNew, emFunction -> {
            emFunction.persist(subscribe);
            emFunction.flush();
        });

        return subscribe;

    }

    @Override
    public List<Subscribe> getSubscriptions() {
        return this.jpaTemplate.txExpr(TransactionType.RequiresNew, emFunction -> {
            CriteriaQuery<Subscribe> criteriaQuerySubscribe = emFunction.getCriteriaBuilder()
                    .createQuery(Subscribe.class);
            Root<Subscribe> subscribeRoot = criteriaQuerySubscribe.from(Subscribe.class);
            criteriaQuerySubscribe.select(subscribeRoot);
            TypedQuery<Subscribe> typedQuery = emFunction.createQuery(criteriaQuerySubscribe);
            return typedQuery.getResultList();
        });
    }

    @Override
    public Subscribe deleteSubscription(Subscribe subscribe) {
        if (subscribe == null || subscribe.getEmail() == null || subscribe.getEmail().isEmpty()) {
            throw new IllegalArgumentException(
                    "Cannot delete a non existing subscription, please make sure that the email is present");
        }

        this.lowerCaseEmail(subscribe);
        jpaTemplate.tx(TransactionType.RequiresNew, emFunction -> {
            if (emFunction.contains(subscribe)) {
                emFunction.remove(subscribe);
            } else {
                Subscribe reference = emFunction.getReference(Subscribe.class, subscribe.getEmail());
                emFunction.remove(reference);
            }
            emFunction.flush();
        });

        return subscribe;
    }

    @Override
    public Subscribe getSubscription(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException(
                    "Subscriptions require an email address to be present, please make sure that all Subscriptions have a valid email when querying for a Subscription");
        }

        return jpaTemplate.txExpr(TransactionType.RequiresNew, emFunction -> {
            return emFunction.find(Subscribe.class, email);
        });
    }

}
