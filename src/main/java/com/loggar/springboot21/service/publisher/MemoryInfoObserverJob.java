package com.loggar.springboot21.service.publisher;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.loggar.springboot21.domain.sse.MemoryInfo;

@Service
public class MemoryInfoObserverJob {
	public final ApplicationEventPublisher eventPublisher;

	public MemoryInfoObserverJob(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedRate = 60000)
	public void doSomething() {
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heap = memBean.getHeapMemoryUsage();
		MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

		MemoryInfo mi = new MemoryInfo(heap.getUsed(), nonHeap.getUsed());

		System.out.println("[log] Schedule MemoryObserverJob publishEvent: " + mi);

		this.eventPublisher.publishEvent(mi);
	}
}
