
public class NutsBolts {
	
	public static void main(String[] args) {
		char[] nuts = {'$', '#', '@', '%', '!'};
		char[] bolts = {'!', '$', '@', '#', '%'};
		int length = nuts.length;
		
		matchPair(nuts, bolts, 0, length-1);
		System.out.println(nuts);
		System.out.println(bolts);
	}
	
	private static void matchPair(char[] nuts, char[] bolts, int low, int high) {
		if(low<high) {
			int pivot = partition(nuts, low, high, bolts[high]);
			partition(bolts, low, high, nuts[pivot]);
			
			matchPair(nuts, bolts, low, pivot-1);
			matchPair(nuts, bolts, pivot+1, high);
		}
	}
	
	/**
	 * This method will place the pivot element at it's valid position 
	 * and elements less than pivot will be moved to the left side of the pivot
	 * and elements greater than pivot will be moved to the right side of the pivot 
	 * @param arr
	 * @param low
	 * @param high
	 * @param pivot
	 * @return
	 */
	private static int partition(char[] arr, int low, int high, char pivot) {
		
		char temp;
		int index = low;
		for(int i=low; i<high; i++) {
			//if the element is less than pivot then replace element with index position value
			// because if the element is greater than pivot value then index will not be incremented
			// so the index will contain the greater value.
			if(arr[i]<pivot) {
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
			//if the element is equal to pivot then move it to the end of an array
			//and after the loop swap it with the index element.
			else if(arr[i] == pivot) {
				temp = arr[i];
				arr[i] = arr[high];
				arr[high] = temp;
				i--;
			}
		}
		temp = arr[high];
		arr[high] = arr[index];
		arr[index] = temp;
		
		return index;
	}

}
