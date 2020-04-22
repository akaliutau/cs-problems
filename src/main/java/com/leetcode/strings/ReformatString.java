package com.leetcode.strings;

/**
 * https://leetcode.com/problems/reformat-the-string/
 * 
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of
 * lowercase English letters and digits).
 * 
 * You have to find a permutation of the string where no letter is followed by
 * another letter and no digit is followed by another digit. That is, no two
 * adjacent characters have the same type.
 * 
 * Return the reformatted string or return an empty string if it is impossible
 * to reformat the string.
 * 
 */
public class ReformatString {

	public static String reformat(String s) {
		int[] letters = new int[26];
		int[] numbers = new int[10];
		int nums = 0;
		int lets = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				numbers[c - '0']++;
				nums++;
			} else {
				letters[c - 'a']++;
				lets++;
			}
		}
		StringBuilder sb = new StringBuilder();
		int posL = 0;
		int posN = 0;
		int idx = 0;
		if (nums > lets) {
			while (posN < 10) {
				if (numbers[posN]-- > 0) {
					sb.append((char) (posN + '0'));
					break;
				}
				posN++;
			}
		}
		while (sb.length() < s.length()) {
			boolean found = false;
			while (posL < 26) {
				if (letters[posL]-- > 0) {
					sb.append((char) (posL + 'a'));
					found = true;
					break;
				}
				posL++;
			}
			if (!found && sb.length() < s.length()) {
				return "";
			}
			found = false;
			while (posN < 10) {
				if (numbers[posN]-- > 0) {
					sb.append((char) (posN + '0'));
					found = true;
					break;
				}
				posN++;
			}
			if (!found && sb.length() < s.length()) {
				return "";
			}
		}

		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(reformat("a0b1c2"));
		System.out.println(reformat("leetcode"));
		System.out.println(reformat("1229857369"));
		System.out.println(reformat("ab123"));
		System.out.println(reformat("abc13"));

	}

}
