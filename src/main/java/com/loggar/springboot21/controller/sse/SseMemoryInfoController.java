package com.loggar.springboot21.controller.sse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.loggar.springboot21.domain.sse.MemoryInfo;

@Controller
@RequestMapping("/notification-memory")
public class SseMemoryInfoController {
	private final CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@GetMapping("/subscribe")
	public SseEmitter handle(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-store");

		// keep connection open for 30 seconds (or Tomcat server SSE HTTP connection setting)
		SseEmitter emitter = new SseEmitter();

		// keep connection open for 180 seconds
		// SseEmitter emitter = new SseEmitter(180_000L);

		this.emitters.add(emitter);

		emitter.onCompletion(() -> this.emitters.remove(emitter));
		emitter.onTimeout(() -> this.emitters.remove(emitter));

		System.out.println("[log] new emitter: " + emitter);

		return emitter;
	}

	@EventListener
	public void onMemoryInfo(MemoryInfo memoryInfo) {
		List<SseEmitter> deadEmitters = new ArrayList<>();

		System.out.println("[log] emitters: " + this.emitters.size());

		this.emitters.forEach(emitter -> {
			try {
				emitter.send(memoryInfo);

				// close connection, browser automatically reconnects
				// emitter.complete();

				// SseEventBuilder builder = SseEmitter.event().name("second").data("1");
				// SseEventBuilder builder =
				// SseEmitter.event().reconnectTime(10_000L).data(memoryInfo).id("1");
				// emitter.send(builder);
			} catch (Exception e) {
				deadEmitters.add(emitter);
				System.out.println("[log] dead emitters: " + this.emitters);
			}
		});

		this.emitters.removeAll(deadEmitters);
	}
}
