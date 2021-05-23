package com.mayur.patil.operand;

public class ArgumentLists
{
  public static void main(String[] args)
  {
    System.out.println(3 ^ 6);
    // 0 0 1 1
    // 0 1 1 0
    // 0 1 0 1
    String s = "go";
    print3(s, s= ", goa", s = ", gone");
  }
  static void print3(String a, String b, String c) {
    System.out.println(a + b + c);
  }
}
