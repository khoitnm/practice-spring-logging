package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import javax.servlet.http.HttpServletRequest;

public abstract class SimpleHttpPathMatcher {
    protected final String pattern;

    protected SimpleHttpPathMatcher(String pattern) {
        this.pattern = pattern;
    }

    abstract public boolean match(HttpServletRequest httpServletRequest);
}
