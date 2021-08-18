# SpringBoot Webapp

## version compatibility

- java openJDK 12
- springboot 2.5.3
- spring frameworks 5.3.9
- tomcat embed 9.0.52
- junit 5.0

## Dev console settings

```
$env:Path = "C:\Windows;C:\WINDOWS;C:\WINDOWS\system32;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\OpenSSH\;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\ProgramData\chocolatey\bin;C:\Program Files\dotnet\;C:\Program Files\Docker\Docker\resources\bin;C:\ProgramData\DockerDesktop\version-bin;C:\_dev\git\cmd;C:\Users\webnl\AppData\Local\nvs\";
$Env:JAVA_HOME = "C:\_dev\Java\openJDK-12"; $env:Path += ";C:\_dev\Java\openJDK-12\bin";
$Env:MAVEN_HOME = "C:\_dev\maven\apache-maven-3.8.1"; $env:Path += ";C:\_dev\maven\apache-maven-3.8.1\bin";
```

```
PS> java -version
openjdk version "12" 2019-03-19
OpenJDK Runtime Environment (build 12+33)
OpenJDK 64-Bit Server VM (build 12+33, mixed mode, sharing)

PS> mvn -v
Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
Maven home: C:\_dev\maven\apache-maven-3.8.1\bin\..
Java version: 12, vendor: Oracle Corporation, runtime: C:\_dev\Java\openJDK-12
Default locale: en_AU, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

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
