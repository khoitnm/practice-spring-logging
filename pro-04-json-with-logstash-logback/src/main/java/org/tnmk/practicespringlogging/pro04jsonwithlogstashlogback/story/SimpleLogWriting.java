package org.tnmk.practicespringlogging.pro04jsonwithlogstashlogback.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.tnmk.practicespringlogging.pro04jsonwithlogstashlogback.AppInitiator;

public class SimpleLogWriting {
    public static Logger logger = LoggerFactory.getLogger(SimpleLogWriting.class);

    public void writeHello() {
        MDC.put("key01", "val01");
        MDC.put("key02", "val02");
        logger.info("Hi there Info");
        logger.info("{\"broken json}");//This message will cause broken json pattern
        logger.debug("Hi there Debug");
        logger.trace("Hi there Trace");
        try {
            throw new RuntimeException("Deliberated exception");
        } catch (Exception ex) {
            logger.error("Hi there Error: "+ex.getMessage(), ex);
        }
    }
}
