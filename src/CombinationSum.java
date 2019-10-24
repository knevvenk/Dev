import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author banve02
 * 
 *         Find the combination sum from given array and sum value 
 *         c = { 2, 3, 6, 7 }, sum =7 output [2, 2, 3], [7]
 */
public class CombinationSum {

	public static void main(String[] args) {
		int[] c = { 2, 3, 6, 7, 8 };
		int sum = 8;
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		findCombinationSum(results, combination, c, sum, 0);
		System.out.println(results);
	}

	private static void findCombinationSum(List<List<Integer>> results, List<Integer> combination, int[] c, int target,
			int index) {
		if (target == 0) {
			results.add(new ArrayList<>(combination));
			return;
		}
		for (int i = index; i < c.length; i++) {
			if (c[i] > target) {
				break;
			}

			combination.add(c[i]);
			findCombinationSum(results, combination, c, target - c[i], i);
			combination.remove(combination.size() - 1);
		}
	}
	
}
