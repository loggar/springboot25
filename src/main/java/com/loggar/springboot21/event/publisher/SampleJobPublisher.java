package com.loggar.springboot21.event.publisher;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SampleJobPublisher {
	public final static Map<String, SseEmitter> EMITTERS = new ConcurrentHashMap<>();
	
	
}
