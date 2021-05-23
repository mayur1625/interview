package com.mayur.patil;

public class ReverseInteger
{
  public static void main(String[] args) throws InterruptedException
  {
    int value = 8910282, reverse = 0;
    while (value != 0)
    {
      reverse = value % 10 + reverse * 10;
      value = value / 10;
    }
  }
}
