package com.mayur.patil;

public class ReverseLL
{
  public static void main(String[] args)
  {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    Node head = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    print(head);

    head = reverse(head);
    Node end = reverseRec(head);
    end.next = null;
    print(hhead);
  }

  static Node hhead = null;
//4, 3, 2, 1
  public static Node reverseRec(Node node)
  {
    if (node.next == null)
      return (hhead = node);
    return (reverseRec(node.next).next = node);

  }

  public static Node reverse(Node node)
  {

    Node prev = null;
    Node curr = node;
    Node next = null;
    while (curr != null)
    {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    print(prev);
    return prev;
  }

  public static void print(Node node)
  {
    while (node != null)
    {
      System.out.print(node.val + ", ");
      node = node.next;
    }
  }

  static class Node
  {
    public Node(int val)
    {
      this.val = val;
    }

    int val;
    Node next;
  }
}
