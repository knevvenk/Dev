/**
 * Created by bandi on 1/4/2016.
 */
//class Solution {
//	public static int solution(int[] A) {
//
//		int duplicateArray[] = new int[A.length];
//
//		for (int i = 0; i < duplicateArray.length; i++)
//			duplicateArray[i] = 0;
//		boolean maxValue = false;
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] > 0) {
//				if(A[i] < duplicateArray.length){
//					int index = A[i];
//					duplicateArray[index] = 1;
//				}
//				else if(A[i] == duplicateArray.length){
//					maxValue = true;
//				}
//			}
//		}
//		int value = -1;
//		for (int i = 1; i < duplicateArray.length; i++) {
//			if (duplicateArray[i] == 0) {
//				value = i;
//				break;
//			}
//		}
//		if (value == -1)
//			if(maxValue)
//				value = A.length+1;
//			else
//				value = A.length;
//
//		return value;
//	}
//
//	public static void main(String[] args) {
//		int[] A = { 1, 12, 0 };
//		System.out.println(solution(A));
//	}
//}



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
	 static int[] rotLeft(int[] a, int d) {
	        int val = a[0];
	        while(d>0){
	            for(int i = a.length-1;i>=0;i--){
	                int temp = a[i];
	                a[i] = val;
	                val = temp;
	            }
	            val = a[0];
	            d--;
	        }
	        return a;
	    }
	 
	 /**
	  * Any person in the queue can bribe the person directly in front of them to swap positions. 
	  * If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. 
	  * For example, if n=8 and  Person 5 bribes Person 4 , the queue will look like this: 1 2 3 5 4 6 7 8.
	  * @param q
	  */
	 static void minimumBribes(int[] q) {
		 int sum = 0;
		 for(int i=0; i<q.length;i++) {
			 if(q[i]-(i+1)>2) {
				 System.out.println("Too chaotic");
				 return;
			 }
			 //starts from the actual location-1;
			 int startIndex = Math.max(0, (q[i]-1)-1);
			 for(int j=startIndex;j<i;j++) {
				 if(q[j]>q[i])
					 sum++;
			 }
		 }
		 System.out.println(sum);
	 }
	 
	 /**
	  * Given an input with start index and end index of an array with value, find the max sum in the array.
		Let say size is 7
		start  end  val
		1      4    300
		2	   6    600
		4	   7	100
		
		output is 1000
	  * @param n
	  * @param queries
	  * @return
	  */
	 static long arrayManipulation(int n, int[][] queries) {
		 long maxVal = Long.MIN_VALUE;
		 int qu[] = new int[3];
		 long temp[] = new long[n];
		 for(int i=0; i<n; i++)
			 temp[i] = 0;
		 
		 int length = queries.length;
		 for(int i=0; i< length;i++) {             
             qu = queries[i];
             int start = qu[0]-1;
             int end = qu[1]-1;
             int val = qu[2];
             //Add the value to start index
             temp[start] += val;
             //Remove the value from end index+1;
             if(end+1 <= n)
            	 temp[end+1] += -val;
         }
		 //do the contiguous sum 
         for(int i=0; i< temp.length;i++) {
        	 temp[i] += temp[i+1];
             if(temp[i]>maxVal)
                 maxVal = temp[i];
         }
         
		 return maxVal;
	 }
	 
	 /**
	  * Array of size n which contains elements from 1 to n and it is not in sorted order
	  * find min no of swaps to get the sorted array.
	  * @param arr
	  * @return
	  */
	 static int minimumSwaps(int[] arr) {
		 int swap =0;
         for(int i=0; i<arr.length;i++) {
            if(arr[i] == (i+1))
                continue;

            //if the element is not in the correct position then swap with it's actual location
            //if arr[i] is 7 then swap it with the 6th pos element and decrement i index so that the swapped elements can be verified again.
            int temp = arr[arr[i]-1];
            arr[arr[i]-1] = arr[i];
            arr[i] = temp;
            swap++;                
            i--;
         }
         return swap;
	 }
	 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    	int[] a = {7, 1, 3, 2, 4, 5, 6};

//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//                int arrItem = Integer.parseInt(arrRowItems[j]);
//                arr[i][j] = arrItem;
//            }
//        }
    	
    	System.out.println(minimumSwaps(a));

//        int[] result = rotLeft(a,2);
//        for(int i:result)
//        	System.out.println(i);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}