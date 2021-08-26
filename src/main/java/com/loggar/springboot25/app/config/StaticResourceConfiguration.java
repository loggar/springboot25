package com.loggar.springboot25.app.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

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
