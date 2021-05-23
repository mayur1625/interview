package com.mayur.patil.decimalpoints;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Decimal
{

  public static void main(String[] args)
  {

    int[] arr = {-4, 3, -9, 0, 4, 1};
    int total = arr.length;
    int[] sign = {0, 0, 0};
//    IntStream
//        .range(0, arr.length)
//        .map(i -> Integer.signum(arr[i]) == 0 ? sign[2]++ :
//            Integer.signum(arr[i]) == -1 ? sign[1]++ : sign[0]++
//        );

    for (int i = 0; i < total; i++)
    {
      if (Integer.signum(arr[i]) == 0)
      {
        sign[2]++;
      }
      else if (Integer.signum(arr[i]) == -1)
      {
        sign[1]++;
      }
      else
      {
        sign[0]++;
      }
    }
    IntStream
        .range(0, sign.length)
        .mapToDouble(i -> (double) sign[i] / 6)
        .mapToObj(val -> String.format("%.6f", val))
        .map(str -> str.substring(0, str.length() - 1))
        .forEach(System.out::println);

//    Arrays.stream(sign).map(a-> (double) sign[i] / total)
//    for (int i = 0; i < sign.length; i++)
//    {
//      double d1 = (double) sign[i] / total;
//      String str = String.format("%.6f", d1);
//      System.out.println(str.substring(0, str.length() - 1));
//    }
  }
}
