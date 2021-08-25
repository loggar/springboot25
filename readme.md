# SpringBoot Webapp

## version compatibility

- java open 12
- springboot 2.5.3
- spring frameworks 5.3.9
- tomcat embed 9.0.52
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
