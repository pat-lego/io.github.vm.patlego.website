package io.github.vm.patlego.datasource.subscribe.repo;

import java.util.List;

import io.github.vm.patlego.datasource.subscribe.tables.Subscribe;

public interface SubscribeDS {

    public Subscribe createSubscription(Subscribe subscribe);

    public List<Subscribe> getSubscriptions();

    public Subscribe deleteSubscription(Subscribe subscribe);

    public Subscribe getSubscription(String email);
    
}
