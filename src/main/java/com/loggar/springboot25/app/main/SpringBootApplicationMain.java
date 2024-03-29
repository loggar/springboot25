package com.loggar.springboot25.app.main;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = { "com.loggar.springboot25.event", "com.loggar.springboot25.repository",
    "com.loggar.springboot25.task", "com.loggar.springboot25.util" })
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringBootApplicationMain {
  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicationMain.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      logger.debug("Inspect the beans provided by Spring Boot: {}", Arrays.toString(beanNames));
    };
  }
}