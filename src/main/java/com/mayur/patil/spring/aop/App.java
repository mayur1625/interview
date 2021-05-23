package com.mayur.patil.spring.aop;

import com.mayur.patil.spring.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
  public static void main(String[] args)
  {
    ApplicationContext context = new ClassPathXmlApplicationContext("Customer.xml");
    Operation op = context.getBean("op", Operation.class);
    op.msg();
    op.k();
    op.m();

  }
}
