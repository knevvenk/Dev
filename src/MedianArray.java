import java.util.ArrayList;
import java.util.List;

public class MedianArray {

	public static void main(String[] args) {
		
		List<Integer> a1 = new ArrayList<>();
		a1.add(-50);
		a1.add(-41);
		a1.add(-40);
		a1.add(-19);
		a1.add(5);
		a1.add(21);
		a1.add(28);
		
		List<Integer> a2 = new ArrayList<>();
		a2.add(-50);
		a2.add(-21);
		a2.add(-10);
		System.out.println(findMedian(a1, a2));
	}

	private static double findMedian(final List<Integer> a, final List<Integer> b) {
		int length = a.size()+b.size();
		int[] temp = new int[length];
		int k =0, pivot =0;
		for(int i=0; i<a.size();i++) {
			temp[k] = a.get(i);
			k++;
		}
		pivot =k;
		for(int j=0; j<b.size();j++) {
			temp[k] = b.get(j);
			k++;
		}
		int a_start =0, b_start =pivot;
		int[] mergeArr = new int[length];
		int index =0;
		
		while(a_start<pivot && b_start<length) {
			if(temp[a_start]<temp[b_start]) {
				mergeArr[index] = temp[a_start];
				a_start++;
			}
			else {
				mergeArr[index]= temp[b_start];
				b_start++;
			}
			index++;
		}
		while(a_start<pivot) {
			mergeArr[index] = temp[a_start];
			a_start++;
			index++;
		}
		while(b_start<length) {
			mergeArr[index] = temp[b_start];
			b_start++;
			index++;
		}
		
		if(length%2 == 0) {
			return (double)(Math.addExact(mergeArr[length/2],mergeArr[(length/2)-1]))/2;
		}
		else {
			return (double)mergeArr[length/2];
		}
		
		
	}
}
