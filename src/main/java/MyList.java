import com.sun.javaws.exceptions.ErrorCodeResponseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList
{
  public static void main(String[] args)
  {
    List<Boolean> list = new ArrayList<>();
    list.add(true);
    list.add(Boolean.parseBoolean("faLSe"));
    list.add(Boolean.TRUE);

    System.out.println(list.size());
    System.out.println(list.get(1) instanceof Boolean);

    String str = "strawberries";

    System.out.println(str.substring(2, 5));

    String nifty = "nifty";

    System.out.println(nifty.charAt(3));

    String hello = "Hello world!";
    String msg = hello.substring(6, 12);// + hello.substring(12, 6);
    System.out.println(msg);
    //pass by value
    //pass by referance

//    StringBuilder sb = new StringBuilder("hello");
//    sb.deleteCharAt(0).insert(0,"H")." World!";
//    System.out.println(sb);
    String[] arr = new String[] {"A", "B", "C"};
    List<String> list1 = Arrays.asList(args);
    List<String> list2 = new ArrayList<>(Arrays.asList(args));
    List<String> list3 = new ArrayList<>(Arrays.asList(new String[] {"A", new String("B"), "C"}));

    System.out.println("=>" + list1.equals(list2));
    System.out.println("=>" + list2.equals(list3));
//    try{
//      System.out.println("OK");
//    } catch (Exception e){
//
//    }catch (ArithmeticException ae){
//
//    }
    try
    {
      System.out.println("A");
      bad();
      System.out.println("B");
    }
    catch (Error e)
    {
      System.out.println("C");
    }
    finally
    {
      System.out.println("D");
    }

  }

  public static void bad()
  {
    throw new Error();
  }

}
//  interface I
//  {
//    String msg = "OK";
//
//    static void print()
//    {
//      System.out.println(msg);
//    }
//
//  }
