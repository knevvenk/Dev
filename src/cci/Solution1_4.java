package cci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author banve02
 *
 * Write a function to check if it permutation of palindrome. 
 * Ex - i/p : Tact coa
 * 		o/p : True(Permutation : "tacocat" "atcocta", etc.)	
 */

public class Solution1_4 {

	public static void main(String[] args) {
		String s = "tacocat";//"tactcoa";
		Map<Character, Integer> map = new HashMap<>();
		for(int i =0; i< s.length(); i++) {
			char c = s.charAt(i);			
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		
		System.out.println(map);
		Iterator<Integer> it = map.values().iterator();
		int odd = 0;
		while(it.hasNext()) {
			int count = it.next();
			odd += count%2;
			System.out.println(count+" -- "+odd);
		}
		if(odd == 1)
			System.out.println("True");
		else
			System.out.println("False");
	}
	
}
