package com.loggar.springboot21.notbean;

import com.loggar.springboot21.bean.util.BeanUtil;
import com.loggar.springboot21.service.publisher.NotificationMsgPublisher;

/*
 * Autowiring Spring Beans Into Classes Not Managed by Spring
 * Example Usage of BeanUtil.getBean()
 */
public class BeanUtilUsage {
	public void trig() {
		NotificationMsgPublisher notificationMsgPublisher = BeanUtil.getBean(NotificationMsgPublisher.class);
		notificationMsgPublisher.publish("notificationA1", 0, "Notification Description");
	}
}
