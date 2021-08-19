package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService4Optional {
  // When a bean is being constructed, the @Autowired dependencies should be
  // available. Otherwise, if Spring cannot resolve a bean for wiring, it will
  // throw an exception.
  // To fix this, we need to declare a bean of the required type:
  @Autowired(required = false)
  private FooBeanNotDefinedYet fooBeanNotDefinedYet;

  public String getData() {
    return fooBeanNotDefinedYet.toString();
  }
}
