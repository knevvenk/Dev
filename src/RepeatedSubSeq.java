
public class RepeatedSubSeq {
	public static void main(String[] args) {
		repeatedSubSeq("abxab");
	}

	private static int repeatedSubSeq(String A) {
		A = A.toLowerCase();
		int[] freq = new int[26];
		for (int i = 0; i < A.length(); i++) {
			freq[A.charAt(i) - 'a']++;
			if (freq[A.charAt(i) - 'a'] >= 3) {
				return 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		int k = 0;
		for (int i = 0; i < A.length(); i++) {
			if (freq[A.charAt(i) - 'a'] >= 2) {
				sb.append(A.charAt(i));
				k++;
			}
		}
		if (!isPolindrome(sb.toString(), 0, k - 1)) {
			return 1;
		} else
			return 0;

	}

	private static boolean isPolindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		}
		return true;
	}
}
