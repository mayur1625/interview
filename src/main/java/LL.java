public class LL
{
  public static void main(String[] args)
  {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    System.out.print(reverse(n1).value);
    Node curr = n1;
    Node next, prev = null;
    while (curr != null)
    {
      next = curr.next;//2,3
      curr.next = prev;//null,1
      prev = curr;//1,2
      curr = next;//2,3
    }
    while (prev != null)
    {
      System.out.println(prev.value + ",");
      prev = prev.next;
    }

  }

  static Node head = null;

  public static Node reverse(Node n)
  {
    // 1, 2, 3, 4
    if (n.next == null)
    {
      head = n;
      return n;
    }
    reverse(n.next);
    return n;
  }

  // 1 -> 2 -> 3 -> 4 -> 5 -> null
  // 1 <- 2
  static class Node
  {
    Node next;
    int value;

    public Node(int value)
    {
      this.value = value;
    }
  }

}


