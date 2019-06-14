
/**
 * Find the max BST from given binary tree
 * @author banve02
 *
 */
public class MaxBSTInBinaryTree {

	public static NodeDetails largestBSTSize(Node root) {
		if(root == null)
			return new NodeDetails();
		
		NodeDetails leftNode = largestBSTSize(root.left);
		NodeDetails rightNode = largestBSTSize(root.right);
		
		NodeDetails node = new NodeDetails();
		
		if(leftNode.maxVal < root.data && rightNode.minVal > root.data) {
			node.isBST = true;
			node.maxVal = root.right != null ? rightNode.maxVal : root.data;
			node.minVal = root.left != null ? leftNode.minVal : root.data;
			node.size = leftNode.size+rightNode.size+1;
		}
		else {
			node.isBST = false;
			node.size = Math.max(leftNode.size, rightNode.size);
//			node.maxVal =0;
//			node.minVal = 0;
		}
		System.out.println(root.data+" -- "+node.isBST+" -- "+node.size+" -- "+node.minVal+" -- "+node.maxVal);
		return node;
	}
	
	
	public static void main(String[] args) {
		 MyTree tree = new MyTree();
	        tree.root = new Node(20);
	        tree.root.left = new Node(25);
	        tree.root.right = new Node(40);
	        tree.root.left.left = new Node(18);
	        tree.root.left.right = new Node(26);
	        tree.root.right.left = new Node(30);
	        tree.root.right.right = new Node(50);
	        tree.root.right.left.left = new Node(20);
	        tree.root.right.right.left = new Node(45);
	        tree.root.right.right.right = new Node(60);
	        
	        System.out.println(largestBSTSize(tree.root).size);
	}
}

class NodeDetails{
	int size =0;
	boolean isBST = false;
	int minVal = Integer.MAX_VALUE;
	int maxVal = Integer.MIN_VALUE;
}