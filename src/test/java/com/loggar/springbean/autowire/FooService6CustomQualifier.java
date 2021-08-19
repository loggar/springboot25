package com.loggar.springbean.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService6CustomQualifier {
  // The value specified in the @Target meta-annotation restricts where to apply
  // the qualifier, which in our example is fields, methods, types, and
  // parameters.
  @Autowired
  @CustomQualifierFormatterType("Foo")
  private IFormatter formatter;

  public String getData() {
    return formatter.toString();
  }
}
