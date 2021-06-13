package designpatterns.state;

public abstract class UIControl
{
  public void enable()
  {
    System.out.println("Enabled");
  }

  public abstract void draw();
}

class TextBox extends UIControl
{

  @Override public void draw()
  {
    System.out.println("Drawing text box.");
  }
}

class CheckBox extends UIControl
{

  @Override public void draw()
  {
    System.out.println("Drawing check box.");
  }
}
