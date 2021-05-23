package com.mayur.patil.sorting.algo;

import java.util.Arrays;
import java.util.HashMap;

public class MyQuickSort
{

  public static void main(String[] args)
  {
    int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    MyQuickSort quick = new MyQuickSort();
    quick.quickSort(arr, 0, arr.length - 1);

    System.out.println(Arrays.toString(arr));
  }

  private void quickSort(int[] arr, int low, int high)
  {
    if (low < high)
    {

      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private int partition(int[] arr, int low, int high)
  {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high-1; j++)
    {
      if (arr[j] < pivot)
      {
        swap(arr, ++i, j);
      }
    }
    swap(arr, i + 1, high);
    return i + 1;
  }

  private void swap(int[] arr, int low, int high)
  {

    int temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;
  }

}
