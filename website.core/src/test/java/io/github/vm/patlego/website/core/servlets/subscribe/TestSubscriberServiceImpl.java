package io.github.vm.patlego.website.core.servlets.subscribe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.vm.patlego.website.core.subscribe.SubscriberServiceImpl;
import io.github.vm.patlego.website.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.website.datasource.subscribe.tables.Subscribe;


public class TestSubscriberServiceImpl {

    @Test
    public void testAddSubscription() {
        SubscribeDS ds = Mockito.mock(SubscribeDS.class);
        Subscribe subscriber = new Subscribe();

        Mockito.when(ds.createSubscription(subscriber)).thenReturn(subscriber);

        SubscriberServiceImpl subscriberServiceImpl = new SubscriberServiceImpl(ds);

        assertNotNull(subscriberServiceImpl.addSubscription(subscriber));
    }

    @Test
    public void testDeleteSubscription() {
        SubscribeDS ds = Mockito.mock(SubscribeDS.class);
        Subscribe subscriber = new Subscribe();

        Mockito.when(ds.deleteSubscription(subscriber)).thenReturn(subscriber);

        SubscriberServiceImpl subscriberServiceImpl = new SubscriberServiceImpl(ds);

        assertNotNull(subscriberServiceImpl.deleteSubscription(subscriber));
    }

    @Test
    public void testDeleteSubscription_withString_Exception() throws IOException {
        SubscribeDS ds = Mockito.mock(SubscribeDS.class);

        Mockito.when(ds.deleteSubscription(Mockito.any())).thenThrow(IllegalArgumentException.class);
        
        SubscriberServiceImpl subscriberServiceImpl = new SubscriberServiceImpl(ds);

        assertNotNull(subscriberServiceImpl.deleteSubscription("pat@pat.com"));
    }

    @Test
    public void testDeleteSubscription_withString() throws IOException {
        SubscribeDS ds = Mockito.mock(SubscribeDS.class);
        Subscribe subscriber = new Subscribe();

        Mockito.when(ds.deleteSubscription(subscriber)).thenReturn(subscriber);
        
        SubscriberServiceImpl subscriberServiceImpl = new SubscriberServiceImpl(ds);

        assertNotNull(subscriberServiceImpl.deleteSubscription("pat@pat.com"));
    }
    
}
