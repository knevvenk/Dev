import java.util.Stack;

/**
 * Created by bandi on 1/9/2016.
 */

class Node{
    int data;
    Node left,right;
    Node(int item){
        data = item;
        left = null;
        right = null;
    }
}
public class MyTree {
    Node root;

    int height(){
        return height(root);
    }

     int height(Node node){
        if(node == null)
            return 0;
        return (1+Math.max(height(node.left),(height(node.right))));
    }

    void inorder(){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(node != null){
            stack.push(node);
            node = node.left;
        }

        while(stack.size()>0){

            node = stack.pop();
            System.out.println(node.data+"  ");
            if(node.right != null) {
                node = node.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    void preOrder(){
        Node node = root;
        Stack<Node> stack = new Stack<>();
//        System.out.print(node.data+ " , ");
        while(node != null){
            System.out.print(node.data+" , ");
            stack.push(node);
            node = node.left;
        }

        while(stack.size()>0){
            node = stack.pop();
            if(node.right != null){
                node = node.right;
                System.out.print(node.data+" , ");
                while(node != null){
                    stack.push(node);
                    node = node.left;

                }
            }
        }
    }

    void postOrder(){
        Node node = root;
        Stack<Node> stack = new Stack<>();
        while(node != null){
            if(node.right != null) {
                stack.push(node.right);
                stack.push(node);
            }
            else
                stack.push(node);
            node = node.left;
        }

        while(stack.size() > 0){
            node = stack.pop();
            Node top = node;
            if(node.right != null){
                node = node.right;
                if(top == node)
                    stack.push(top);
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
//            System.out.print(node.data);
        }
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

//        System.out.println(tree.height());

        tree.inorder();
        System.out.println("\n");
        tree.preOrder();
        System.out.println("\n");
        tree.postOrder();
        System.out.println("\n-----------------");
        System.out.println(tree.maxHeight(tree.root));
    }

	private int maxHeight(Node node) {
		if(node == null)
			return 0;
		
		int h = Math.max(maxHeight(node.left), maxHeight(node.right))+1;
		return h;
	}
}
