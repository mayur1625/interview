package com.mayur.patil.spring.model;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeMethod implements MethodBeforeAdvice
{
  @Override public void before(Method method, Object[] objects, Object o) throws Throwable
  {
    System.out.println("Before call");
  }
}
