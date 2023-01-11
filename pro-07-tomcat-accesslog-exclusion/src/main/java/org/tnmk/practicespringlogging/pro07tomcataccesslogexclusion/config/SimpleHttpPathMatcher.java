package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import javax.servlet.http.HttpServletRequest;

public interface SimpleHttpPathMatcher {

    boolean match(String pathPattern, HttpServletRequest httpServletRequest);
}
