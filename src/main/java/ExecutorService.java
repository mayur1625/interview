import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorService
{
  public static void main(String[] args)
  {
    MyExecutorService service = MyExecutors.myNewFixedThreadPool(3);
    for (int i = 0; i < 20; i++)
    {
      service.submit(new MyTask());
    }

    service.shutdown();
  }
}

interface MyExecutorService
{
  void submit(Runnable r);

  void shutdown();
}

class MyThreadPool implements MyExecutorService
{
  static int capacity;
  static int currentCapacity;
  static LinkedBlockingQueue<Runnable> linkedBlockingQueue;
  Execution e;

  public MyThreadPool(int capacity)
  {
    this.capacity = capacity;
    currentCapacity = 0;
    linkedBlockingQueue = new LinkedBlockingQueue<>();
    e = new Execution();
  }

  @Override
  public void submit(Runnable r)
  {
    linkedBlockingQueue.add(r);
    e.executeMyMethod();
  }

  @Override
  public void shutdown()
  {
    Execution.running = false;
  }
}

class Execution implements Runnable
{
  static boolean running = true;

  void executeMyMethod()
  {
    if (MyThreadPool.currentCapacity < MyThreadPool.capacity)
    {
      MyThreadPool.currentCapacity++;
      Thread t = new Thread(new Execution());
      t.start();
    }
  }

  @Override
  public void run()
  {
    while (running && !MyThreadPool.linkedBlockingQueue.isEmpty())
    {
      if (MyThreadPool.linkedBlockingQueue.size() != 0)
      {
        MyThreadPool.linkedBlockingQueue.poll().run();
      }
    }
  }

}

class MyExecutors
{
  static MyExecutorService myNewFixedThreadPool(int capacity)
  {
    return new MyThreadPool(capacity);
  }
}

class MyTask implements Runnable
{
  @Override
  public void run()
  {
    try
    {
      Thread.sleep(500);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println("hii" + Thread.currentThread().getName());
  }
}
