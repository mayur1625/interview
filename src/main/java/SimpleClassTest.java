public class SimpleClassTest
{
  public static void main(String[] args)
  {
    new SimpleClassTest();
    new SimpleClassTest();
    Shape shape = new Circle();
  }

  {
    System.out.println("\tInit block.");
  }

  static
  {
    System.out.println("Static block.");
  }

  public SimpleClassTest()
  {
    System.out.println("\t\tConstructor class:name:" + SimpleClassTest.class.getSimpleName());
  }
}

interface Shape
{
  void draw();
}

class Circle implements Shape
{

  @Override public void draw()
  {
    System.out.print("draw");
  }
}
