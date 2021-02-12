package io.github.vm.patlego.servlets.subscribe;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.vm.patlego.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.datasource.subscribe.tables.Subscribe;
import io.github.vm.patlego.servlets.subscribe.impl.SubscriberServiceImpl;

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
