package org.problems.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 */
public class PhoneLetterCombinations {
	
	static List<String> add(String first, String second) {
		List<String> lstRes = new ArrayList<>();
		for (int i = 0; i < first.length(); i++) {
			lstRes.add(first.charAt(i) + second);
		}
		return lstRes;
	}
	
	public static List<String> letterCombinations(String digits) {
		String[] map = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wyxz"};
		char[] digs = digits.toCharArray();
		List<String> res = new ArrayList<>();
		for (int i = digs.length - 1; i > -1; i--) {
			int d = (digs[i] - '0') - 1;
			if (d < 1) {
				continue;
			}
			List<String> lst = new ArrayList<>();
			for (String s : res) {
				lst.addAll(add(map[d], s));
			}
			if (res.isEmpty()) {
				res = add(map[d],"");
			}else {
				res = lst;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("123"));
	}

}
