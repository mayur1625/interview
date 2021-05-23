package com.mayur.patil.spring.model;

import org.springframework.stereotype.Component;

public class Student
{
  private String name;
  private int id;
  private String course;
  private Address address;

  public Student()
  {
    System.out.println("Student constructor");
  }

  public Student(Address address)
  {
    this.address = address;
    System.out.println("Student: Address constructor");
  }

  public Address getAddress()
  {
    return address;
  }

  public void setAddress(Address address)
  {
    System.out.println("Address setAddress called");
    this.address = address;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getCourse()
  {
    return course;
  }

  public void setCourse(String course)
  {
    this.course = course;
  }

  @Override public String toString()
  {
    return "Student{" +
        "name='" + name + '\'' +
        ", id=" + id +
        ", course='" + course + '\'' +
        ", address=" + address +
        '}';
  }
//  public void myInit()
//  {
//    System.out.println("--Object Initialized--");
//  }
//
//  public void myDestroy()
//  {
//    System.out.println("--Object Destroyed--");
//  }

}
