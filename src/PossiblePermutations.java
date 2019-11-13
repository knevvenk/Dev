import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author banve02
 * 
 *         Given a String s = {a,b,c,d} print all possible permutations
 *
 */
public class PossiblePermutations {

	public static void main(String[] args) {
		String s = "abcd";
		Set<String> permutations = new HashSet<>();
		permutations(s, 0, permutations);
		System.out.println(permutations.size());
	}

	private static void permutations(String s, int index, Set<String> permutations) {
		if (index == s.length() - 1) {
			permutations.add(s);
//			System.out.println(s);
		} else {
			for (int i = index; i < s.length(); i++) {				
				s = swap(s, i, index);
				permutations(s, index + 1, permutations);
			}
		}

	}

	private static String swap(String s, int i, int j) {
		char[] charArr = s.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;

		return String.valueOf(charArr);
	}
}
