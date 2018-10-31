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
		int leftMax =arr[0];
		int[] left_arr = new int[arr.length];
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>leftMax) {
				left_arr[i] = 0;
				leftMax = arr[i];
			}
			else {
				left_arr[i] = leftMax-arr[i];
			}
				
		}
		
		int rightMax = arr[arr.length-1];
		int[] right_arr = new int[arr.length];
		for(int j=arr.length-1;j>=0;j--) {
			if(arr[j]>rightMax) {
				right_arr[j] = 0;
				rightMax = arr[j];
			}
			else
				right_arr[j]= rightMax-arr[j];
		}
		int sum =0;
		for(int k=0; k<arr.length;k++) {
			sum += Math.min(left_arr[k], right_arr[k]);
		}
		System.out.println(sum);
		
		//Method -2 
		System.out.println("=================================");
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
