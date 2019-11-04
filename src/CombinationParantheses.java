
public class CombinationParantheses {

	public static void main(String[] args) {
		int n = 3;
		char[] str = new char[2 * n];
		printParenthesis(str, 0, n, 0, 0);
	}

	private static void printParenthesis(char[] str, int position, int n, int open, int close) {

		if(close == n) {
			System.out.println(str);			
			return;
		}
		
		if(open>close) {			
			str[position] = ')';
			printParenthesis(str, position+1, n, open, close+1);
		}
		
		if(open<n) {			
			str[position] = '(';
			printParenthesis(str, position+1, n, open+1, close);
		}
		
	}
}
