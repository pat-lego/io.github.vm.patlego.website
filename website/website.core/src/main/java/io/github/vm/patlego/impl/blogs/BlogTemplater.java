package io.github.vm.patlego.impl.blogs;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.apache.commons.text.StringSubstitutor;

import io.github.vm.patlego.email.template.Templater;

public class BlogTemplater implements Templater {

    private Map<String, String> map;
   
    public BlogTemplater(Map<String, String> templateMap) {
        this.map = templateMap;
    }

    @Override
    public String templateString(String content) {
        if (map == null || content == null) {
            return StringUtils.EMPTY;
        }

        StringSubstitutor sub = new StringSubstitutor(map);
        return sub.replace(content);
    }
    
}
