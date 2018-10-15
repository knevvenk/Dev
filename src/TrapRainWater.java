import java.util.ArrayList;
import java.util.List;

public class TrapRainWater {

	public static void main(String[] args) {
		int arr[]   = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		/**
		 * The solutions will not work for all the cases
		 * https://www.geeksforgeeks.org/trapping-rain-water/
		 */
//		int start = 0;
//		int count=0, tempCount =0;
//		for(int i =1; i<arr.length;i++) {
//			if(arr[start] < arr[i]) {
//				count += tempCount;
//				tempCount = 0;
//				start = i;
//			}
//			else if(arr[start]>arr[i]) {
//				tempCount += arr[start]-arr[i];
//			}else {
//				
//			}
//		}
//		List
//		System.out.println(count);
		
		
		int low = 0, high = arr.length-1;
		int left_max = 0, right_max=0;
		int count =0;
		while(low<=high) {
			if(arr[low]<arr[high]) {
				if(arr[low]>left_max)
					left_max = arr[low];
				else
					count += (left_max-arr[low]);
				low++;
			}else {
				if(arr[high]>right_max)
					right_max = arr[high];
				else
					count += ((right_max)-arr[high]);
				high--;
			}
		}
		System.out.println(count);
	}

}
