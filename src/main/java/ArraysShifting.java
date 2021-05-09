public class ArraysShifting
{
  public static void main(String[] args)
  {
    int[] arr = {4, 2, 6, 8, 0, 1, 2, 7};
    boolean check = false;
    for (int i = 3; i < arr.length; i++)
    {
      System.out.print(arr[i] + ", ");
      if (i + 1 == arr.length)
      {
        i = -1;
        check = true;
      }
      if (check && i == 2)
      {
        break;
      }
    }
  }

}
