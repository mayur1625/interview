package com.mayur.patil.wrappers;

public class IntWrap
{
  public static void main(String[] args)
  {
    Integer i1 = 127;
    Integer i2 = Integer.valueOf("127");
    System.out.println(i1 == i2);
    //Integer i2 = Integer.valueOf(1);
    System.out.println(i1.intValue());
  }
}
