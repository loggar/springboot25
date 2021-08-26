package com.loggar.springboot25.util.bean;

import com.loggar.springboot25.event.publisher.NotificationMsgPublisher;
import com.loggar.springboot25.model.sse.NotificationMsg;

/*
 * Wiring Spring Beans Into Classes Not Managed by Spring
 * Example Usage of BeanUtil.getBean()
 */
public class BeanUtilGetBeanUsage {
	public void trig() {
		NotificationMsgPublisher notificationMsgPublisher = BeanUtil.getBean(NotificationMsgPublisher.class);
		NotificationMsg notificationMsg = new NotificationMsg(this.getClass().getName(), 0, "Notification Description");
		notificationMsgPublisher.publish(notificationMsg);
	}
}
