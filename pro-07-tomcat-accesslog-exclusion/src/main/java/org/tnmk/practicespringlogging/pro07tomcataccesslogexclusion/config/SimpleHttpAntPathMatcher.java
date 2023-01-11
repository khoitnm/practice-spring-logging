package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

public class SimpleHttpAntPathMatcher implements SimpleHttpPathMatcher {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean match(String pathPattern, HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        boolean match = antPathMatcher.match(pathPattern, requestURI);
        return match;
    }
}
