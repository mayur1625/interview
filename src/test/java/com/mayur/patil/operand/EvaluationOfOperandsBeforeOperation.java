package com.mayur.patil.operand;

public class EvaluationOfOperandsBeforeOperation
{
  public static void main(String[] args)
  {
    int divisor = 0;
    try
    {
      int i = 1 / (divisor * loseBig());
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }

  static int loseBig() throws Exception
  {
    throw new Exception("Shuffle off to Buffalo!");
  }
  /*
  since no part of the division operation, including signaling of a divide-by-zero exception,
  may appear to occur before the invocation of loseBig completes,
  even though the implementation may be able to detect or
  infer that the division operation would certainly result in a divide-by-zero exception.
   */
}
