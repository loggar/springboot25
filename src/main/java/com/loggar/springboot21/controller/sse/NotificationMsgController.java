package com.loggar.springboot21.controller.sse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loggar.springboot21.service.publisher.NotificationMsgPublisher;

@Controller
@RequestMapping("/notification-message")
public class NotificationMsgController {
	@Autowired NotificationMsgPublisher notificationMsgPublisher;

	// trig publish - NotificationMsgPublisher
	// curl http://localhost:26080/springboot21/notification-message/trig?count=100
	@RequestMapping(value = "/trig", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String trig(@RequestParam int count) {
		notificationMsgPublisher.publish("notificationA1", count, "Notification Description");
		return "done";
	}
}
