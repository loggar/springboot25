package com.loggar.springboot21.controller.sse;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.loggar.springboot21.event.publisher.SampleJobPublisher;

@RestController
@RequestMapping("/sampleJob")
public class SampleJobSseController {
	@Autowired SampleJobPublisher sampleJobPublisher;

	@GetMapping("/subscribe")
	public SseEmitter subscribe(HttpSession session) throws IOException {
		SseEmitter emitter = new SseEmitter();

		sampleJobPublisher.regist(session.getId(), emitter);

		return emitter;
	}
}
