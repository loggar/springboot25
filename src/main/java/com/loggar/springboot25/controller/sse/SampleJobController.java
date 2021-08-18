package com.loggar.springboot25.controller.sse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loggar.springboot25.event.publisher.SampleJobPublisher;

@RestController
@RequestMapping("/sampleJob")
public class SampleJobController {
	private static long STATIC_COUNT = 0;

	@Autowired SampleJobPublisher sampleJobPublisher;

	@GetMapping("/publish")
	public String publish() {
		sampleJobPublisher.publish(++STATIC_COUNT);
		return "SampleJob Publish: " + STATIC_COUNT;
	}
}
