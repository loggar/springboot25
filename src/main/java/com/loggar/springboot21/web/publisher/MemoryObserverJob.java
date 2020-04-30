package com.loggar.springboot21.web.publisher;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.loggar.springboot21.domain.sse.MemoryInfo;

@Service
public class MemoryObserverJob {
	public final ApplicationEventPublisher eventPublisher;

	public MemoryObserverJob(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedRate = 10000)
	public void doSomething() {
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heap = memBean.getHeapMemoryUsage();
		MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

		MemoryInfo mi = new MemoryInfo(heap.getUsed(), nonHeap.getUsed());
		
		System.out.println("[log] Schedule MemoryObserverJob publishEvent: " + mi);
		
		this.eventPublisher.publishEvent(mi);
	}
}
