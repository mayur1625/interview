package com.mayur.patil.array;

import java.util.Arrays;

public class Rearrange2
{
  public static void main(String[] args)
  {
    int arr[] = {1, 2, 1, 4, 5, 6, 8, 8};

    Arrays.sort(arr);
    int mid = arr.length / 2;
    boolean even = (arr.length & 1) == 0;
    int temp[] = new int[arr.length];
    int k = mid + (even ? -1 : 0 ), l = mid + (even? 0 : 1);
    System.out.println("mid: " + mid);
    for (int j = 0; j < arr.length; j++)
    {
      if ((j & 1) == 0)
        temp[j] = arr[k--];
      else
        temp[j] = arr[l++];
    }
    System.out.println(Arrays.toString(temp));
  }
}
