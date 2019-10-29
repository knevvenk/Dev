import java.util.Arrays;

/**
 * 
 * @author banve02
 * 
 * Print all possible letters of given phone number.
 * ex: {2,3}
output:
[a, d]
[a, e]
[a, f]
[b, d]
[b, e]
[b, f]
[c, d]
[c, e]
[c, f]

The output tells that letter combinations belong to given input
 *
 */
public class LetterPhone {
	private static String[] letters = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		int[] arr = { 2, 3 };
		int n = arr.length;
		String[] output = new String[n];

		printPossibleLetters(arr, output, n, 0);
	}

	private static void printPossibleLetters(int[] arr, String[] output, int n, int position) {
		if (n == position) {
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i = 0; i < letters[arr[position]].length(); i++) {
			char[] a = letters[(arr[position])].toCharArray();
			output[position] = Character.toString(a[i]);
			printPossibleLetters(arr, output, n, position + 1);
		}

	}

}
