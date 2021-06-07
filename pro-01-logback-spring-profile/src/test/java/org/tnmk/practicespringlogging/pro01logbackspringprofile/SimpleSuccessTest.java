package org.tnmk.practicespringlogging.pro01logbackspringprofile;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.tnmk.practicespringlogging.pro01logbackspringprofile.story.SimpleLogWriting;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//Note: the profile is "componenttest", hence the corresonding Spring configuration is "application-componenttest.yml".
// However, the logback file in test is "logback-test.xml", which has nothing to do with the Spring profile name.
// It means that when running this test, it will write log with configuration in "logback-test.xml" in the `test` folder,
// not with "logback-spring.xml" in the `main` folder.
@ActiveProfiles("componenttest")
@SpringBootTest(classes = Pro01LogbackSpringProfileApplication.class)
public class SimpleSuccessTest {

  private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();

  @Test
  void when_startApplication_then_logMessagesWillAutomaticallyWritten() throws Exception {
    // get Logback Logger
    Logger testLogger = (Logger) LoggerFactory.getLogger(SimpleLogWriting.class);
    testLogger.setLevel(Level.ALL);

    // create and start a ListAppender
    ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
    listAppender.start();

    // add the appender to the logger
    testLogger.addAppender(listAppender);

    // call method under test
    simpleLogWriting.writeHello();

    // JUnit assertions
    List<ILoggingEvent> logsList = listAppender.list;
    assertEquals("Hi there Info", logsList.get(0).getMessage());
    assertEquals(Level.INFO, logsList.get(0).getLevel());

    assertNotNull(logsList.get(1).getMessage());
    assertEquals(Level.INFO, logsList.get(1).getLevel());
    assertEquals(Level.DEBUG, logsList.get(2).getLevel());
    assertEquals(Level.TRACE, logsList.get(3).getLevel());
  }
}
