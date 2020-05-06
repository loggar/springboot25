package com.loggar.springbean.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootComponentScanApp {
	private static ApplicationContext applicationContext;

	@Bean
	public ExampleBean exampleBean() {
		return new ExampleBean();
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringBootComponentScanApp.class, args);
		checkBeansPresence("cat", "dog", "rose", "exampleBean", "springBootComponentScanApp");
		((ConfigurableApplicationContext) applicationContext).close();

	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
		}
	}
}
