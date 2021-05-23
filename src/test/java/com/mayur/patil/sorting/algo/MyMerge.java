package com.mayur.patil.sorting.algo;

import java.util.Arrays;

public class MyMerge
{
  public static void main(String[] args)
  {
    int[] arr = {9, 7, 5, 3, 1};
    System.out.println("Before Sort:: " + Arrays.toString(arr));
    sort(arr, 0, arr.length - 1);
    System.out.println("After  Sort:: " + Arrays.toString(arr));
  }

  public static void sort(int[] arr, int l, int r)
  {
    if (l < r)
    {
      int m = l + ((r - l)>>1);
      sort(arr, l, m);//0,2
      sort(arr, m + 1, r);
      partitioning(arr, l, m, r);
    }
  }

  public static void partitioning(int[] arr, int l, int m, int r)
  {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[l + i];

    for (int j = 0; j < n2; j++)
      R[j] = arr[m + 1 + j];

    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2)
    {
      if (L[i] <= R[j])
        arr[k++] = L[i++];
      else
        arr[k++] = R[j++];
    }

    while (i < n1)
      arr[k++] = L[i++];

    while (j < n2)
      arr[k++] = R[j++];
  }
}
