package org.tnmk.practicespringlogging.pro03jsonwithjacksonjsonformatter

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

public class SimpleSpec extends Specification{

    def 'test success'(){
        expect:
        1 == 1;
    }

    def 'test fail'(){
        expect:
        1 == 2;
    }
}