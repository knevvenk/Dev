
/**
 * 
 * @author banve02
 * 
 *         Print all possible binary numbers of given size
 */
public class PossibleBinaryGivenSize {

	public static void main(String[] args) {
		int n = 4;
		int[] arr = new int[n];
		generateBinary(arr, n, 0);
	}

	private static void generateBinary(int[] arr, int n, int i) {
		if (i == n) {
			printArr(arr);
			return;
		}
		arr[i] = 0;
		generateBinary(arr, n, i + 1);

		arr[i] = 1;
		generateBinary(arr, n, i + 1);
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
