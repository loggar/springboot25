# SpringBoot 2.1 Webapp

## version compatibility

- java 1.8
- spring 5.1.5.RELEASE
- springboot 2.1.1.RELEASE
- tomcat embeded 9.0.34
- junit 5.0


## Run application

```
$ mvn clean package spring-boot:repackage
$ java -jar target/spring-boot-ops.war
```

```
$ mvn spring-boot:run
```

## SSE connection example

```
http://localhost:26080/springboot21/sample/eventsource-notification-client
```

Sample Trig SSE

```
$ curl http://localhost:26080/springboot21/notification-message/trig?count=100
```