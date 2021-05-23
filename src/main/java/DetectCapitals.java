public class DetectCapitals
{
  public static void main(String[] args)
  {
    for (char ch : "asasFsd".toCharArray())
      if (ch > 64 && ch < 91)
        System.out.println(ch);
  }

}
