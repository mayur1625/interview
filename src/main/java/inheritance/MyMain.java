package inheritance;

public class MyMain
{
  public static void main(String[] args)
  {
    Shape shape = new Squre();

    shape.draw();
  }
}

interface Shape
{
  void draw();
}

class Rectangle implements Shape
{

  @Override public void draw()
  {
    System.out.println("Shape my rectangle");
  }
}

class Squre extends Rectangle
{
  @Override public void draw()
  {
    System.out.println("Shape my squre");
  }
}

