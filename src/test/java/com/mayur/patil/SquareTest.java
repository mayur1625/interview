package com.mayur.patil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
  // Cnt + Alt + M Extract method
  // Cnt + Alt + P Extract parameter
  // Cnt + F6 to re arrange the parameter
  // Cnt + Alt + N Opposite of extract method, Inline method
  // Cnt + Sht + Alt + P Functional parameter
  @Test
  void haveFourCorners()
  {
//    Shape shape = new Square();
//    int checkCorners = shape.checkCorners();
//    Assertions.assertEquals(4, checkCorners);

    String s = "Hello India 122";
    String s1 = "Make it as 123 false ";
    String s2 = "Try to 184 find for Me ";
//    for (int i = 0; i < s.length(); i++)
//    {
//      System.out.print(s.charAt(i));
//    }
    System.out.println( Pattern.matches(".*?\\b(122|184)\\b.*?", s2));
  }


  





  @Test
  void shouldHaveFourEdges()
  {
    Shape shape = new Square();
    assertion(shape::checkEdges);
  }

  private void assertion(IntSupplier intSupplier)
  {
    Assertions.assertEquals(4, intSupplier.getAsInt());
  }

}
