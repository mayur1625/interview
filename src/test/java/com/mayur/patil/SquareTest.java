package com.mayur.patil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SquareTest
{
  // Cnt + E
  // Alt + 1
  // Alt + Insert
  // Cnt + Alt + v
  // Alt + Enter
  // Cnt + Y delete line
  // Cnt + Shift + T Switch between codes / to go test or respective code
  // Cnt + Alt + b check implementation
  // Cnt + F5 to Rerun
  // Alt + 9 version control

  //Git
  // Cnt + K git commit

  // Sft + Cnt + A Any Action
  // Sft + Cnt + F12 to full screen or concentrate on my work

  // Sft + Cnt + Alt + S Project structure file
  // Sft + Cnt + Alt + T Refactor
  // Sft + Cnt + E recent location *
  // Alt + F7 Find you usages
  // Cnt + Alt + F Extract fields
  @Test
  void haveFourCorners()
  {
    Shape shape = new Square();
    int checkCorners = shape.checkCorners();
    Assertions.assertEquals(4, checkCorners);
  }

  @Test
  void shouldHaveFourEdges()
  {
    Shape shape = new Square();
    int edges = shape.checkEdges();
    Assertions.assertEquals(4, edges);
  }

}
