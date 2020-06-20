package org.problems.strings;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 * 
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their positions.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "ab-cd" Output: "dc-ba" 
 * 
 * Example 2:
 * 
 * Input: "a-bC-dEf-ghIj" Output: "j-Ih-gfE-dCba" 
 * 
 * Example 3:
 * 
 * Input: "Test1ng-Leet=code-Q!" Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * Note:
 * 
 * S.length <= 100 
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 */
public class ReverseOnlyLetters {

	public static String reverseOnlyLetters(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		boolean[] noChar = new boolean[n];
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				noChar[i] = false;
			}else {
				noChar[i] = true;
			}
		}
		int idx = 0;
		int i = n - 1;
		while (i > -1) {
			if (idx < n && noChar[idx]) {
				sb.append(s.charAt(idx));
				idx ++;
			}else {
				if (!noChar[i]) {
					char c = s.charAt(i);
					sb.append(c);
					idx ++;
				}
				i -- ;
			}
		}
		if (idx < n && noChar[idx]) {
			sb.append(s.substring(idx));
		}
		
		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(reverseOnlyLetters("ab-cd"));
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
		System.out.println(reverseOnlyLetters("-"));
		System.out.println(reverseOnlyLetters("a"));
		System.out.println(reverseOnlyLetters("vm']4"));

	}

}
