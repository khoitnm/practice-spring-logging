package org.tnmk.practicespringlogging.pro01logbackspringprofile.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tnmk.practicespringlogging.pro01logbackspringprofile.AppInitiator;

public class SimpleLogWriting {
    public static Logger logger = LoggerFactory.getLogger(SimpleLogWriting.class);

    public void writeHello() {
        logger.info("Hi there Info");
        logger.info("{\"broken json}");//This message tries to cause broken json pattern
        logger.debug("Hi there Debug");
        logger.trace("Hi there Trace");
        try {
            throw new RuntimeException("Deliberated exception");
        } catch (Exception ex) {
            logger.error("writeHello "+ex.getMessage(), ex);
        }
    }
}
