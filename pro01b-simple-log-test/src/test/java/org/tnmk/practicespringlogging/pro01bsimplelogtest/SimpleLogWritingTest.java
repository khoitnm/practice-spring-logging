package org.tnmk.practicespringlogging.pro01bsimplelogtest;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.tnmk.practicespringlogging.pro01bsimplelogtest.story.SimpleLogWriting;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleLogWritingTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();

    private ListAppender<ILoggingEvent> logAppender;
    private LoggerContext loggerContext;

    @BeforeEach
    void setup() {
        addLogAppenderToLoggerForTesting(simpleLogWriting.getClass());
    }


    @AfterEach
    void cleanUp() {
        cleanUpLogAppenderFromLogger(this.loggerContext, simpleLogWriting.getClass(), this.logAppender);
    }

    @Test
    public void testCanLoadListWithOneItem() {
        String name = "SomeName";

        // WHEN
        simpleLogWriting.writeNameToLog(name);

        // THEN
        String logMessage = getLogMessage(logAppender);
        assertThat(logMessage).contains(name);
    }

    private void addLogAppenderToLoggerForTesting(Class<?> clazz) {
        // Create a ListAppender to capture log events
        this.logAppender = new ListAppender<>();
        logAppender.start();

        this.loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        this.loggerContext.getLogger(clazz).addAppender(logAppender);
    }

    private static void cleanUpLogAppenderFromLogger(LoggerContext loggerContext, Class<?> clazz, ListAppender<ILoggingEvent> listAppender) {
        loggerContext.getLogger(clazz).detachAppender(listAppender);
    }

    private static String getLogMessage(ListAppender<ILoggingEvent> listAppender) {
        List<ILoggingEvent> loggingEvents = listAppender.list;
        assertThat(loggingEvents).hasSize(1);
        return loggingEvents.get(0).getFormattedMessage();
    }
}
