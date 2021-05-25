package bst;

public class BstAddNode
{

  // BST node
  static class Node
  {
    int key;
    Node left, right;

    public Node(int key)
    {
      this.key = key;
    }
  }

  static Node insert(Node root, Node newNode)
  {

    // Pointer to start traversing from root and
    // traverses downward path to search
    // where the new node to be inserted
    Node x = root;

    // Pointer y maintains the trailing
    // pointer of x
    Node y = null;

    while (x != null)
    {
      y = x;
      if (newNode.key < x.key)
        x = x.left;
      else
        x = x.right;
    }

    if (newNode.key < y.key)
      y.left = newNode;
    else
      y.right = newNode;

    return y;
  }

  static void Inorder(Node root)
  {
    if (root == null)
      return;
    else
    {
      Inorder(root.left);
      System.out.print(root.key + " ");
      Inorder(root.right);
    }
  }

  // Driver code
  public static void main(String args[])
  {
    /* Let us create following BST
            50
          /   \
        30      70
        / \   / \
       20 40 60 80 */

    Node root = new Node(50);

    insert(root, new Node(30));
    insert(root, new Node(20));
    insert(root, new Node(40));
    insert(root, new Node(70));
    insert(root, new Node(60));
    insert(root, new Node(80));

    Inorder(root);
  }
}
