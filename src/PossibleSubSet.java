/**
 * 
 * @author banve02
 *
 *         Print all possible unique subset
 */

public class PossibleSubSet {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int subSet[] = new int[arr.length];
		possibleSubSet(arr, subSet, 0);
	}

	private static void possibleSubSet(int[] arr, int subSet[], int i) {

		if (i == arr.length) {
			printSubSet(subSet);
			return;
		}
		subSet[i] = 0;
		possibleSubSet(arr, subSet, i + 1);

		subSet[i] = arr[i];
		possibleSubSet(arr, subSet, i + 1);

	}

	private static void printSubSet(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.print(arr[i] + ",");
			}
		}
		System.out.println();
	}
}
