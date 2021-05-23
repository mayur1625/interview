package com.mayur.patil.algo.bit;

public class BitCalculation
{
  public static void main(String[] args)
  {
    int i = -16;//0011
    int j = -2;//0100//1011
    //
    System.out.println(i>>>2);
    //>>  is referred to as the arithmetic shift
    //>>> is the logical shift.

    // 0 0 1 1
    // 1 1 1 0
    // 1 0 1 1
    // 1 1 0 0
    //-8 4 2 1
    // 1 1 1 1

    i = i << 1;//left shift for multiplication
    //System.out.println(i);
    //https://www.youtube.com/watch?v=oCBlwsY8sR4

  }
}
