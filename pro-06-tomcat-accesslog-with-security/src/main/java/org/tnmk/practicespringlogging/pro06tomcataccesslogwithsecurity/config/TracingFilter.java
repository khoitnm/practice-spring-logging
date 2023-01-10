package org.tnmk.practicespringlogging.pro06tomcataccesslogwithsecurity.config;

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

public class TracingFilter extends GenericFilterBean {
    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String HEADER_CORRELATION_ID = "CorrelationId";
    private static final String MDC_CORRELATION_ID = "CorrelationId";
    @Override
    public void doFilter(
        ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        try {
            String correlationId;
            if (servletRequest instanceof HttpServletRequest) {
                HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
                correlationId =
                    httpServletRequest.getHeader(HEADER_CORRELATION_ID);
                if (!StringUtils.hasText(correlationId)) {
                    correlationId = generateCorrelationId();
                }
            } else {
                correlationId = generateCorrelationId();
            }
            MDC.put(MDC_CORRELATION_ID, correlationId);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(MDC_CORRELATION_ID);
        }
    }

    private String generateCorrelationId() {
        String correlationId = UUID.randomUUID().toString();
        return correlationId;
    }
}
