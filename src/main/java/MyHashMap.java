import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap extends ConcurrentHashMap
{

  public static void main(String[] args)
  {
    Map map = new MyHashMap();
    map.put(1, 1);
    System.out.println(map);
  }
}


