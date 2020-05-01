# Shutdown Springboot application and actuator port

Running Java Application `SpringBootApplicationMain.class` will shutdown its actuator port when it is terminated.

Running Java Application `SpringBootApplicationMain.class` on Eclipse IDE will shutdown its actuator port when it is terminated.

Run Maven build `mvn spring-boot:run` will shutdown its actuator port when it is terminated.

However, run `mvn spring-boot:run` on Eclipse IDE does not exit its actuator port when it is terminated on the IDE.

```
# Embeded Tomcat is running on Eclipse IDE and terminated on the console

$ netstat -ano | findstr :26080

  TCP    0.0.0.0:26080          0.0.0.0:0              LISTENING       1244
  TCP    [::]:26080             [::]:0                 LISTENING       1244
  
$ taskkill -pid 1244 /f

```

## Termination notifying bean

```java
public class TerminateBean {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@PreDestroy
	public void onDestroy() throws Exception {
		logger.info("Spring Container is destroyed!");
	}
}

```

```java
@Configuration
public class AppContextShutdownConfig {
	@Bean
	public TerminateBean getTerminateBean() {
		return new TerminateBean();
	}
}

```

## 1. Close the Current Application Context

Create our own custom endpoint:

```java
@RestController
public class ShutdownContextController implements ApplicationContextAware {
	private ApplicationContext context;

	@PostMapping("/shutdownContext")
	public void shutdownContext() {
		((ConfigurableApplicationContext) context).close();
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context = ctx;

	}
}

```

Call our new endpoint to shut down the current context:

```
curl -X POST localhost:<port>/<context-path>/shutdownContext
```

## 2. Close the Current Application Context with `spring-boot-starter-actuator`

Dependency

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

And, if we want to also set up security support, we need:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Enable the shutdown endpoint in `application.properties`

```ini
management.endpoints.web.exposure.include=*
management.endpoint.shutdown.enabled=true
endpoints.shutdown.enabled=true
```

In the example above, we've exposed all the actuator endpoints which will include the `/shutdown` endpoint.

Call the endpoint to shut down the context:

```
curl -X POST localhost:<port>/<context-path>/actuator/shutdown
```

## 3. Exit SpringApplication

SpringApplication registers a shutdown hook with the JVM to make sure the application exits appropriately.

Beans may implement the ExitCodeGenerator interface to return a specific error code:

```java
ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
  .web(WebApplicationType.NONE).run();
 
int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
@Override
public int getExitCode() {
        // return the error code
        return 0;
    }
});
 
System.exit(exitCode);
```

The same code with the application of Java 8 lambdas:

```java
SpringApplication.exit(ctx, () -> 0);
```

After calling the System.exit(exitCode), the program terminates with a 0 return code:

```
Process finished with exit code 0
```

## 4. Kill the App Process

We can also shut down a Spring Boot Application from outside the application by using a bash script. Our first step for this option is to have the application context write it's PID into a file:

```java
SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class)
  .web(WebApplicationType.NONE);
app.build().addListeners(new ApplicationPidFileWriter("./bin/shutdown.pid"));
app.run();
```

Next, create a `shutdown.bat` file with the following content:

```
kill $(cat ./bin/shutdown.pid)
```
