package com.loggar.springboot21.bean.util;

import com.loggar.springboot21.service.publisher.NotificationMsgPublisher;

/*
 * Autowiring Spring Beans Into Classes Not Managed by Spring
 * Example Usage of BeanUtil.getBean()
 */
public class BeanUtilGetBeanUsage {
	public void trig() {
		NotificationMsgPublisher notificationMsgPublisher = BeanUtil.getBean(NotificationMsgPublisher.class);
		notificationMsgPublisher.publish("notificationA1", 0, "Notification Description");
	}
}
