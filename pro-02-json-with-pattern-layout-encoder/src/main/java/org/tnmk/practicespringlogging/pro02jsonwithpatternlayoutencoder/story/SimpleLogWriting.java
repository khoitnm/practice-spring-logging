package org.tnmk.practicespringlogging.pro02jsonwithpatternlayoutencoder.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tnmk.practicespringlogging.pro02jsonwithpatternlayoutencoder.AppInitiator;

public class SimpleLogWriting {
    public static Logger logger = LoggerFactory.getLogger(AppInitiator.class);

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
