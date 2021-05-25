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

  static Node insert(Node root, int key)
  {
    Node newNode = new Node(key);
    if (root == null)
      return newNode;
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
      if (key < x.key)
        x = x.left;
      else
        x = x.right;
    }

    if (key < y.key)
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

    Node root = insert(null, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);

    Inorder(root);
  }
}
