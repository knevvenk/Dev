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
		while (d > 0) {
			for (int i = a.length - 1; i >= 0; i--) {
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
	 * Any person in the queue can bribe the person directly in front of them to
	 * swap positions. If two people swap positions, they still wear the same
	 * sticker denoting their original places in line. One person can bribe at most
	 * two others. For example, if n=8 and Person 5 bribes Person 4 , the queue will
	 * look like this: 1 2 3 5 4 6 7 8.
	 * 
	 * @param q
	 */
	static void minimumBribes(int[] q) {
		int sum = 0;
		for (int i = 0; i < q.length; i++) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
			// starts from the actual location-1;
			int startIndex = Math.max(0, (q[i] - 1) - 1);
			for (int j = startIndex; j < i; j++) {
				if (q[j] > q[i])
					sum++;
			}
		}
		System.out.println(sum);
	}

	/**
	 * Given an input with start index and end index of an array with value, find
	 * the max sum in the array. Let say size is 7 start end val 1 4 300 2 6 600 4 7
	 * 100
	 * 
	 * output is 1000
	 * 
	 * @param n
	 * @param queries
	 * @return
	 */
	static long arrayManipulation(int n, int[][] queries) {
		long maxVal = Long.MIN_VALUE;
		int qu[] = new int[3];
		long temp[] = new long[n];
		for (int i = 0; i < n; i++)
			temp[i] = 0;

		int length = queries.length;
		for (int i = 0; i < length; i++) {
			qu = queries[i];
			int start = qu[0] - 1;
			int end = qu[1] - 1;
			int val = qu[2];
			// Add the value to start index
			temp[start] += val;
			// Remove the value from end index+1;
			if (end + 1 <= n)
				temp[end + 1] += -val;
		}
		// do the contiguous sum
		for (int i = 0; i < temp.length; i++) {
			temp[i] += temp[i + 1];
			if (temp[i] > maxVal)
				maxVal = temp[i];
		}

		return maxVal;
	}

	/**
	 * Array of size n which contains elements from 1 to n and it is not in sorted
	 * order find min no of swaps to get the sorted array.
	 * 
	 * @param arr
	 * @return
	 */
	static int minimumSwaps(int[] arr) {
		int swap = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == (i + 1))
				continue;

			// if the element is not in the correct position then swap with it's actual
			// location
			// if arr[i] is 7 then swap it with the 6th pos element and decrement i index so
			// that the swapped elements can be verified again.
			int temp = arr[arr[i] - 1];
			arr[arr[i] - 1] = arr[i];
			arr[i] = temp;
			swap++;
			i--;
		}
		return swap;
	}

	private static int anagram(String s) {
		int length = s.length();
		if (length % 2 != 0)
			return -1;

		int count = 0;
		int temp[] = new int[26];
		char ch[] = s.toCharArray();
		int subLength = s.length() / 2;
		for (int i = 0; i < subLength; i++) {
			temp[ch[i] - 'a']++;
		}

		for (int j = subLength; j < s.length(); j++) {
			if (temp[ch[j] - 'a']-- <= 0)
				count++;
		}

		return count;
	}

	public static String sum(List<String> abvalues) {
		// Write your code here
		Iterator<String> it = abvalues.iterator();
		String s = it.next();
		String input[] = s.split(" ");
		int finalNum = Integer.parseInt(input[0]);
		int finalDen = Integer.parseInt(input[1]);

		while (it.hasNext()) {
			s = it.next();
			input = s.split(" ");
			int num = Integer.parseInt(input[0]);
			int den = Integer.parseInt(input[1]);

			finalNum = (finalNum * den) + (num * finalDen);
			finalDen = (finalDen * den);
		}
		// reduce(num, den);
		System.out.println(gcd(finalNum, finalDen));
		return finalNum + "  " + finalDen;
	}

	private static int gcd(int num1, int num2) {
		while (num2 != 0) {
			if (num1 > num2) {
				num1 = num1 - num2;
			} else {
				num2 = num2 - num1;
			}
		}
		return num1;
	}

	/**
	 * Print the max sub array sum of given array -2,1,-3,4,-1,2,1,-5,4 output = 6
	 * =>{4,-1,2,1}
	 * 
	 * @param A
	 * @return
	 */
	public int maxSubArray(final List<Integer> A) {
		int maxSum = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < A.size(); i++) {
			temp += A.get(i);
			if (maxSum < temp)
				maxSum = temp;
			if (temp < 0)
				temp = 0;
		}
		return maxSum;
	}

	static void printTwoElements(int arr[], int size) {
		int i;
		System.out.print("The repeating element is ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i]) - 1] > 0)
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			else
				System.out.println(Math.abs(arr[i]));
		}

		System.out.print("And the missing element is ");
		for (i = 0; i < size; i++) {
			if (arr[i] > 0)
				System.out.println(i + 1);
		}
	}
	
	/**
	 * List<String> elist = new ArrayList<String>();
	 * elist.add("<!ENTITY a1 10>");
	 * elist.add("<!ENTITY a2  a1;a1>");
			
	 * 
		elist.add("<!ENTITY a0 a1;a2>");
		elist.add("<!ENTITY a1 a2;a2>");
		elist.add("<!ENTITY a2 11888>");
		
		
	 * @param l
	 * @param entities
	 */

	static void entityExpansion(long l, List<String> entities) {
		long count = 0;
		boolean isDropped = true;
		for (String entity : entities) {
			entity = entity.substring(0, entity.length() - 1);
			String[] arr = entity.split(" ");
			if (arr[2].contains(";")) {
				String[] entityJoin = arr[2].split(";");
				count += entityJoin.length;
			} else {
				try {
					Integer.parseInt(arr[2]);
					count++;
				} catch (Exception e) {
					isDropped = false;
				}
			}

		}
		if (count > l || !isDropped) {
			System.out.println("0 " + count);

		} else
			System.out.println("1 " + count);

	}
	
	static int findParkingPrice(String entryTime, String leavingTime) {
		entryTime = "10:40";
		leavingTime = "13:21";
        String[] entry = entryTime.split(":");
        String[] exit = leavingTime.split(":");
        int hr = Integer.parseInt(exit[0])-Integer.parseInt(entry[0]);
        int min = Integer.parseInt(exit[1])-Integer.parseInt(entry[1]);
        
        int amount = 2+3;
        hr *= 60;
        min += hr;
        if(min > 60){
            min -= 60;
            amount += (Math.floor(min/60) * 4);
            
        }
//        
//        if(min<0)
//        	hr -= 1;
//        if(min>=0)
//            hr += 1;
//        int amount = 2;
//        if(hr>0) {
//        	if(hr>=1) {
//        		amount+=3;
//        		hr -=1;
//        	}
//        	if(hr>0)
//        		amount += (hr*4);
//        }
        System.out.println(amount);
        return amount;

    }
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int[] a = { 1, 4, 2, 3, 5 };

		// for (int i = 0; i < 6; i++) {
		// String[] arrRowItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		// for (int j = 0; j < 6; j++) {
		// int arrItem = Integer.parseInt(arrRowItems[j]);
		// arr[i][j] = arrItem;
		// }
		// }

		int[] te = { 389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82,
				41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286,
				121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358,
				209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421,
				313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265,
				508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263,
				262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314,
				480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95,
				375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532,
				292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122,
				162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478,
				477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354,
				278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274,
				275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276,
				83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67,
				498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515,
				111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19,
				49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426,
				514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306,
				449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268,
				71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46,
				40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473,
				165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135,
				269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303,
				530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260 };

		// repeatedNumber(te);
		// int[] arr = {7,3,4,5,5,6,2};
		// printTwoElements(arr, 7);
		List<String> elist = new ArrayList<String>();
		elist.add("<!ENTITY a0 a1;a2>");
		elist.add("<!ENTITY a1 a2;a2>");
		elist.add("<!ENTITY a2 11888>");

		//entityExpansion(1, elist);
		findParkingPrice("","");
		// System.out.println(anagram(s));
		List<String> list = new ArrayList<String>();

		// list.add("4 2");
		list.add("2 4");
		list.add("2 4");
		// list.add("2 3");
		// System.out.println(sum(list));
		// System.out.println(minimumSwaps(a));
		minimumBribes(a);
		String s1 = "f";
		String s2 = "f";
		String s3 = new String("f");
		String s4 = s3.intern();
		if (s1 == s4) {
			System.out.println("true");
		}

		if (s1.equals(s4)) {
			System.out.println("-true");
		}
		//
		// System.out.println(s.hashCode());
		// System.out.println(s1.hashCode());

		// int[] result = rotLeft(a,2);
		// for(int i:result)
		// System.out.println(i);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();
		//
		// bufferedWriter.close();
		//
		// scanner.close();
	}
}