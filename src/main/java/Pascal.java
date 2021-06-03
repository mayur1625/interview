import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal
{
  public static void main(String[] args)
  {
    List<List<Integer>> list = generate(5);

    list.forEach(f -> {
      f.stream().forEach(e -> System.out.print(e + " "));
      System.out.println();
    });
    System.out.println();
  }

  public static List<List<Integer>> generate(int numRows)
  {
    List<List<Integer>> triangle = new ArrayList<>();
    if (numRows == 0)
      return triangle;

    List<Integer> row = new ArrayList<>(Arrays.asList(1));
    triangle.add(row);

    for (int i = 1; i < numRows; i++)
    {
      List<Integer> prev = triangle.get(i - 1);
      List<Integer> curr = new ArrayList<>();
      curr.add(1);

      for (int j = 1; j < i; j++)
      {
        curr.add(prev.get(j - 1) + prev.get(j));
      }
      curr.add(1);
      triangle.add(curr);
    }

    return triangle;
  }
}
