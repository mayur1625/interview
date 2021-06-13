package designpatterns.factory;

public class Test
{
  public static void main(String[] args)
  {
    System.out.println(Factory.getFactory(new M()));
  }
}

interface I
{
  int getI();
}

class A implements I
{

  @Override public int getI()
  {
    return 10;
  }
}

class B implements I
{

  @Override public int getI()
  {
    return 20;
  }
}

interface K {
  I getK();
}

class M implements K{

  @Override public I getK()
  {
    return new A();
  }
}

class N implements K{

  @Override public I getK()
  {
    return new A();
  }
}

class Factory
{
  public static int getFactory(K ab)
  {
    return ab.getK().getI();
  }
}
