package com.loggar.springboot21.event.publisher;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.loggar.springboot21.domain.sse.NotificationMsg;

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
