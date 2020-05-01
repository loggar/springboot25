package com.loggar.springboot21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextShutdownConfig {
	@Bean
	public TerminateBean getTerminateBean() {
		return new TerminateBean();
	}
}
