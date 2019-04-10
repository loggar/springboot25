package com.loggar.sprngboot21.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.loggar.springboot21.controller")
public class WebConfig {

}

/*
 * xml config equivalent
 * 
 * <context:component-scan base-package="com.baeldung.controller" /> <mvc:annotation-driven />
 */