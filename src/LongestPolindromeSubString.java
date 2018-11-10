
public class LongestPolindromeSubString {
	public static void main(String[] args) {
		String s = "geeksskeea";
		 System.out.println(longestPoliSubStr(s));
	}

	private static String longestPoliSubStr(String A) {
		int max_length = 1, start_index = 0;
		int n = A.length();
		boolean[][] p = new boolean[n][n];

		// Checking the Palindrome for single char and it is always true;
		for (int i = 0; i < n; i++)
			p[i][i] = true;

		System.out.println("Checking the Palindrome  on single character");
		printMatrix(p);
		System.out.println("=================================");

		// Checking the Palindrome on two characters, if two consecutive chars matches
		// then mark it true
		for (int i = 0; i < n - 1; i++) {
			if (A.charAt(i) == A.charAt(i + 1)) {
				p[i][i + 1] = true;
				start_index = i;
				max_length = 2;
			}
		}

		System.out.println("Checking the Polindrome on two character");
		printMatrix(p);
		System.out.println("=================================");

		// Start the string with 3rd charcter length and check consecutive 3 chars is
		// polindrome or not
		// and continue till string length
		for (int curr_length = 3; curr_length <= n; curr_length++) {
			for (int i = 0; i < n - curr_length + 1; i++) {
				int j = i + (curr_length - 1);

				// Example 1: //let say curr_lenth is 3 which means compare 0th char and 2nd
				// char
				// if they are equal check the p[1][1] is true or not, if this also true then 3
				// length char is polindrome

				// Example 2: //let say curr_lenth is 3 and i is 3 which means compare 4th char
				// and 5nd char ('d' and 'd')
				// if they are equal check the p[5][5] is true or not, if this also true then 3
				// length char is polindrome
				// then mark p[3][5] to true

				// Example 3: // let say curr_length is 5 which means compare 0th char and 4th
				// char ('a' and 'a' in the given string)
				// then check p[1][3] which means ('bcd') is palindrome or not

				// Example 4: // let say curr_length is 5 and i is 2 which means compare 2nd and
				// 6th char('c' and 'c')
				// then check p[3][5] which is ('dad') is palindrome or not -- CHECK Example 2
				// above it marked to true;
				// then mark p[2][6] to true;

				if (A.charAt(i) == A.charAt(j) && p[i + 1][j - 1]) {
					p[i][j] = true;
					if (curr_length > max_length) {
						max_length = curr_length;
						start_index = i;
					}
				}
			}
		}
		System.out.println("Final matrix is");
		printMatrix(p);
		System.out.println("=================================");
		return A.substring(start_index, start_index+max_length);
	}

	private static void printMatrix(boolean[][] p) {
		for (int i = 0; i < p[0].length; i++) {
			for (int j = 0; j < p[0].length; j++) {
				if (p[i][j])
					System.out.print("1 ");
				else
					System.out.print("0 ");
			}
			System.out.println("");
		}

	}
}
