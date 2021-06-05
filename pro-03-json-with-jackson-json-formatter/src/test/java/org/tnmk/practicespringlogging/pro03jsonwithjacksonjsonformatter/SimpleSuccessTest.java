package org.tnmk.practicespringlogging.pro03jsonwithjacksonjsonformatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro03jsonwithjacksonjsonformatter.story.SimpleLogWriting;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSuccessTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();

    @Test
    public void testCanLoadListWithOneItem() {
        simpleLogWriting.writeHello();
    }

}
