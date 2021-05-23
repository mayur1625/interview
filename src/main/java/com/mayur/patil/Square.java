package com.mayur.patil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

public class Square implements Shape
{

  private final int numberOfCorners = 4;

  @Override public int checkCorners()
  {
    int i1 =10;
    int i2 =20;
    if (i1 != i2)
    {
      List<Integer> list = new ArrayList<>();
      Map<String, Integer> map = new HashMap<>();
      list.stream().forEach(System.out::print);


    }
    return numberOfCorners;
  }



  @Override public int checkEdges()
  {
    return 4;
  }

}
