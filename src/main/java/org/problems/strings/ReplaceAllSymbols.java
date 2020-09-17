package org.problems.strings;

/**
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * 
 * Given a string s containing only lower case English letters and the '?'
 * character, convert all the '?' characters into lower case letters such that
 * the final string does not contain any consecutive repeating characters. You
 * cannot modify the non '?' characters.
 * 
 * It is guaranteed that there are no consecutive repeating characters in the
 * given string except for '?'.
 * 
 * Return the final string after all the conversions (possibly zero) have been
 * made. If there is more than one solution, return any of them. It can be shown
 * that an answer is always possible with the given constraints.
 * 
 * 
 */
public class ReplaceAllSymbols {

	static int update(char[] ch) {
		int n = ch.length;
		int changed = 0;
		for (int i = 1; i < n - 1; i++) {
			if (ch[i] == '?') {
				changed++;
				for (char c = 'a'; c <= 'z'; c++) {
					if (c != ch[i - 1] && c != ch[i + 1]) {
						ch[i] = c;
						break;
					}
				}
			}
		}
		if (ch[0] == '?') {
			changed++;
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != ch[1]) {
					ch[0] = c;
					break;
				}
			}
		}
		if (ch[n - 1] == '?') {
			changed++;
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != ch[n - 2]) {
					ch[n - 1] = c;
					break;
				}
			}
		}
		return changed;
	}

	public String modifyString(String s) {
		int n = s.length();
		char[] ch = s.toCharArray();
		update(ch);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
