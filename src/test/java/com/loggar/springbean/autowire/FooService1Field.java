package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService1Field {
  // @Autowired on field definitions
  @Autowired
  private ComponentFooFormatter fooFormatter;

  public String getFormat() {
    return fooFormatter.format();
  }
}
