package org.tnmk.practicespringlogging.pro01logbackspringprofile.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SimpleLogWriting {
    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public void writeHello() {
        logger.info("Hi there Info");
        logger.info("{\"broken json}");//This message tries to cause broken json pattern
        logger.debug("Hi there Debug");
        logger.trace("Hi there Trace");
        try {
            throw new RuntimeException("Deliberated exception");
        } catch (Exception ex) {
            logger.error("writeHello " + ex.getMessage(), ex);
        }
    }
}
