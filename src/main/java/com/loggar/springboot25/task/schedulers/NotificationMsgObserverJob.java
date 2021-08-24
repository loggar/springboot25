package com.loggar.springboot25.task.schedulers;

import com.loggar.springboot25.task.instances.NotificationMsgJobEnumSingleton;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificationMsgObserverJob {
  public final ApplicationEventPublisher eventPublisher;

  public NotificationMsgObserverJob(ApplicationEventPublisher eventPublisher) {
    this.eventPublisher = eventPublisher;
  }

  /*
   * This example shows how to create the singleton enum object which inject
   * spring bean to its method.
   */
  @Scheduled(fixedRate = 600000)
  public void doSomething() {
    NotificationMsgJobEnumSingleton NotificationMsgJobInstance = NotificationMsgJobEnumSingleton.INSTANCE;
    NotificationMsgJobInstance.trigNotificationMsg(1001);
  }
}
