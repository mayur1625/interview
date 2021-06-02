package bst;

public class BSTHeight
{
  public static void main(String[] args)
  {
    Tree root = getBinaryTree();

    System.out.println(getHeight(root));

    //inorder(root);
  }

  public static void inorder(Tree node)
  {
    if (node == null)
    {
      return;
    }
    inorder(node.l);
    System.out.print(node.val + ", ");
    inorder(node.r);
  }

  public static int getHeight(Tree node)
  {
    if (node == null)
    {
      return 0;
    }
    //System.out.println("Left: " + (node.l == null ? null : node.l.val) + ", Right: " + (node.r == null ? null : node.r.val));
    int l = getHeight(node.l);//3
    int r = getHeight(node.r);//6
    //System.out.println("l: " + l + ", r: " + r);
    return l > r ? l + 1 : r + 1;
  }

  public static Tree getBinaryTree()
  {
    Tree root = new Tree(5);
    root.l = new Tree(3);
    root.l.l = new Tree(1);
    root.l.r = new Tree(4);
    root.r = new Tree(6);
    root.r.r = new Tree(7);
    root.r.r.r = new Tree(8);
    root.r.r.r.r = new Tree(9);
    return root;
  }
}

class Tree
{
  int val;

  Tree(int node)
  {
    val = node;
  }

  Tree l, r;
}
