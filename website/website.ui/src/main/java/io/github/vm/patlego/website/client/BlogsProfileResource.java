package io.github.vm.patlego.website.client;

import org.osgi.service.component.annotations.Component;

/**
 * This resource will allow URL's to navigate straight to the profile/contact page and not have to click on 
 * the Contact button to be routed to the Contact page
 */
@Component(immediate = true, 
    service = BlogsProfileResource.class, 
    property = { 
        "osgi.http.whiteboard.resource.pattern=/profile/blogs/*", 
        "osgi.http.whiteboard.resource.prefix=/profile"
    })
public class BlogsProfileResource {

}