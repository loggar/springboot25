package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService7Name {
  // Spring uses the bean's name as a default qualifier value. It will inspect the
  // container and look for a bean with the exact name as the property to autowire
  // it.
  @Autowired
  private IFormatter fooFormatter;

  public String getData() {
    return fooFormatter.toString();
  }
}
