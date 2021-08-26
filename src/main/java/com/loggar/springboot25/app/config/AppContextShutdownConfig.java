package com.loggar.springboot25.app.config;

import com.loggar.springboot25.app.context.TerminateBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextShutdownConfig {
	@Bean
	public TerminateBean getTerminateBean() {
		return new TerminateBean();
	}
}
