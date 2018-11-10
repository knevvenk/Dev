import java.util.Stack;

/**
 * Created by bandi on 2/6/2016.
 */

class BinaryTree
{
    // Root of Binary Tree
    Node root;
    Stack<Node> stack;
    
    BinaryTree()
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
        System.out.print(node.data + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.data + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }
    
    void printOuterNodes(Node node){
    	if(node == null)
    		return;
    	
    	if(node.left == null && node.right == null){
    		System.out.print(node.data+" ");
    	}
    	printOuterNodes(node.left);
    	printOuterNodes(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }
    
    int find(Node node, Node target, int k) {
   	
    	if(node == null)
    		return -1;
    	if(node.data == target.data) {    		
    		printKdistNodes(node, k);
    		return 0;
    	}    	    	
    	int left = find(node.left, target, k);
    	
    	if(left != -1) {
    		System.out.println("Left -- "+left);
//    		if(left+1 ==k) {
//    			System.out.println(node.data);
//    			System.out.println();
//    		}
//    		else
    			printKdistNodes(node.right, k-left-2);
    		return 1+left;
    	}
    	int right = find(node.right, target, k);
    	
    	if(right !=-1) {
    		System.out.println("Right -- "+right);
//    		if(right+1 == k) {
//    			System.out.println(node.data);
//    			System.out.println();
//    		}
//    		else
    			printKdistNodes(node.left, k-right-2);
    		return 1+right;
    	}
    	return -1;
    }
    
    private void printKdistNodes(Node node, int k) {
		if(node == null || k<0)
			return;
		if(k == 0) {
			System.out.println(node.data);
			return;
		}
		
		printKdistNodes(node.left, k-1);
		printKdistNodes(node.right, k-1);
	}

	// Driver method
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        
        System.out.println("\nPrint outer Nodes");
        tree.printOuterNodes(tree.root);
        
        Node target = tree.root.right.left;
        System.out.println("");
        System.out.println("Print 2 distance nodes from node 4");
        tree.find(tree.root, target, 4);
    }
}