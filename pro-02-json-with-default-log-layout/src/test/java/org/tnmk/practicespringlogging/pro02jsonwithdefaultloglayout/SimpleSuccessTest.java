package org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout.Pro02JsonWithDefaultLogLayoutApplication;
import org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout.story.SimpleLogWriting;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro02JsonWithDefaultLogLayoutApplication.class)
public class SimpleSuccessTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();


    @Test
    public void testCanLoadListWithOneItem() {
        simpleLogWriting.writeHello();
    }

}
