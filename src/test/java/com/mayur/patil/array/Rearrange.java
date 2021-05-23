package com.mayur.patil.array;

import java.util.Arrays;

public class Rearrange
{
  public static void main(String[] args)
  {
    int[] arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
        11, 10, 9, 5, 13, 16, 2, 14, 17, 4};

    int[] temp = new int[arr.length];
    first:
    for (int i = 0; i < arr.length; i++)
    {
      second:
      for (int j = 0; j < arr.length; j++)
      {
        if (i == arr[j])
        {
          temp[i] = arr[j];
          continue first;
        }
        temp[i] = -1;
      }
    }

    System.out.println(Arrays.toString(temp));
  }
}
