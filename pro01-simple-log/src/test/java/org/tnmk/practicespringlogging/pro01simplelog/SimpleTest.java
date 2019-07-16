package org.tnmk.practicespringlogging.pro01simplelog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro01simplelog.Pro01SimpleLogApplication;
import org.tnmk.practicespringlogging.pro01simplelog.story.SimpleLogWriting;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro01SimpleLogApplication.class)
public class SimpleTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();


    @Test
    public void testCanLoadListWithOneItem() {
        simpleLogWriting.writeHello();
    }

}
