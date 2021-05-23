package com.mayur.patil.spring;

import com.mayur.patil.spring.model.Customer;
import com.mayur.patil.spring.model.OneMethod;
import com.mayur.patil.spring.model.Print;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPExample
{
  public static void main(String[] args)
  {
    ApplicationContext context = new ClassPathXmlApplicationContext("Customer.xml");
//    Customer cust = context.getBean("customerService", Customer.class);
//    cust.printName();
//    cust.printURL();
//    try
//    {
//      cust.printThrowException();
//    }
//    catch (Exception e)
//    {
//      System.out.println(e);
//    }

    Customer customerService = context.getBean("service", Customer.class);
    customerService.printName();

    System.out.println("*************************************************");
//    Print method = context.getBean("cachedService", Print.class);
//    method.print();
  }
}
