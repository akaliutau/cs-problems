package org.problems.strings;

/**
 * https://leetcode.com/problems/make-the-string-great/
 * 
 * Given a string s of lower and upper case English letters.
 * 
 * A good string is a string which doesn't have two adjacent characters s[i] and
 * s[i + 1] where:
 * 
 * 0 <= i <= s.length - 2 s[i] is a lower-case letter and s[i + 1] is the same
 * letter but in upper-case or vice-versa. To make the string good, you can
 * choose two adjacent characters that make the string bad and remove them. You
 * can keep doing this until the string becomes good.
 * 
 * Return the string after making it good. The answer is guaranteed to be unique
 * under the given constraints.
 * 
 * Notice that an empty string is also good.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leEeetcode" Output: "leetcode" Explanation: In the first step,
 * either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced
 * to "leetcode".
 * 
 * 
 * 
 */
public class MakeTheStringGreat {

	static boolean bad(char a, char b) {
		if (a >= 'a' && a <= 'z' && b >= 'A' && b <= 'Z') {
			return (a - 'a') == (b - 'A');
		} else if (a >= 'A' && a <= 'Z' && b >= 'a' && b <= 'z') {
			return (a - 'A') == (b - 'a');
		} else {
			return false;
		}
	}

	public static String makeGood(String s) {
		char[] arr = s.toCharArray();
		boolean prefect = false;
		int idx = 0;
		int n = arr.length;
		while (!prefect) {
			int i = 0;
			idx = 0;
			prefect = true;
			boolean last = false;
			while (i <= n - 2) {
				if (bad(arr[i], arr[i + 1])) {
					if (i + 2 == n) {
						last = true;
					}
					i += 2;
					prefect = false;
				} else {
					arr[idx++] = arr[i++];
				}
			}
			if (!last && n - 1 >= 0) {
				arr[idx++] = arr[n - 1];
			}
			n = idx;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < idx; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static void main(String[] arg) {
		System.out.println(makeGood("ajsSk"));
	}

}
