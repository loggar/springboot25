package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService3Constructor {
  private ComponentFooFormatter fooFormatter;

  // @Autowired on Constructors
  @Autowired
  public FooService3Constructor(ComponentFooFormatter fooFormatter) {
    this.fooFormatter = fooFormatter;
  }

  public String getFormat() {
    return fooFormatter.format();
  }
}
