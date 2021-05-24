public class HelloWorld
{
  public static void main(String args[]) {
    System.loadLibrary("ctest");
    HelloWorld helloWorld = new HelloWorld();
    helloWorld.helloFromC();
  }
  native void helloFromC();
}
