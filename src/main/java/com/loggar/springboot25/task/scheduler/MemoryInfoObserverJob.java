package com.loggar.springboot25.task.scheduler;

import java.lang.invoke.MethodHandles;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.loggar.springboot25.domain.sse.MemoryInfo;

@Service
public class MemoryInfoObserverJob {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public final ApplicationEventPublisher eventPublisher;

	public MemoryInfoObserverJob(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(fixedRate = 60000)
	public void publishEvent() {
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage heap = memBean.getHeapMemoryUsage();
		MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

		MemoryInfo mi = new MemoryInfo(heap.getUsed(), nonHeap.getUsed());

		logger.debug("Schedule MemoryObserverJob publishEvent: {}", mi);

		this.eventPublisher.publishEvent(mi);
	}
}
