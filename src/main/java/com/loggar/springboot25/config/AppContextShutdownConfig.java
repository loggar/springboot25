package com.loggar.springboot25.config;

import com.loggar.springboot25.bean.context.TerminateBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContextShutdownConfig {
	@Bean
	public TerminateBean getTerminateBean() {
		return new TerminateBean();
	}
}
