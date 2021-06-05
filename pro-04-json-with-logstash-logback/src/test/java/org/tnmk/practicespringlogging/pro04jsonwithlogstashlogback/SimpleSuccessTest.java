package org.tnmk.practicespringlogging.pro04jsonwithlogstashlogback;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tnmk.practicespringlogging.pro04jsonwithlogstashlogback.story.SimpleLogWriting;

@SpringBootTest
public class SimpleSuccessTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();

    @Test
    public void when_writeLog_then_noException() {
        simpleLogWriting.writeHello();
    }

}
