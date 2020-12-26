package io.github.vm.patlego.impl;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import io.github.vm.patlego.email.bean.EmailRecipient;

public class DefaultEmailRecipient implements EmailRecipient {

    @Override
    public InternetAddress getFrom() throws AddressException {
        return new InternetAddress("patrique.legault@gmail.com");
    }

    @Override
    public InternetAddress getBounce() throws AddressException {
        return new InternetAddress("patrique.legault@gmail.com");
    }
    
}
