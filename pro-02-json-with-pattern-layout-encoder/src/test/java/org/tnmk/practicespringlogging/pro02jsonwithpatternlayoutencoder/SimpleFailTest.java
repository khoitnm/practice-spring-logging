package org.tnmk.practicespringlogging.pro02jsonwithpatternlayoutencoder;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tnmk.practicespringlogging.pro02jsonwithpatternlayoutencoder.story.SimpleLogWriting;

//Note: the profile is "componenttest", hence the corresonding Spring configuration is "application-componenttest.yml".
// However, the logback file in test is "logback-test.xml", which has nothing to do with the Spring profile name.
@ActiveProfiles("componenttest")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pro02JsonWithPatternLayoutEncoderApplication.class)
public class SimpleFailTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();


    @Test
    public void testWithException() {
        throwException();
    }

    @Test
    public void testWithWrongAssertion() {
        doSomethingNormal();
        assert 0 == 1;
    }

    public void doSomethingNormal(){
        System.out.println("Just do something...");
    }

    public void throwException() {
        throw new IllegalStateException("Some exception");
    }
}
