package com.mayur.patil.array;

import java.util.Arrays;

public class ReverseArray
{
  public static void main(String[] args)
  {
    int[] arr = {4, 3, 5, 2, 1, 3, 5, 6};
    Arrays.sort(arr);
    for (int i = 0; i < arr.length / 2; i++)
    {
      System.out.println();
      arr[arr.length - 1 - i] = arr[arr.length - 1 - i] ^ arr[i] ^ (arr[i] = arr[arr.length - 1 - i]);
    }
    System.out.println(Arrays.toString(arr));
  }
}
