package com.mayur.patil.problems;

public class SumOfDigit
{
  public static void main(String[] args)
  {
    int i = 1213;
    int sum = 0;
    while (i != 0)
    {
      sum += (i /= 10) % 10;
    }
    System.out.println("Sum: " + sum);
  }
}
