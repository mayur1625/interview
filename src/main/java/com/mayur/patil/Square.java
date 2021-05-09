package com.mayur.patil;

public class Square implements Shape
{

  private final int numberOfCorners = 4;

  @Override public int checkCorners()
  {
    return numberOfCorners;
  }

  @Override public int checkEdges()
  {
    return 4;
  }

}
