package com.loggar.springbean.autowire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Spring also allows us to create our own custom @Qualifier annotation. To do
 * so, we should provide the @Qualifier annotation with the definition:
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomQualifierFormatterType {
  String value();
}
