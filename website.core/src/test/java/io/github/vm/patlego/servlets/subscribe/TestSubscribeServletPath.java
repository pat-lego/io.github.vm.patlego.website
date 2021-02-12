package io.github.vm.patlego.servlets.subscribe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSubscribeServletPath {

    @Test
    public void testSubscribeServletPath() {
        new SubscribeServletPath();
        assertEquals("/subscribe", SubscribeServletPath.SUBSCRIBE_METHOD_PATH);
        assertEquals("/patlegovm/1.0/site", SubscribeServletPath.SITE_CLASS_PATH);
    }
    
}
