package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooService5Qualifier {
  @Autowired
  @Qualifier("fooFormatter")
  private IFormatter formatter;

  public String getData() {
    return formatter.toString();
  }
}
