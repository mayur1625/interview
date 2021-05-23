package com.mayur.patil.algo.bit;

public class OppisiteSigns
{
  public static void main(String[] args)
  {
    System.out.println((10 ^ -19) < 0 ? "+" : "-");
    /*
    https://www.loginradius.com/blog/async/how-does-bitwise-xor-work/
    A   B   R
    0   0   0
    0   1   1
    1   0   1
    1   1   0
    */
  }
}
