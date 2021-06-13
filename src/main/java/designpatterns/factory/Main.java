package designpatterns.factory;

public class Main
{
  public static void main(String[] args)
  {
    PlanFactory factory = new PlanFactory();

    Membership membership = factory.getMembership("gold");
    membership.getRate();
    membership.calculateMembership(1);

  }
}

abstract class Membership
{
  protected int rate;

  public abstract void getRate();

  public void calculateMembership(int units)
  {
    System.out.println(rate * units);
  }
}

class PlanFactory
{
  public Membership getMembership(String type)
  {
    if (type == null)
      return null;
    if (type.equals("gold"))
      return new Gold();
    if (type.equals("platinum"))
      return new Platinum();
    if (type.equals("silver"))
      return new Silver();
    return null;
  }
}

class Platinum extends Membership
{
  @Override public void getRate()
  {
    rate = 150;
  }
}

class Gold extends Membership
{
  @Override public void getRate()
  {
    rate = 100;
  }
}

class Silver extends Membership
{
  @Override public void getRate()
  {
    rate = 50;
  }
}
