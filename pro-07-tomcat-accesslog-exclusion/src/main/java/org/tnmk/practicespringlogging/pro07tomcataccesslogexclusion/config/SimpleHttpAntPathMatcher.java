package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;

public class SimpleHttpAntPathMatcher extends SimpleHttpPathMatcher {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    protected SimpleHttpAntPathMatcher(String pattern) {
        super(pattern);
    }

    @Override
    public boolean match(HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        boolean match = antPathMatcher.match(this.pattern, requestURI);
        return match;
    }
}
