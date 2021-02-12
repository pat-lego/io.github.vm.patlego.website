package io.github.vm.patlego.servlets.subscribe;

import java.io.IOException;

import io.github.vm.patlego.datasource.subscribe.tables.Subscribe;

public interface SubscribeService {
    
    public Subscribe addSubscription(Subscribe subscriber);

    public Subscribe deleteSubscription(Subscribe subscriber);

    public String deleteSubscription(String email) throws IOException;
}
