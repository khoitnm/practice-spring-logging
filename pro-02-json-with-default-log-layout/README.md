This module is used to demo that the configuration in `logback-spring.xml` could get an invalid JSON message.

In `SimpleLogWriting`, we'll see this code:
```
logger.info("{\"broken json}");//This message will cause broken json pattern
```

With the log pattern in `/pro-02-json-with-default-log-layout/src/main/resources/logback-spring.xml`, the result will be like this:
```
{
"severity": "INFO",
"service": "pro-02-json-with-default-log-layout",
"dd.trace_id": "",
"dd.span_id": "",
"trace-id": "",
"span-id": "",
"error-id": "",
"thread": "main",
"class": "AppInitiator",
"message": "{"broken json}",
"stacktrace": ""
}
```
As we see, the whole message is not a valid JSON format.
 
------------------------------------------------------------------------------------------------

With JacksonJsonFormatter (`pro01-simple-log/src/main/resources/logback-spring.xml#L16`), the result will be like this:
```
{
"timestamp" : "2021-06-05 14:53:23.357",
"level" : "INFO",
"thread" : "main",
"logger" : "org.tnmk.practicespringlogging.pro01simplelog.AppInitiator",
"message" : "{\"broken json}",
"context" : "default"
}
```
And that whole message is a valid JSON format.

When working with Filebeat and Logstash, they will usually work better with the JacksonJsonFormatter approach.


