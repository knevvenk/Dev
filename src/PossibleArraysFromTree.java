import java.util.ArrayList;
import java.util.LinkedList;

public class PossibleArraysFromTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(7);
		
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(14);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		root.right.right.left = new TreeNode(13);
		root.right.right.right = new TreeNode(15);
		
		allSequences(root);
	}

	private static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if(node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		for(LinkedList<Integer> left: leftSeq) {
			for(LinkedList<Integer> right: rightSeq) {
//				System.out.println(left);
//				System.out.println(right);
				System.out.println(prefix);
			}
		}
		return result;
		
	}
}

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}