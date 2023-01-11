package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import org.springframework.http.server.PathContainer;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import javax.servlet.http.HttpServletRequest;

/**
 * This class will have higher performance than {@link SimpleHttpAntPathMatcher}.
 */
public class SimpleHttpPathPatternMatcher extends SimpleHttpPathMatcher {
    private final PathPattern pathPattern;

    protected SimpleHttpPathPatternMatcher(String pattern) {
        super(pattern);
        PathPatternParser pathPatternParser = new PathPatternParser();
        pathPattern = pathPatternParser.parse(pattern);
    }

    @Override
    public boolean match(HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        PathContainer lookupPath = PathContainer.parsePath(requestURI);
        boolean match = pathPattern.matches(lookupPath);
        return match;
    }
}
