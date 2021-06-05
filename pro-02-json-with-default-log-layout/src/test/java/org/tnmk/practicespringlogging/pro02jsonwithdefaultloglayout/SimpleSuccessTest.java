package org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout.Pro02JsonWithDefaultLogLayoutApplication;
import org.tnmk.practicespringlogging.pro02jsonwithdefaultloglayout.story.SimpleLogWriting;

//Note: the profile is "componenttest", hence the corresonding Spring configuration is "application-componenttest.yml".
// However, the logback file in test is "logback-test.xml", which has nothing to do with the Spring profile name.
// It means that when running this test, it will write log with configuration in "logback-test.xml" in the `test` folder,
// not with "logback-spring.xml" in the `main` folder.
@ActiveProfiles("componenttest")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro02JsonWithDefaultLogLayoutApplication.class)
public class SimpleSuccessTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();


    @Test
    public void testCanLoadListWithOneItem() {
        simpleLogWriting.writeHello();
    }

}
