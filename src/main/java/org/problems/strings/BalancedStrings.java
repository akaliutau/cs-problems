package org.problems.strings;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * 
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * 
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * 
 * Return the maximum amount of splitted balanced strings.
 * 
 * Example 1:
 * 
 * Input: s = "RLRRLLRLRL" Output: 4 Explanation: s can be split into "RL",
 * "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * 
 * Example 2:
 * 
 * Input: s = "RLLLLRRRLR" Output: 3 Explanation: s can be split into "RL",
 * "LLLRRR", "LR", each substring contains same number of 'L' and 'R'. 
 * 
 * Example 3:
 * 
 * Input: s = "LLLLRRRR" Output: 1 Explanation: s can be split into "LLLLRRRR".
 * 
 * Example 4:
 * 
 * Input: s = "RLRRRLLRLL" Output: 2 Explanation: s can be split into "RL",
 * "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 
 * s[i] = 'L' or 'R'
 */
public class BalancedStrings {

	public static int balancedStringSplit(String s) {
		int n = s.length();
		int counterL = 0;
		int counterR = 0;
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'L') {
				counterL ++;
			}else {
				counterR ++;
			}
			if (counterL == counterR) {
				counter ++;
				counterL = 0;
				counterR = 0;
			}
		}
		return counter;

	}

	public static void main(String[] arg) {

		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("RLRRRLLRLL"));

	}

}
