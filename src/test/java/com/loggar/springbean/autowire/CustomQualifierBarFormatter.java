package com.loggar.springbean.autowire;

import org.springframework.stereotype.Component;

@CustomQualifierFormatterType("Bar")
@Component
public class CustomQualifierBarFormatter implements IFormatter {
  public String format() {
    return "bar";
  }
}
