public class Armstrong
{
  public static void main(String[] args)
  {
    int tempNum = 153, num = 153;
    int sum = 0;
    while (tempNum != 0)
    {
      int reminder = tempNum % 10;
      sum += (Math.pow(reminder, 3));
      tempNum = tempNum / 10;

    }
    if (sum == num)
      System.out.printf("Yes!");
    else
      System.out.printf("No");
  }
}
