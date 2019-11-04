import java.util.ArrayList;
import java.util.List;

public class PossiblePalindromeSubStr {

	public static void main(String[] args) {
		String str = "abadcd";
		List<List<String>> output = new ArrayList<>();
		List<String> helper = new ArrayList<>();
		int index = 0;

		findAllPalindromeSubStr(str, index, helper, output);
		System.out.println(output);
	}

	private static void findAllPalindromeSubStr(String str, int index, List<String> helper, List<List<String>> output) {
		if (index == str.length()) {
			output.add(new ArrayList<>(helper));
		}

		for (int i = index; i < str.length(); ) {
			if (palindrome(str, i, index)) {
				String s = str.substring(index, i+1);
				helper.add(s);
				findAllPalindromeSubStr(str, i+1, helper, output);
				helper.remove(helper.size()-1);
			}
			i++;
		}

	}

	private static boolean palindrome(String s, int right, int left) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

}
