package io.github.vm.patlego.servlets.subscribe.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

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

    @Path("/delete")
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Override
    public String deleteSubscription(@QueryParam("email") String email) throws IOException {
        Subscribe subscribe = new Subscribe();
        subscribe.setEmail(email);
        try {
            this.deleteSubscription(subscribe);
        } catch (Exception e) {
            return IOUtils.toString(this.getClass().getResourceAsStream("/unsubscribe/unsubscribe-error.html"), StandardCharsets.UTF_8);
        }
        return IOUtils.toString(this.getClass().getResourceAsStream("/unsubscribe/unsubscribe-success.html"), StandardCharsets.UTF_8);
    }

}
