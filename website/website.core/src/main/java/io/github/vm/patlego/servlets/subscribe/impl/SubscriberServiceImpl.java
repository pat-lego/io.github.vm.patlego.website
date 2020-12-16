package io.github.vm.patlego.servlets.subscribe.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.vm.patlego.datasource.subscribe.repo.SubscribeDS;
import io.github.vm.patlego.datasource.subscribe.tables.Subscribe;
import io.github.vm.patlego.servlets.subscribe.SubscribeService;
import io.github.vm.patlego.servlets.subscribe.SubscribeServletPath;

@Path(SubscribeServletPath.SUBSCRIBE_METHOD_PATH)
public class SubscriberServiceImpl implements SubscribeService {

    private SubscribeDS ds;

    public SubscriberServiceImpl(SubscribeDS subscribeDS) {
        this.ds = subscribeDS;
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Subscribe addSubscription(Subscribe subscriber) {
        return this.ds.createSubscription(subscriber);
    }

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Subscribe deleteSubscription(Subscribe subscribe) {
        return this.ds.deleteSubscription(subscribe);
    }

}
