package com.leetcode.strings;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/valid-palindrome/
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: true 
 * 
 * Example 2:
 * 
 * Input: "race a car" Output: false
 * 
 * 
 */
public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		if (s == null || s == "") {
			return true;
		}
		String normal = s.toLowerCase().replace(" ", "");
		char[] arr = new char[normal.length()];
		int idx = 0;
		for (int i = 0; i < normal.length(); i++) {
			char c = normal.charAt(i);
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				arr[idx++] = c;
			}
		}
		Utils.print(arr, 0);
		int j = 0;
		while (j < idx) {
			if (arr[j] != arr[idx-j-1]) {
				return false;
			}
			j++;
		}
		return true;
    }
	
	public static void main(String[] arg) {

		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome("r"));
		System.out.println(isPalindrome("rrrr"));

	}
}
