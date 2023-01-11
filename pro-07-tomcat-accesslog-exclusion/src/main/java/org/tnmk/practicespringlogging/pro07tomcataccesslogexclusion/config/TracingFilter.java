package org.tnmk.practicespringlogging.pro07tomcataccesslogexclusion.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TracingFilter extends GenericFilterBean {
    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String HEADER_CORRELATION_ID = "CorrelationId";
    private static final String MDC_CORRELATION_ID = "CorrelationId";

    /**
     * This pattern is the AntPath pattern, so the matcher logic is relied on AntPathMatcher.
     *
     * Future improvement: use PathPattern instead. You can read more in:
     * - https://spring.io/blog/2020/06/30/url-matching-with-pathpattern-in-spring-mvc
     * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/util/pattern/PathPattern.html
     */
    private static final String ACCESS_LOG_EXCLUSION_PATH_PATTERN = "/actuator/**";
    private static final String ACCESS_LOG_EXCLUSION_HTTP_ATTRIBUTE_KEY = "no-access-log";
    private static final String ACCESS_LOG_EXCLUSION_HTTP_ATTRIBUTE_VALUE = "true";
    private final SimpleHttpPathMatcher simpleHttpPathMatcher = new SimpleHttpAntPathMatcher();

    @Override
    public void doFilter(
        ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        if (!(servletRequest instanceof HttpServletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        try {
            String pccCorrelationId = getOrGenerateCorrelationId(httpServletRequest);
            MDC.put(MDC_CORRELATION_ID, pccCorrelationId);

            markAccessLogExclusionIfMatching(httpServletRequest);

            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            Integer httpStatus = null;
            if (servletResponse instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpStatus = httpServletResponse.getStatus();
            }
            log.info("HttpRequest: {} {}, status: {}",
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURL().toString(),
                httpStatus);
            MDC.remove(MDC_CORRELATION_ID);
        }
    }

    private String getOrGenerateCorrelationId(HttpServletRequest httpServletRequest) {
        String correlationId = httpServletRequest.getHeader(HEADER_CORRELATION_ID);
        if (!StringUtils.hasText(correlationId)) {
            correlationId = generateCorrelationId();
        }
        return correlationId;
    }

    private void markAccessLogExclusionIfMatching(HttpServletRequest httpServletRequest) {
        if (simpleHttpPathMatcher.match(ACCESS_LOG_EXCLUSION_PATH_PATTERN, httpServletRequest)) {
            httpServletRequest.setAttribute(
                ACCESS_LOG_EXCLUSION_HTTP_ATTRIBUTE_KEY,
                ACCESS_LOG_EXCLUSION_HTTP_ATTRIBUTE_VALUE
            );
        }
    }

    private String generateCorrelationId() {
        String correlationId = UUID.randomUUID().toString();
        return correlationId;
    }
}
