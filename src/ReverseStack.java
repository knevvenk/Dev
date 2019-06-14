import java.util.Stack;

public class ReverseStack {
	static Stack<Integer> st = new Stack<>();

	public static void main(String[] args) {

		st.push(10);
		st.push(4);
		st.push(8);
		st.push(7);
		st.push(9);

		reverse();
		
		sort();
		
		while (st.size() > 0) {
			System.out.print(st.peek()+", ");
			st.pop();
		}
	}

	private static void reverse() {
		if (st.isEmpty())
			return;

		Integer x = st.peek();
		st.pop();
		reverse();

		insertAtBottom(x);

	}

	private static void insertAtBottom(Integer x) {
		if (st.isEmpty()) {
			st.push(x);
		} else {
			Integer y = st.peek();
			st.pop();
			insertAtBottom(x);
			st.push(y);
		}

	}

	private static void sort() {
		Stack<Integer> tempStack = new Stack<>();
		while (st.size() > 0) {
			Integer x = st.peek();
			st.pop();
			if (tempStack.isEmpty())
				tempStack.push(x);
			else {
				while (x > tempStack.peek()) {
					Integer y = tempStack.peek();
					st.push(y);
					tempStack.pop();
				}
				tempStack.push(x);
			}
		}
		while (tempStack.size() > 0) {
			System.out.print(tempStack.peek()+", ");
			tempStack.pop();
		}
	}
}
