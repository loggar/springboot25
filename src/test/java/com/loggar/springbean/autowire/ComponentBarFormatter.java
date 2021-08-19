package com.loggar.springbean.autowire;

import org.springframework.stereotype.Component;

@Component("barFormatter")
public class ComponentBarFormatter implements IFormatter {
  public String format() {
    return "bar";
  }
}
