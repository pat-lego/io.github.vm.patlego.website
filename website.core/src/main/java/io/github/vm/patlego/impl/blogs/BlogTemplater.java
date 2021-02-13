package io.github.vm.patlego.impl.blogs;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.apache.commons.text.StringSubstitutor;

import io.github.vm.patlego.mail.template.Templater;

public class BlogTemplater implements Templater {

    private Map<String, String> map;

    public BlogTemplater(Map<String, String> templateMap) {
        if (templateMap == null) {
            map = new HashMap<String, String>();
        } else {
            this.map = templateMap;
        }
    }

    @Override
    public String templateString(String content) {
        if (content == null) {
            return StringUtils.EMPTY;
        }

        StringSubstitutor sub = new StringSubstitutor(map);
        return sub.replace(content);
    }

}
