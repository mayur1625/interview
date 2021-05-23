package com.mayur.patil;

public class Swap2
{
  public static void main(String[] args)
  {
    int a = 10, b = 5;
    System.out.println("A: " + a + ", B: " + b);

//    a = a ^ b;
//    b = a ^ b;
//    a = a ^ b;

//    b ^= (a ^= b);
//    a ^= b;
//    System.out.println("A: " + a + ", B: " + b);

    a = a ^ b ^ (b = a);

    System.out.println("A: " + a + ", B: " + b);

    String str = "ABCDEFGHIJKLMNO";
    char[] ch = str.toCharArray();
    for (int i = 0; i < ch.length / 2; i++)
    {
      ch[i] = (char) (ch[i] ^ ch[ch.length - 1 - i] ^ (ch[ch.length - 1 - i] = ch[i]));
    }
    System.out.println(new String(ch));

  }

}
