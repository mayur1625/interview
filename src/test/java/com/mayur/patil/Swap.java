package com.mayur.patil;

public class Swap
{
  //https://www.geeksforgeeks.org/swap-two-variables-in-one-line-in-c-c-python-php-and-java/
  //https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html

  public static void main(String[] args)
  {
    int[] x = {10};
    swap(x, x);
    System.out.println("After swap(&x, &x): x = " + x[0]);
    swap2(x, x);
    System.out.println("After swap(&x, &x): x = " + x[0]);
    int y = 5, z = 10;
    y = y ^ z ^ (z = y);
    System.out.println("After Swapping values of y: " + y + " and z: " + z);
  }

  static void swap(int[] xp, int[] yp)
  {
    if (xp[0] == yp[0]) // Check if the two addresses are same
      return;
    xp[0] = xp[0] ^ yp[0];
    yp[0] = xp[0] ^ yp[0];
    xp[0] = xp[0] ^ yp[0];
  }
  static void swap2(int[] xp, int[] yp)
  {
//    if (xp[0] == yp[0]) // Check if the two addresses are same
//      return;
    xp[0] = xp[0] ^ yp[0] ^ (yp[0] = xp[0]);
  }
}
