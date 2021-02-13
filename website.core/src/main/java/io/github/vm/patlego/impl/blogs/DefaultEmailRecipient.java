package io.github.vm.patlego.impl.blogs;

import io.github.vm.patlego.email.bean.EmailRecipient;

public class DefaultEmailRecipient implements EmailRecipient {

    @Override
    public String getFrom() {
        return "patrique.legault@gmail.com";
    }

    @Override
    public String getBounce() {
        return "patrique.legault@gmail.com";
    }
    
}
