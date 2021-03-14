package io.github.vm.patlego.servlets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.vm.patlego.website.core.SiteServletPath;

public class TestSiteServletPath {

    @Test
    public void testPath() {
        assertEquals("/patlegovm/1.0/site", SiteServletPath.SITE_CLASS_PATH);
    }
    
}
