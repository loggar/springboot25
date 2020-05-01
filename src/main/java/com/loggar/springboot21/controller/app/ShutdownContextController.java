package com.loggar.springboot21.controller.app;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * curl -X POST localhost:<port>/<context-path>/shutdownContext
 * 
 */
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
