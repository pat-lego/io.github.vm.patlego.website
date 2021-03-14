package io.github.vm.patlego.website.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.mail.internet.AddressException;

import org.junit.jupiter.api.Test;

import io.github.vm.patlego.website.core.blogs.DefaultEmailRecipient;

public class TestDefaultEmailRecipient {

    @Test
    public void testGetFrom() throws AddressException {
        DefaultEmailRecipient recipient = new DefaultEmailRecipient();
        assertEquals("patrique.legault@gmail.com", recipient.getFrom().toString());
    }

    @Test
    public void testGetBounce() throws AddressException {
        DefaultEmailRecipient recipient = new DefaultEmailRecipient();
        assertEquals("patrique.legault@gmail.com", recipient.getBounce().toString());
    }
    
}
