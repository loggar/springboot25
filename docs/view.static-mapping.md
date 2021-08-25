# view

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
