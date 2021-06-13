package designpatterns.abstactfactory;

public class Main
{
  public static void main(String[] args)
  {
    testAbstractFactory();
  }

  private static void testAbstractFactory()
  {
    Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB"));
    Computer sv = ComputerFactory.getComputer(new ServerFactory("16 GB"));
    System.out.println("AbstractFactory PC Config::" + pc);
    System.out.println("AbstractFactory Server Config::" + sv);
  }
}

abstract class Computer
{
  public abstract String getRAM();

  @Override
  public String toString()
  {
    return "RAM= " + this.getRAM();
  }
}

class PC extends Computer
{
  private String ram;

  public PC(String ram)
  {
    this.ram = ram;
  }

  @Override
  public String getRAM()
  {
    return this.ram;
  }
}

class Server extends Computer
{
  private String ram;

  public Server(String ram)
  {
    this.ram = ram;
  }

  @Override
  public String getRAM()
  {
    return this.ram;
  }
}

interface ComputerAbstractFactory
{
  Computer createComputer();
}

class PCFactory implements ComputerAbstractFactory
{
  private String ram;

  public PCFactory(String ram)
  {
    this.ram = ram;
  }

  @Override
  public Computer createComputer()
  {
    return new PC(ram);
  }
}

class ServerFactory implements ComputerAbstractFactory
{
  private String ram;

  public ServerFactory(String ram)
  {
    this.ram = ram;
  }

  @Override
  public Computer createComputer()
  {
    return new Server(ram);
  }
}

class ComputerFactory
{
  public static Computer getComputer(ComputerAbstractFactory factory)
  {
    return factory.createComputer();
  }
}
