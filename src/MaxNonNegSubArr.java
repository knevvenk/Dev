import java.util.ArrayList;

public class MaxNonNegSubArr {

	/**
	 * Should return the array of Max sub non negetive array
	 * {1,2,5,-7,2,3,10}
	 * {2,3,10} is the output
	 * @param A
	 * @return
	 */
	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		long maxSum = 0, tempSum = 0;
		long mx_start = -1, mx_end = -1;
		int curr_start = 0;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > 0) {
				tempSum += A.get(i);
				if (maxSum < tempSum) {
					maxSum = tempSum;
					mx_start = curr_start;
					mx_end = i;
				} else if (tempSum == maxSum) {

				}

			} else {
				tempSum = 0;
				curr_start = i + 1;
			}
		}
		System.out.println(maxSum + "  " + mx_start + "  " + mx_end);
		return null;

	}

	/**
	 * Element A[index] in a Row(R) is sum of A[index] and A[index-1] in Row(R-1).
	 * 	[
	 * 		[1], 
	 * 		[1, 1], 
	 * 		[1, 2, 1], 
	 * 		[1, 3, 3, 1], 
	 * 		[1, 4, 6, 4, 1]
	 * 	]
	 * @param A
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> pascalTriangle(int A) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int i=0; i<A;i++) {
			result.add(new ArrayList<Integer>());
		}
		int row =0;
		int size =1;
		for(int i=0; i<A;i++) {			
			for(int j=0;j<size;j++) {
				if(row == 0)
					result.get(row).add(1);
				else {
					ArrayList<Integer> previousList = result.get(row-1);
					int indexVal = 0, prevIndexVal = 0;
					if(j<previousList.size())
						indexVal = previousList.get(j);
					if((j-1)>=0)
						prevIndexVal = previousList.get(j-1);
					result.get(row).add(indexVal+prevIndexVal);
				}
			}
			row++;
			size++;
		}
		return result;

	}
	
	/**
	 * Return the above above pascalTraingle row
	 * @param A
	 * @return
	 */
	public static ArrayList<Integer> getPascalRow(int A){
		ArrayList<ArrayList<Integer>> result = pascalTriangle(A+1);
		return result.get(A);
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(-7);
		list.add(2);
		list.add(3);
		list.add(10);
		maxset(list);
		System.out.println(getPascalRow(2));
		System.out.println(pascalTriangle(5));
	}
}
