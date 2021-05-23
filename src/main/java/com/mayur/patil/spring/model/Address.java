package com.mayur.patil.spring.model;

import lombok.Data;

@Data
public class Address
{
  private String city;
  private String state;
  private int pinCode;

  public Address()
  {
    System.out.println("Address:Constructed");
  }
}
