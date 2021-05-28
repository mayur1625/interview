package enumtest;

public class MyEnum
{
  public static void main(String[] args)
  {
    for (LEVEL l : LEVEL.values())
    {
      System.out.println(l.ordinal());
      System.out.println(l.findEnum("LOW"));
    }
  }

  enum LEVEL
  {

    LOW(1), MEDIUM(5), HIGH(10);
    int i;

    private LEVEL(int val)
    {
      System.out.println("val: " + val);
      i = val;
    }

    public LEVEL findEnum(String str){
      return LEVEL.valueOf(str);
    }
  }
}
