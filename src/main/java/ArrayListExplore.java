import java.util.stream.IntStream;

public class ArrayListExplore
{
  public static void main(String[] args)
  {
    int arr[][] = {
        {1, 0, 0, 1, 0, 0, 0},
        {1, 1, 1, 1, 0, 0, 1},
        {0, 0, 0, 1, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 1}
    };
    System.out.println(numberOfIceland(arr));
    int[] array = {3, 1, 2, 4, 6, 8, 5};
    IntStream.range(0, array.length).forEach(i -> System.out.print("=>" + array[i]));


  }

  public static int numberOfIceland(int arr[][])
  {
    int count = 0;
    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < arr[i].length; j++)
      {
        if (arr[i][j] == 1)
        {
          count++;
          check(arr, i, j);
        }
      }
    }
    return count;
  }

  public static void check(int arr[][], int i, int j)
  {
    if (i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0)
      return;
    arr[i][j] = 0;
    check(arr, i + 1, j);
    check(arr, i - 1, j);
    check(arr, i, j + 1);
    check(arr, i, j - 1);
  }
}
