# view url mapping

### jsp

```java
@Configuration
@EnableWebMvc // <mvc:annotation-driven />
@ComponentScan(basePackages = "com.loggar.springboot25.controller") // <context:component-scan base-package="com.loggar.springboot25.controller" />
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		return bean;
	}
}
```

```
index page localhost:26080/springboot25/
other page localhost:26080/springboot25/other
```

## static file and url mapping

```java
@Configuration
public class StaticResourceConfiguration {

	@Bean
	public SimpleUrlHandlerMapping staticResourceHandlerMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setOrder(Integer.MIN_VALUE);
		mapping.setUrlMap(Collections.singletonMap("/static/**", staticResourceRequestHandler()));
		return mapping;
	}

	/*
	 * Notice that we have set Integer.MIN_VALUE for the mapping order, so give this handler the highest priority.
	 * With this configuration, we can store our resource file at any location within the application structure.
	 */
	@Bean
	protected ResourceHttpRequestHandler staticResourceRequestHandler() {
		ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
		ClassPathResource classPathResource = new ClassPathResource("static-mapping/");
		List<Resource> locations = Arrays.asList(classPathResource);
		requestHandler.setLocations(locations);
		return requestHandler;
	}
}

```

```
http://localhost:26080/springboot25/static/html/sample.html
http://localhost:26080/springboot25/static/text/sample.txt
```
