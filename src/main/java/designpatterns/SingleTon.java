package designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTon
{
  public static void main(String[] args)
  {
//    GetData g1 = GetData.getInstance();
//    GetData g2 = GetData.getInstance();
//
//    System.out.printf("g1: %d\n", g1.hashCode());
//    System.out.printf("g2: %d\n", g2.hashCode());

    ExecutorService service = Executors.newFixedThreadPool(2);
    service.submit(new SingleTon()::getDataInstance);
    service.submit(new SingleTon()::getDataInstance);
    service.submit(new SingleTon()::getDataInstance);
    service.shutdown();
  }

  public void getDataInstance()
  {
    GetData g1 = GetData.getInstance();
    System.out.printf("g1: %d\n", g1.hashCode());
  }

}

class GetData
{
  private static GetData data = null;

  private GetData()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.print("Thread wake up... ");
  }

  public static GetData getInstance()
  {
    if (data == null)
    {
      synchronized (GetData.class)
      {
        if (data == null)
        {
          data = new GetData();
        }
      }
    }
    return data;
  }
}
