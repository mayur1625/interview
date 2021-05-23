package com.mayur.patil.spring.model;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class AroundMethod implements MethodInterceptor
{
  @Override public Object invoke(MethodInvocation methodInvocation) throws Throwable
  {
    System.out.println("Method name: " + methodInvocation.getMethod().getName());
    System.out.println("Method argument: " + Arrays.toString(methodInvocation.getArguments()));

    System.out.println("Before");

    try
    {
      Object result = methodInvocation.proceed();
      System.out.println("After");
      return result;
    }
    catch (Exception e)
    {
    }
    return null;
  }
}
