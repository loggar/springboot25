package com.loggar.springboot25.app.context;

import java.lang.invoke.MethodHandles;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TerminateBean {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@PreDestroy
	public void onDestroy() throws Exception {
		logger.info("Spring Container is destroyed!");
	}
}
