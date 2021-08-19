package com.loggar.springbean.autowire;

import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class ComponentFooFormatter implements IFormatter {
  public String format() {
    return "foo";
  }
}
