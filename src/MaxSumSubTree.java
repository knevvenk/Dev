
public class MaxSumSubTree {

	
	private static Integer max_val = 0;
	public static int maxPathSum(Node root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null) {
			return root.data;
		}
		
		int leftMax = maxPathSum(root.left);
		int rightMax = maxPathSum(root.right);
		
		if(root.left !=null && root.right !=null) {
			max_val = Math.max(max_val, leftMax+rightMax+root.data);
			return Math.max(leftMax, rightMax)+root.data;
		}
		
		return max_val;
	}
	
	public static void main(String[] args){
        MyTree tree = new MyTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        maxPathSum(tree.root);
       System.out.println(max_val); 
	}
}
