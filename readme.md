# SpringBoot Webapp

## version compatibility

- java openJDK 12
- springboot 2.5.3
- spring frameworks 5.3.9
- tomcat embeded 9.0.52
- junit 5.0


## Run application

```
$ mvn clean package spring-boot:repackage
$ java -jar target/spring-boot-ops.war
```

```
$ mvn spring-boot:run
```

## Shutdown application

```
curl -X POST localhost:<port>/<context-path>/shutdownContext

curl -X POST localhost:26080/springboot25/shutdownContext
```

## Views

### jsp

```
index page localhost:26080/springboot25/
other page localhost:26080/springboot25/other
```

## SSE connection example

### views

```
http://localhost:<port>/<context-path>/sample/eventsource-memoryinfo-client

http://localhost:<port>/<context-path>/sample/eventsource-notification-client
http://localhost:26080/springboot25/sample/eventsource-notification-client

http://localhost:<port>/<context-path>/sample/eventsource-samplejob-client
http://localhost:26080/springboot25/sample/eventsource-samplejob-client
```

### Sample Trig SSE

```
$ curl http://localhost:<port>/<context-path>/notification-message/trig?count=100
$ curl http://localhost:26080/springboot25/notification-message/trig?count=100

$ curl http://localhost:<port>/<context-path>/sampleJob/publish
$ curl http://localhost:26080/springboot25/sampleJob/publish
```
