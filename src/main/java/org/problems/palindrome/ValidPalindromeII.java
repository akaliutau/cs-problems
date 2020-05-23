package org.problems.palindrome;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 * 
 * Example 1: Input: "aba" Output: True 
 * 
 * Example 2: Input: "abca" Output: True
 * Explanation: You could delete the character 'c'. 
 * 
 * Note: The string will only
 * contain lowercase characters a-z. The maximum length of the string is 50000.
 * 
 * 
 */
public class ValidPalindromeII {
	
	public static boolean isPalindrome(char[] arr, int start, int end) {
		int j = start;
		int aj = end;
		while (j < end/2+1) {
			if (arr[j] != arr[aj]) {
				return false;
			}
			j++;
			aj--;
		}
		return true;
	}

    public static boolean validPalindrome(String s) {
		if (s == null || s == "") {
			return true;
		}
		String normal = s.toLowerCase().replace(" ", "");
		int len = normal.length();
		char[] arr = new char[len];
		int idx = 0;
		for (int i = 0; i < len; i++) {
			char c = normal.charAt(i);
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				arr[idx++] = c;
			}
		}
		int j = 0;
		int aj = idx - 1;
		int deleted = -1;
		boolean excess = false;
		while (j < idx/2) {
			if (arr[j] != arr[aj]) {
				excess = true;
				break;
			}
			j++;
			aj--;
		}
		if (!excess) {
			return true;
		}
		char[] arr1 = new char[len];
		idx = 0;
		for (int i = 0; i < len; i++) {
			if ( i != j) {
				arr1[idx++] = arr[i];
			}
		}
		if (isPalindrome(arr1, 0, idx - 1)) {
			return true;
		}
		char[] arr2 = new char[len];
		idx = 0;
		for (int i = 0; i < len; i++) {
			if ( i != aj) {
				arr2[idx++] = arr[i];
			}
		}
		return isPalindrome(arr2, 0, idx - 1);
	}

	public static void main(String[] arg) {

		System.out.println(validPalindrome("A man, a plan, a canal: Panama"));//true
		System.out.println(validPalindrome("race a car"));//true
		System.out.println(validPalindrome("r"));//true
		System.out.println(validPalindrome("rrrr"));//true

		System.out.println(validPalindrome("abc"));//false
		System.out.println(validPalindrome("cbbcc"));//true
		System.out.println(validPalindrome("applee app"));//false

		System.out.println(validPalindrome("eda ead eas bcc bae dae ade p"));//false

	}
}
