package com.loggar.springboot21.bean.util;

import com.loggar.springboot21.domain.sse.NotificationMsg;
import com.loggar.springboot21.event.publisher.NotificationMsgPublisher;

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
