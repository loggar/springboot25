package com.loggar.springboot21.service.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.loggar.springboot21.domain.sse.NotificationMsg;

@Service
public class NotificationMsgPublisher {
	public final ApplicationEventPublisher eventPublisher;

	public NotificationMsgPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public void publish(String title, int count, String desc) {
		NotificationMsg notificationMessage = new NotificationMsg(title, count, desc);

		System.out.println("[log] Service NotificationMessagePublisher publishEvent: " + notificationMessage);

		this.eventPublisher.publishEvent(notificationMessage);
	}
}
