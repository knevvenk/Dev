package cci;

/**
 * Minimal BST Tree 4.2 given increasing sorted and create the minimum height
 * BST tree
 *
 */
public class MinimalBST {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		Node node = minimalBSTTree(a, 0, a.length - 1);
		System.out.println("");
	}

	private static Node minimalBSTTree(int[] a, int start, int end) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(a[mid]);
		node.left = minimalBSTTree(a, start, mid-1);
		node.right = minimalBSTTree(a, mid+1, end);
		return node;
	}
	
	static class Node{
	    int data;
	    Node left,right;
	    Node(int item){
	        data = item;
	        left = null;
	        right = null;
	    }
	}
	
}
