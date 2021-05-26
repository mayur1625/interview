package thread;

public class Print12
{
  public static void main(String[] args)
  {
    PrintThread p0 = new PrintThread(0);
    PrintThread p1 = new PrintThread(1);
    //PrintThread p2 = new PrintThread(2);

    Thread t0 = new Thread(p0, "0");
    Thread t1 = new Thread(p1, "1");
    //Thread t2 = new Thread(p2, "2");

    t0.start();
    t1.start();
    //t2.start();

  }
}

class PrintThread implements Runnable
{
  static Object lock = new Object();
  static int number = 0;
  int rem;

  public PrintThread(int rem)
  {
    this.rem = rem;
  }

  @Override public void run()
  {

    while (number < 10)
    {
      synchronized (lock)
      {
        //while ((number % 3) != rem)
        while ((number & 1) == rem)
        {
          try
          {
            lock.wait();
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }
        }
        //System.out.println(Thread.currentThread().getName() + " " + number);
        System.out.print(Thread.currentThread().getName() + " ");
        number++;
        lock.notifyAll();
      }
    }
  }
}
