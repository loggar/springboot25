package com.loggar.springboot21.task.scheduler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.loggar.pattern.singleton.EnumSingleton;

@Service
public class NotificationMsgObserverJob {
	public final ApplicationEventPublisher eventPublisher;

	public NotificationMsgObserverJob(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	/*
	 * This example shows how to create the singleton enum object which inject spring bean to its method.
	 */
	@Scheduled(fixedRate = 55000)
	public void doSomething() {
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		enumSingleton.trigNotificationMsg(1001);
	}
}
