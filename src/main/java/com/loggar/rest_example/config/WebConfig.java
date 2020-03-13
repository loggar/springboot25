package com.loggar.rest_example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc // <mvc:annotation-driven />
@ComponentScan(basePackages = "com.loggar.springboot21.controller") // <context:component-scan base-package="com.loggar.springboot21.controllerr" />
public class WebConfig {

}
