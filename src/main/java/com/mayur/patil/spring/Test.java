package com.mayur.patil.spring;

import com.mayur.patil.spring.model.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test
{
  public static void main(String[] args)
  {
    /*  BeanFactory Only construct the objects only on request */
    /*  Simple container providing the basic support for DI */
//    Resource resource = new ClassPathResource("applicationContext.xml");
//    BeanFactory factory = new XmlBeanFactory(resource);
//    Student std = factory.getBean("std", Student.class);
//    System.out.println(std);

    /*  ApplicationContext Always create objects if there is not requested or needed */
    /*  Build top on BeanFactory. This container add more enterprise-specific functionality */
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Student student = context.getBean("std", Student.class);
    System.out.println(student);

    ClassPathXmlApplicationContext cx = (ClassPathXmlApplicationContext) context;
    cx.close();

  }
}
