package com.loggar.springboot25.task.schedulers;


import com.loggar.springboot25.util.bean.BeanUtilGetBeanUsage;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WiringSpringBeansTestJob {
	/*
	 * This example shows how to inject spring beans into classes not managed by spring
	 */
	@Scheduled(fixedRate = 75000)
	public void doSomething() {
		BeanUtilGetBeanUsage beanUtilGetBeanUsage = new BeanUtilGetBeanUsage();
		beanUtilGetBeanUsage.trig();
	}
}
