package com.loggar.springboot25.task.instances;

import com.loggar.springboot25.bean.util.BeanUtil;
import com.loggar.springboot25.domain.sse.NotificationMsg;
import com.loggar.springboot25.event.publisher.NotificationMsgPublisher;

public enum NotificationMsgJobEnumSingleton {
  /*
   * Usage: NotificationMsgJobEnumSingleton NotificationMsgJobInstance =
   * NotificationMsgJobEnumSingleton.INSTANCE;
   */
  INSTANCE("Initial class info", 0);

  private String info;
  private int number;

  private NotificationMsgJobEnumSingleton(String info, int number) {
    this.info = info;
    this.number = number;
  }

  public NotificationMsgJobEnumSingleton getInstance() {
    return INSTANCE;
  }

  /*
   * This example shows how to create the singleton enum object which inject
   * spring bean to its method.
   */
  public void trigNotificationMsg(int count) {
    NotificationMsgPublisher notificationMsgPublisher = BeanUtil.getBean(NotificationMsgPublisher.class);
    NotificationMsg notificationMsg = new NotificationMsg(this.getClass().getName(), count, "Notification Description");
    notificationMsgPublisher.publish(notificationMsg);
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

}
