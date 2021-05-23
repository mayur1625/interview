package com.mayur.patil.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Track
{
  @Pointcut("execution(* Operation.m*(..))")
  public void k(){}

  @Before("k()")
  public void myadvice(JoinPoint jp){
    System.out.println("Additional concern");
  }
}
