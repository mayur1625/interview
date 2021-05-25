public class TreeTravels
{
  // Root of Binary Tree
  Node root;

  TreeTravels()
  {
    root = null;
  }

  /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
  void printPostorder(Node node)
  {
    if (node == null)
      return;

    // first recur on left subtree
    printPostorder(node.left);

    // then recur on right subtree
    printPostorder(node.right);

    // now deal with the node
    System.out.print(node.key + " ");
  }

  /* Given a binary tree, print its nodes in inorder*/
  void printInorder(Node node)
  {
    if (node == null)
      return;

    /* first recur on left child */
    printInorder(node.left);

    /* then print the data of node */
    System.out.print(node.key + " ");

    /* now recur on right child */
    printInorder(node.right);
  }

  /* Given a binary tree, print its nodes in preorder*/
  void printPreorder(Node node)
  {
    if (node == null)
      return;

    /* first print data of node */
    System.out.print(node.key + " ");

    /* then recur on left sutree */
    printPreorder(node.left);

    /* now recur on right subtree */
    printPreorder(node.right);
  }

  // Wrappers over above recursive functions
  void printPostorder()
  {
    printPostorder(root);
  }

  void printInorder()
  {
    printInorder(root);
  }

  void printPreorder()
  {
    printPreorder(root);
  }

  // Driver method
  public static void main(String[] args)
  {
    TreeTravels tree = new TreeTravels();
    tree.root = new Node(30);
    tree.root.left = new Node(15);
    tree.root.left.left = new Node(7);
    tree.root.left.right = new Node(22);
    tree.root.left.right.left = new Node(17);
    tree.root.left.right.right = new Node(27);

    tree.root.right = new Node(60);
    tree.root.right.left = new Node(45);
    tree.root.right.right = new Node(75);
    
    System.out.println(
        "Preorder traversal of binary tree is ");
    tree.printPreorder();

    System.out.println(
        "\nInorder traversal of binary tree is ");
    tree.printInorder();

    System.out.println(
        "\nPostorder traversal of binary tree is ");
    tree.printPostorder();
  }
}

class Node
{
  int key;
  Node left, right;

  public Node(int item)
  {
    key = item;
    left = right = null;
  }
}
