package roman;

public class RomanNumbers
{
  public static void main(String[] args)
  {
    //System.out.println(calculateRoman(510));
    String str = "";
    int number = 2513;
    while (number != 0)
    {
      String pair[] = getAverage(number).split(", ");
      str += pair[0];
      number -= Integer.parseInt(pair[1]);
      System.out.println("=>" + str + "," + number);
    }

  }

  public static String getAverage(int i)
  {
    if (i >= 1000)
      return "M, 1000";
    else if (i >= 900)
      return "CM, 900";
    else if (i >= 500)
      return "D, 500";
    else if (i >= 400)
      return "CD, 400";
    else if (i >= 100)
      return "C, 100";
    else if (i >= 90)
      return "XC, 90";
    else if (i >= 50)
      return "L, 50";
    else if (i >= 40)
      return "XL, 40";
    else if (i >= 10)
      return "X, 10";
    else if (i >= 9)
      return "IX, 9";
    else if (i >= 5)
      return "V, 5";
    else if (i >= 4)
      return "IV, 4";
    else if (i >= 1)
      return "I, 1";
    return null;
  }
}
