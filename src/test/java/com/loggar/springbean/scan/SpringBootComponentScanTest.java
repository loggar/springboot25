package com.loggar.springbean.scan;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandles;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class SpringBootComponentScanTest {
  private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void scanComponentsAndPresenceCheck() {
    assertTrue(applicationContext.getBean(ExampleBean.class) != null);
    checkBeansPresence("cat", "dog", "exampleBean", "springBootComponentScanApp");
  }

  private void checkBeansPresence(String... beans) {
    for (String beanName : beans) {
      logger.debug("{} in ApplicationContext: {}", beanName, applicationContext.containsBean(beanName));
      assertTrue(applicationContext.containsBean(beanName));
    }
  }
}
