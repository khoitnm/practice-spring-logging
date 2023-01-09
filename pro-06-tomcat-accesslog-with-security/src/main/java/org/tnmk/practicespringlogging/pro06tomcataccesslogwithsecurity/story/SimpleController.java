package org.tnmk.practicespringlogging.pro06tomcataccesslogwithsecurity.story;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.time.ZonedDateTime;

@RestController
public class SimpleController {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @GetMapping("/hello")
  public String hello() {
    String msg = "Hello_" + ZonedDateTime.now();
    logger.info(msg);
    return msg;
  }
}
