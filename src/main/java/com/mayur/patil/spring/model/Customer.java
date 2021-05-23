package com.mayur.patil.spring.model;

public class Customer
{
  private String name;
  private String url;

  public Customer()
  {
  }
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public void printName()
  {
    System.out.println("Customer name: " + name);
  }

  public void printURL()
  {
    System.out.println("Customer url: " + url);
  }

  public void printThrowException()
  {
    throw new IllegalArgumentException();
  }
}
