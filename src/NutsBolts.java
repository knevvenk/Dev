
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

	private static int partition(char[] arr, int low, int high, char pivot) {
		
		char temp;
		int index = low;
		for(int i=low; i<high; i++) {
			if(arr[i]<pivot) {
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
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
