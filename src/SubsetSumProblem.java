/**
 * 
 * @author banve02
 * 
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 */
public class SubsetSumProblem {
	private static int[] input = {3,5,2,9,10};
	public static void main(String[] args) {
		int sum = 14;
		
		findSubsetSum(input, sum);
	}

	private static void findSubsetSum(int[] inputArr, int sum) {
		int length = inputArr.length;
		int width = sum+1;
		int[][] temp = new int[length][width];
		for(int i =0; i< length; i++)
			temp[i][0] = 1;
		
		for(int i =0; i< inputArr.length;i++) {
			for(int j =1; j<=sum;j++) {
				if(j < inputArr[i]) {
					if(i == 0)
						temp[i][j] = 0;
					else
						temp[i][j] = temp[i-1][j];
				}
				else {
					
					if(i == 0) {
						if(inputArr[i] == j)
							temp[i][j] = 1;
						else
							temp[i][j] =0;
					}
					else if(temp[i-1][j] == 1)
						temp[i][j] = temp[i-1][j];
					else
						temp[i][j] = temp[i-1][j-inputArr[i]];
				}
			}
		}
		
		printArray(temp, length, width);
		System.out.println("===============================");
		printSubset(temp, length-1, width-1);
	}

	private static void printSubset(int[][] temp, int length, int width) {
		int i = length;
		int j = width;
		for(; i>0; i--) {
			for(; j>0; ) {
				if(temp[i-1][j] == 0) {
					System.out.print(input[i]+", ");
					j = j-input[i];
					i = i-1;
				}
				else {	
					
					break;
				}
			}
		}
		
	}

	private static void printArray(int[][] temp, int length, int width) {
		for(int i =0; i<length;i++) {
			for(int j =0; j<width;j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	

}
