package com.mayur.patil.algo.bit;

import java.util.Arrays;

public class BitExample1
{
  public static void main(String[] args)
  {
    int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < arr.length; i += 3)
    {
      if (arr[i] != arr[i + 1] || arr[i + 1] != arr[i + 2])
      {

        int res = arr[i] == arr[i + 1] ? arr[i + 2] : arr[i + 1] == arr[i + 2] ? arr[i] : arr[i + 1];
        System.out.print(res + " ");
        break;

      }

    }
  }

  private static void quickSort(int[] arr, int low, int high)
  {
    if (low < high)
    {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high)
  {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j <= high - 1; j++)
    {
      if (arr[j] < pivot)
      {
        i++;
        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
