package io.github.vm.patlego.servlets.subscribe.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import io.github.vm.patlego.servlets.subscribe.SubscribeService;
import io.github.vm.patlego.servlets.subscribe.SubscribeServletPath;
import io.github.vm.patlego.servlets.subscribe.Subscriber;

@Path(SubscribeServletPath.SUBSCRIBE_METHOD_PATH)
public class SubscriberServiceImpl implements SubscribeService {

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addSubscription(Subscriber subscriber) {
        String firstName = subscriber.getFirstName();
        String lastName = subscriber.getLastName();

        String fullName = firstName + lastName;
    }

}
