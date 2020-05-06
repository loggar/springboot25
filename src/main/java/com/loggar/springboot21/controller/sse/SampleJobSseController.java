package com.loggar.springboot21.controller.sse;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.loggar.springboot21.domain.sse.NotificationMsg;

@RestController
public class SampleJobSseController {
	private static int STATIC_COUNT = 0;

	@GetMapping("/sse")
	public SseEmitter basico() throws IOException {
		SseEmitter emitter = new SseEmitter();
		emitter.send(new NotificationMsg("notificationA1", STATIC_COUNT++, "Notification Description"));
		return emitter;
	}
}
