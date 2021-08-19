package com.loggar.springbean.autowire;

import org.springframework.stereotype.Component;

@CustomQualifierFormatterType("Foo")
@Component
public class CustomQualifierFooFormatter implements IFormatter {
  public String format() {
    return "foo";
  }
}
