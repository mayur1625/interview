package com.mayur.patil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest
{

  @Test
  void noCorners()
  {
    Shape shape = new Circle();
    int checkCorners = shape.checkCorners();
    Assertions.assertEquals(0, checkCorners);
  }

}
