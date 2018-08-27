package cci;

/**
 * 
 * @author banve02
 * 
 * Rotate NxM matrix by 90 degrees
 */
public class Solution1_7 {

	public static void main(String[] args) {
		int[][] arr = new int[][] {
			new int[] {1,2,3,4},
			new int[] {5,6,7,8},
			new int[] {9,10,11,12},
			new int[] {13,14,15,16}
		};
		rotateMatrix(arr);
	}
	
	private static void rotateMatrix(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		
		for(int i = col-1; i>=0; i--) {
			for(int j= 0; j<row; j++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}
	}
}
