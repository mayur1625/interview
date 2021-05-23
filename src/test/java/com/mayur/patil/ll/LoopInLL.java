package com.mayur.patil.ll;

public class LoopInLL
{
  public static void main(String[] args)
  {
    LList head = new LList(4);
    head.next = new LList(5);
    head.next.next = new LList(7);
    head.next.next.next = new LList(6);
    head.next.next.next.next = new LList(3);
    head.next.next.next.next.next = new LList(2);
    head.next.next.next.next.next.next = new LList(9);
    head.next.next.next.next.next.next = head.next.next.next;

    System.out.println("Loop detected: " + detectLoop(head));
    print(head);
  }

  public static void removeLoop(LList loop, LList head)
  {
    LList ptr1 = head, ptr2 = null;
    while (true)
    {
      ptr2 = loop;
      while (ptr2.next != loop && ptr2.next != ptr1)
        ptr2 = ptr2.next;
      if (ptr2.next != ptr1)
        break;
      ptr1 = ptr1.next;

    }
    ptr2.next = null;
  }

  public static boolean detectLoop(LList head)
  {
    LList slow = head, fast = head;
    while (slow != null && fast != null && fast.next != null)
    {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
      {
        removeLoop(slow, head);
        return true;
      }
    }
    return false;
  }

  public static void print(LList head)
  {
    while (head != null)
    {
      System.out.print(head.val + ", ");
      head = head.next;
    }
  }
}

class LList
{
  int val;

  public LList(int val)
  {
    this.val = val;
  }

  LList next;
}
