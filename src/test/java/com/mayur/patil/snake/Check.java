package com.mayur.patil.snake;

public class Check
{
  public static void main(String[] args)
  {

    int[][] arr = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    while (true)
    {

      printArray(arr);
      try
      {
        Thread.sleep(1000 * 5);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }

  public static void printArray(int[][] arr)
  {

    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < arr.length; j++)
      {
        System.out.print(" " + arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("------------------------------------------");
  }
}
