package com.loggar.springboot25.event.publisher;

import java.lang.invoke.MethodHandles;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SampleJobPublisher {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public final static Map<String, SseEmitter> EMITTERS = new ConcurrentHashMap<>();

	public void publish(long msg) {
		Iterator<Map.Entry<String, SseEmitter>> iterator = SampleJobPublisher.EMITTERS.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, SseEmitter> entry = iterator.next();
			SseEmitter emitter = entry.getValue();

			try {
				emitter.send(msg);
			} catch (Exception e) {
				emitter.completeWithError(e);
				SampleJobPublisher.EMITTERS.remove(entry.getKey());
				logger.debug("Remove EMITTER {} {}", entry.getKey(), emitter);
			}
		}
	}

	public void regist(String key, SseEmitter emitter) {
		emitter.onCompletion(() -> {
			logger.debug("Complete EMITTER {} {}", key, emitter);
		});
		emitter.onTimeout(() -> {
			logger.debug("Timeout EMITTER {} {}", key, emitter);
		});

		SampleJobPublisher.EMITTERS.put(key, emitter);
		logger.debug("Add EMITTER {} {}", key, emitter);
	}
}
