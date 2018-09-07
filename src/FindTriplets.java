
/** 
 * @author banve02
 * 
 * https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 * 
 * Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30

Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4

Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet
 *
 */
	
public class FindTriplets {
	
	public static void main(String[] args) {
		int arr[] = {2,2,1,1,4,4};//{12, 11, 10, 5, 6, 7, 2, 30};
		findTriplets(arr);
	}

	private static void findTriplets(int[] arr) {
		int first= 10000, second =10000, third = 10000;
		int lowest = 1000;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < lowest) {
				lowest = arr[i];
			} else if (arr[i] < second && arr[i] > lowest) {
				first = lowest;
				second = arr[i];
			} else if (arr[i] > second) {
				third = arr[i];
			}
			if (second != 10000 && third != 10000)
				break;
		}
		if (second != 10000 && third != 10000)
			System.out.println(first+" "+second+" "+third);
		else
			System.out.println("Does not exist");
	}
}
