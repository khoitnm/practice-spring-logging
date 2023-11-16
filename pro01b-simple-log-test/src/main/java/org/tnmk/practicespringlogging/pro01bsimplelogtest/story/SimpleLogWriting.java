package org.tnmk.practicespringlogging.pro01bsimplelogtest.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLogWriting {
    public static Logger logger = LoggerFactory.getLogger(SimpleLogWriting.class);

    public void writeNameToLog(String name) {
        logger.info("Hello, "+name);
    }
}
