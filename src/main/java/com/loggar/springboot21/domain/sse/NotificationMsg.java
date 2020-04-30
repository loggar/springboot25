package com.loggar.springboot21.domain.sse;

public class NotificationMsg {
	String title;
	int count;
	String desc;

	public NotificationMsg(String title, int count, String desc) {
		super();
		this.title = title;
		this.count = count;
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificationMessage [title=").append(title).append(", count=").append(count).append(", desc=").append(desc).append("]");
		return builder.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
