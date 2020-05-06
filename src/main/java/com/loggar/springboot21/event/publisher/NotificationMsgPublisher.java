package com.loggar.springboot21.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.loggar.springboot21.domain.sse.NotificationMsg;

@Service
public class NotificationMsgPublisher {
	public final ApplicationEventPublisher eventPublisher;

	public NotificationMsgPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public void publish(NotificationMsg notificationMsg) {
		System.out.println("[log] Service NotificationMsgPublisher publishEvent: " + notificationMsg);
		this.eventPublisher.publishEvent(notificationMsg);
	}
}
