
public class SortedRotateArrSearch {

	public static void main(String[] args) {
		int arr[] = { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 };
		int key = 9;

		System.out.println(findPosition(arr, 0, arr.length - 1, key));
	}

	private static int findPosition(int[] arr, int low, int high, int key) {
		int pivot = findPivot(arr, low, high);
		System.out.println("pivot ==> "+pivot);
		if(pivot == -1)
			return binarySearch(arr, low, high, key);
		
		if(arr[pivot] == key)
			return pivot;
		
		if(arr[0] <= key)
			return binarySearch(arr, low, pivot-1, key);
		return binarySearch(arr, pivot+1, high, key);
	}

	private static int binarySearch(int[] arr, int low, int high, int key) {
		if(high < low)
			return -1;
		int mid = (low+high)/2;
		
		if(arr[mid] == key)
			return mid;
		if(arr[mid]>key)
			return binarySearch(arr, low, mid-1, key);
		else
			return binarySearch(arr, mid+1, high, key);
				
	}

	private static int findPivot(int[] arr, int low, int high) {

		int mid = (low + high) / 2;

		if (low > high)
			return -1;
		if (high >= mid && arr[mid] > arr[mid + 1])
			return mid;

		if (low <= mid && arr[mid] < arr[mid - 1])
			return mid - 1;

		if (arr[low] > arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

}
