package cci;

/**
 * 
 * @author banve02
 *
 * Given two strings check if they are one edit(0 edit) away
 * One edit would be insert/remove/replace of single character
 *  pale pal -> true
 *  pale pales -> true
 *  pale bake -> false
 */
public class Solution1_5 {

	public static void main(String[] args) {
		String s1 = "pales";
		String s2 = "bake";
		
		if(s1.length() == s2.length()) {
			if(replace(s1, s2))
				System.out.println("Replace :: true");
			else
				System.out.println("Replace :: false");
		}
		else if(s1.length()+1 == s2.length())
			if(insert(s1, s2))
				System.out.println("Insert :: true");
			else
				System.out.println("Insert :: false");
		else if(s1.length() == s2.length()+1)
			if(insert(s1, s2))
				System.out.println("Remove :: true");
			else
				System.out.println("Remove :: false");
		else
			System.out.println("Invalid input");
		
	}

	private static boolean insert(String s1, String s2) {
		int index1 =0, index2 = 0;
		boolean found = true;
		while(index1<s1.length() && index2<s2.length()) {
			if(s1.charAt(index1) == s2.charAt(index2)) {
				index1++;
				index2++;
			}else {
				if(index1 != index2)
					return false;
				index1++;
			}				
		}
		return found;
	}

	private static boolean replace(String s1, String s2) {
		boolean foundReplace = false;
		int index=0;
		while(index<s1.length()) {
			if(s1.charAt(index) != s2.charAt(index)) {
				if(foundReplace)
					return false;
				foundReplace = true;			
			}
			index++;
		}
		return foundReplace;
	}

}
