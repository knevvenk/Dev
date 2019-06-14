import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderBinaryTree {

	public static ArrayList<ArrayList<Integer>> printVerticalOrder(Node A){
		if (A == null)
			return null;

		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		int distance = 0;
		getVerticalOrderNodes(A, distance, map);
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();

		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			output.add(entry.getValue());
		}
		return output;
	}

	private static void getVerticalOrderNodes(Node root, int distance, TreeMap<Integer, ArrayList<Integer>> map) {
		if (root == null)
			return;

		ArrayList<Integer> nodes = map.get(distance);
		if (nodes == null) {
			nodes = new ArrayList<>();
			nodes.add(root.data);
		} else {
			nodes.add(root.data);
		}

		map.put(distance, nodes);
		getVerticalOrderNodes(root.left, distance - 1, map);
		getVerticalOrderNodes(root.right, distance + 1, map);
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

		System.out.println(printVerticalOrder(tree.root));
	}
}
