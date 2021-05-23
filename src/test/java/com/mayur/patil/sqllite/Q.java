package com.mayur.patil.sqllite;

import java.util.Arrays;

public class Q
{
  public static void main(String[] args)
  {
    int[] arr = {6, 5, 4, 1, 2, 3};
    q(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void q(int[] arr, int l, int r)
  {
    if (l < r)
    {
      int pi = par(arr, l, r);
      q(arr, l, pi - 1);
      q(arr, pi + 1, r);
    }
  }

  public static int par(int[] arr, int l, int r)
  {
    int p = arr[r];
    int i = l - 1;
    for (int j = l; j <= r - 1; j++)
    {
      if (arr[j] < p)
      {
        swap(arr, ++i, j);
      }
    }
    swap(arr, i + 1, r);
    return i + 1;
  }

  public static void swap(int[] arr, int l, int r)
  {
    if (arr[l] == arr[r])
      return;
    arr[l] = arr[l] ^ arr[r] ^ (arr[r] = arr[l]);
  }
}
