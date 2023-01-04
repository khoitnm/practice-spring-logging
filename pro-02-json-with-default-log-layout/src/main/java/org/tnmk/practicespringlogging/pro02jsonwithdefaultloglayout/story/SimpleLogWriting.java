package org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout.AppInitiator;

import java.lang.invoke.MethodHandles;

public class SimpleLogWriting {
    private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public void writeHello() {
        logger.info("Hi there Info");
        logger.info("{\"broken json}");//This message will cause broken json pattern
        logger.debug("Hi there Debug");
        logger.trace("Hi there Trace");
        try {
            throw new RuntimeException("Deliberated exception");
        } catch (Exception ex) {
            logger.error("writeHello "+ex.getMessage(), ex);
        }
    }
}
