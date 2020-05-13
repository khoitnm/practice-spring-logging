package org.tnmk.practicespringlogging.pro01simplelog

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles("componenttest")
@SpringBootTest(classes = Pro01SimpleLogApplication.class)
public class SimpleSpringSpec extends Specification{

    def 'test success'(){
        when:
        System.out.println("Run test success");

        then:
        1 == 1;
    }

    def 'test fail'(){
        when:
        System.out.println("Run test fail");

        then:
        1 == 2;
    }
}
