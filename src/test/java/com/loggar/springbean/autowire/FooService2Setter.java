package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService2Setter {
  private ComponentFooFormatter fooFormatter;

  // @Autowired on Setters
  @Autowired
  public void setFooFormatter(ComponentFooFormatter fooFormatter) {
    this.fooFormatter = fooFormatter;
  }

  public String getFormat() {
    return fooFormatter.format();
  }
}
