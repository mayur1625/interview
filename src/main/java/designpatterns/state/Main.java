package designpatterns.state;

public class Main
{
  public static void main(String[] args)
  {
    drawUIControl(new TextBox());
  }

  public static void drawUIControl(UIControl control)
  {
    control.draw();
  }
}
