package com.mayur.patil.sorting.algo;

import java.util.Arrays;

public class Quick
{
  // A utility function to swap two elements
  static void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /* This function takes last element as pivot, places
     the pivot element at its correct position in sorted
     array, and places all smaller (smaller than pivot)
     to left of pivot and all greater elements to right
     of pivot */
  static int partition(int[] arr, int left, int right)
  {

    // pivot
    int pivot = arr[right];

    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (left - 1);
    for (int j = left; j <= right - 1; j++)
    {

      // If current element is smaller
      // than the pivot
      if (arr[j] < pivot)
      {

        // Increment index of
        // smaller element
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, right);
    return (i + 1);
  }

  /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
   */
  static void quickSort(int[] arr, int left, int right)
  {
    if (left < right)
    {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(arr, left, right);

      // Separately sort elements before
      // partition and after partition
      quickSort(arr, left, pi - 1);
      quickSort(arr, pi + 1, right);
    }
  }

  // Driver Code
  public static void main(String[] args)
  {
    int[] arr = {10, 7, 8, 9, 1, 5};
    int n = arr.length;
    quickSort(arr, 0, n - 1);
  }


}
