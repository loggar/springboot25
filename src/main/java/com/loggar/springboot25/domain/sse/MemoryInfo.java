package com.loggar.springboot25.domain.sse;

import java.util.Date;

public class MemoryInfo {
	private final long heap;

	private final long nonHeap;

	private final long ts;

	public MemoryInfo(long heap, long nonHeap) {
		super();
		this.heap = heap;
		this.nonHeap = nonHeap;
		this.ts = (new Date()).getTime();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemoryInfo [heap=").append(heap).append(", nonHeap=").append(nonHeap).append(", ts=").append(ts).append("]");
		return builder.toString();
	}

	public long getHeap() {
		return heap;
	}

	public long getNonHeap() {
		return nonHeap;
	}

	public long getTs() {
		return ts;
	}

}
