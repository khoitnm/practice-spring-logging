package org.tnmk.practicespringlogging.pro03jsonwithjacksonjsonformatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tnmk.practicespringlogging.pro03jsonwithjacksonjsonformatter.story.SimpleLogWriting;

@SpringBootTest
public class SimpleSuccessTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();

    @Test
    public void testCanLoadListWithOneItem() {
        simpleLogWriting.writeHello();
    }

}
