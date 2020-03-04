package com.leetcode.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-and-say/
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1. 1 
 * 
 * 2. 11 
 * 
 * 3. 21 
 * 
 * 4. 1211 
 * 
 * 5. 111221 
 * 
 * 1 is read off as "one 1" or 11. 11 is read
 * off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 * count-and-say sequence. You can do so recursively, in other words from the
 * previous member read off the digits, counting the number of digits in groups
 * of the same digit.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 1 Output: "1" Explanation: This is the base case. Example 2:
 * 
 * Input: 4 Output: "1211" Explanation: 
 * 
 * For n = 3 the term was "21" in which we
 * have two groups "2" and "1", "2" can be read as "12" which means frequency =
 * 1 and value = 2, the same way "1" is read as "11", so the answer is the
 * concatenation of "12" and "11" which is "1211".
 * 
 */
public class CountAndSay {
	
	public static List<String> count(List<String> str, int cur, int limit) {
		if (cur > limit) {
			return str;
		}
		List<String> res = new ArrayList<>();
		String curDigit = str.get(0);
		int counter = 1;
		for ( int i = 1; i < str.size(); i++) {
			String digit = str.get(i);
			if (!curDigit.equals(digit)) {
				res.add(""+counter);
				res.add(curDigit);
				curDigit = digit;
				counter = 0;
			}
			counter++;
		}
		res.add(""+counter);
		res.add(curDigit);
		
		return count(res,cur+1,limit);
		
	}
	
	public static String countAndSay(int n) {
		StringBuffer sb = new StringBuffer();
		List<String> res = new ArrayList<>();
		res.add("1");
		res = count(res,1,n-1);
		res.stream().forEach(s -> sb.append(s));
		return sb.toString();
        
    }

	public static void main(String[] arg) {

		int[] arr = {};
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
		System.out.println(countAndSay(29));
		System.out.println(countAndSay(30));
	}

}
