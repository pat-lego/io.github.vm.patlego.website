package io.github.vm.patlego.website.core.blogs;

import io.github.vm.patlego.mail.bean.EmailRecipient;

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
