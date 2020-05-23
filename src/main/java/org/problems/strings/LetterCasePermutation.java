package org.problems.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 * 
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string. Return a list of all possible strings
 * we could create.
 * 
 * Examples: Input: S = "a1b2" Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4" Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345" Output: ["12345"] 
 * 
 * Note:
 * 
 * S will be a string with length between 1 and 12. S will consist only of
 * letters or digits
 */
public class LetterCasePermutation {
	
	static class Letter {
		public char c;
		public char cUpper;
		public boolean isDigit = false;
		
		public Letter(char c) {
			this.c = c;
			if (c >= 'a' && c <= 'z') {
				isDigit = false;
				this.cUpper = (char) ((c - 'a') + 'A');
			}else if (c >= 'A' && c <= 'Z') {
				isDigit = false;
				this.cUpper = (char) ((c - 'A') + 'a');
			}else {
				isDigit = true;
			}
		}

	}
	
	static String getString(int num, List<Letter> letters) {
		StringBuilder sb = new StringBuilder();
		for (Letter letter : letters) {
			if (!letter.isDigit) {
				if ((num & 1) == 1) {
					sb.append(letter.cUpper);
				}else {
					sb.append(letter.c);
				}
				num = num >> 1;
			}else {
				sb.append(letter.c);
			}
		}
		return sb.toString();
	}
	

	public static List<String> letterCasePermutation(String s) {
		
		List<Letter> letters = new ArrayList<>();
		int nonDigits = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			letters.add(new Letter(s.charAt(i)));
		}
		for (Letter letter : letters) {
			if (!letter.isDigit) {
				nonDigits ++;
			}
		}

		List<String> res = new ArrayList<>();
		if (nonDigits == 0) {
			res.add(s);
		}else {
			int maxInt = (int) (Math.pow(2, nonDigits));
			while (maxInt-- > 0) {
				res.add(getString(maxInt, letters));
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(letterCasePermutation("a1b2"));
		System.out.println(letterCasePermutation("123"));
		System.out.println(letterCasePermutation("3z4"));
		System.out.println(letterCasePermutation(""));

	}

}
