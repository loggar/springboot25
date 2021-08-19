package com.loggar.springbean.scan;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

// @SpringBootApplication
public class SpringBootComponentScanApp {
  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private static ApplicationContext applicationContext;

  @Bean
  public ExampleBean exampleBean() {
    return new ExampleBean();
  }

  public static void test_main(String[] args) { /* main(String[] args) */
    applicationContext = SpringApplication.run(SpringBootComponentScanApp.class, args);
    checkBeansPresence("cat", "dog", "rose", "exampleBean", "springBootComponentScanApp");
    ((ConfigurableApplicationContext) applicationContext).close();

  }

  private static void checkBeansPresence(String... beans) {
    for (String beanName : beans) {
      logger.debug("{} in ApplicationContext: {}", beanName, applicationContext.containsBean(beanName));
    }
  }
}
