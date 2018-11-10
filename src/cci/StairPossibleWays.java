package cci;

/**
 * 8.1
 * child is running up a staircase with n steps
 * can hop either 1steps ,2steps ,3steps at a time.
 *
 */
public class StairPossibleWays {

	public static void main(String[] args) {
		int n=10;
		int[] memory = new int[n+1];
		for(int i=0;i<memory.length;i++) {
			memory[i] = -1;
		}
		int count = countWays(n, memory);
		System.out.println(count);
	}

	private static int countWays(int n, int[] memory) {
		if(n<0)
			return 0;
		else if(n==0)
			return 1;
		else if(memory[n]>-1)
			return memory[n];
		else {
			memory[n] = countWays(n-1, memory)+countWays(n-2, memory)+countWays(n-3, memory);
			return memory[n];
		}
	}
}
