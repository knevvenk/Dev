
public class RedBlackTree {
	RBNode root = null;
	private void insert(int i) {
		if(root == null) {
			root = RBNode.createRootNode(i);
			return;
		}
		RBNode parent = null;
		RBNode temp = root;
		while(temp != null) {
			parent = temp;
			if(temp.data>i) {
				temp = temp.left;
			}
			else if(temp.data<i) {
				temp = temp.right;
			}
		}
		
		RBNode childNode = RBNode.createChildNode(i);
//		if(parent == null)
		if(parent.data>i)
			parent.left = childNode;
		if(parent.data<i)
			parent.right = childNode;
		
		childNode.parent = parent;
		
		//Check the rotations and colors of the node and fix them.
		fixRBTree(childNode);
		
	}

	private void fixRBTree(RBNode childNode) {
		//Continue the loop only if parent color is RED, if the parent color is BLACK then no need to modify the tree.
		while(childNode.parent.color == "RED") {
			RBNode parent = childNode.parent;
			RBNode uncle = null;
			
			//Fetch the parent sibling
			if(parent.data<parent.parent.data) {
				uncle = parent.parent.right;
			}
			else
				uncle = parent.parent.left;
			
			//If uncle is RED then change both parent and uncle into black color.
			if(uncle != null && uncle.color =="RED") {
				childNode.parent.color = "BLACK";
				uncle.color = "BLACK";
				parent.parent.color = "RED";
			}
			//If uncle is in BLACK now the game starts..
			else {
				//If the childNode is right side to its parent node and parent node is left to grand parent node then rotate to the left
				//after left rotation we change the colors of parent and grandparent and rotate to the right
				if(childNode.isRight() && childNode.parent.isLeft()) {
					rotateLeft(childNode.parent);
					childNode = childNode.left;
				}
				//If the childNode is left to its parent node and parent node is right to the grand parent node then rotate to the right.
				//After left rotation we change the colors of parent and grandparent and rotate to the left.
				else if(childNode.isLeft() && childNode.parent.isRight()) {
					rotateRight(childNode.parent);
					childNode = childNode.right;
				}
				
				childNode.parent.color= "BLACK";
				childNode.parent.parent.color= "RED";
				
				if(childNode.isLeft())
					rotateRight(childNode.parent.parent);
				if(childNode.isRight())
					rotateLeft(childNode.parent.parent);
				
			}
		}
		root.color= "BLACK";
		
	}

	private void rotateRight(RBNode parent) {
		RBNode grandParent = parent.parent;
		RBNode child = parent.left;
		
		parent.left = child.right;
		if(child.right != null) {
			child.right.parent = parent;
		}
		
		child.parent = grandParent;
		//The below code is set the root node after the grandparent rotation
		if(grandParent == null)
			root = child;
		else if(grandParent.right == parent)
			grandParent.right = child;
		else
			grandParent.left = child;
		
		child.right = parent;
		parent.parent = child;
	}

	private void rotateLeft(RBNode parent) {
		RBNode grandParent = parent.parent;
		RBNode child = parent.right;
		
		parent.right = child.left;
		if(child.left != null) {
			child.left.parent = parent;
		}
		
		child.parent = grandParent;
		//The below code is set the root node after the grandparent rotation
		if(grandParent == null)
			root = child;
		else if(grandParent.left == parent)			
			grandParent.left = child;
		else
			grandParent.right = child;
		
		child.left = parent;
		parent.parent = child;
	}

	public static void main(String[] args) {
		RedBlackTree rbTree = new RedBlackTree();
		
		int[] ar = new int[]{10,5,12,6};
		for (int i : ar) {
			rbTree.insert(i);
		}
	}
}


class RBNode{
	int data;
	RBNode left;
	RBNode right;
	RBNode parent;
	String color;
	
	RBNode(int data, RBNode left, RBNode right, RBNode parent, String color){
		this.data= data;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.color = color;
	}
	
	RBNode(){
		
	}
	public static RBNode createRootNode(int data) {
		RBNode rootNode = new RBNode();
		rootNode.data = data;
		rootNode.parent = null;
		rootNode.left = null;
		rootNode.right = null;
		rootNode.color = "BLACK";
		
		return rootNode;
	}
	
	public static RBNode createChildNode(int data) {
		RBNode childNode = new RBNode();
		childNode.data = data;
		childNode.parent = null;
		childNode.left = null;
		childNode.right = null;
		childNode.color = "RED";
		
		return childNode;
	}
	
	public boolean isRight() {
		RBNode parent = this.parent;
		if(this.data>parent.data)
			return true;
		else
			return false;
	}
	
	public boolean isLeft() {
		RBNode parent = this.parent;
		if(this.data<parent.data)
			return true;
		else
			return false;
	}
}