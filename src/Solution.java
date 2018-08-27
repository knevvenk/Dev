/**
 * Created by bandi on 1/4/2016.
 */
class Solution {
	public static int solution(int[] A) {

		int duplicateArray[] = new int[A.length];

		for (int i = 0; i < duplicateArray.length; i++)
			duplicateArray[i] = 0;
		boolean maxValue = false;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				if(A[i] < duplicateArray.length){
					int index = A[i];
					duplicateArray[index] = 1;
				}
				else if(A[i] == duplicateArray.length){
					maxValue = true;
				}
			}
		}
		int value = -1;
		for (int i = 1; i < duplicateArray.length; i++) {
			if (duplicateArray[i] == 0) {
				value = i;
				break;
			}
		}
		if (value == -1)
			if(maxValue)
				value = A.length+1;
			else
				value = A.length;

		return value;
	}

	public static void main(String[] args) {
		int[] A = { 1, 12, 0 };
		System.out.println(solution(A));
	}
}
