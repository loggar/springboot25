package com.loggar.springboot25.event.publisher;

import java.lang.invoke.MethodHandles;

import com.loggar.springboot25.model.sse.NotificationMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class NotificationMsgPublisher {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public final ApplicationEventPublisher eventPublisher;

	public NotificationMsgPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public void publish(NotificationMsg notificationMsg) {
		logger.debug("NotificationMsgPublisher publishEvent: {}", notificationMsg);
		this.eventPublisher.publishEvent(notificationMsg);
	}
}
