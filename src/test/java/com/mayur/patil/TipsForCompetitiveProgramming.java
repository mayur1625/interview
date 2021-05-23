package com.mayur.patil;

public class TipsForCompetitiveProgramming
{
  public static void main(String[] args)
  {
    /*Check odd even*/
    int odd = 8;
    System.out.println((odd & 1) == 0 ? "EVEN" : "ODD");
    /*Multiply or divide by2 */
    System.out.println(7<<1);
    System.out.println(7>>1);
    /*Swap Numbers*/
    //https://www.geeksforgeeks.org/swap-two-numbers-without-using-temporary-variable/
    int x = 5;
    int y = 10;
    swapAddition(x,x);
    System.out.println(x + " : " + x);
    x = x * y;
    y = x / y;
    x = x / y;
    System.out.println(x + " : " + y);
    // bitwise XOR operator
    // Code to swap 'x' (1010) and 'y' (0101)
    x = x ^ y; // x now becomes 15 (1111)
    y = x ^ y; // y becomes 10 (1010)
    x = x ^ y; // x becomes 5 (0101)
    System.out.println(x + " : " + y);
    //Problems with the above methods
    //1) The multiplication and division based approach doesn’t work if one of the numbers is 0 as the product becomes 0 irrespective of the other number.
    //2) Both Arithmetic solutions may cause an arithmetic overflow. If x and y are too large, addition and multiplication may go out of integer range.
    //3) When we use pointers to variable and make a function swap, all the above methods fail when both pointers point to the same variable. Let’s take a look at what will happen in this case if both are pointing to the same variable.
  }
  public static void swapAddition (int x , int y){
    x = x + y;
    y = x - y;
    x = x - y;
  }
}
