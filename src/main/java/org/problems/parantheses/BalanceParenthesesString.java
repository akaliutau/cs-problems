package org.problems.parantheses;

/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 * 
 * Given a parentheses string s containing only the characters '(' and ')'. A
 * parentheses string is balanced if:
 * 
 * Any left parenthesis '(' must have a corresponding two consecutive right
 * parenthesis '))'. Left parenthesis '(' must go before the corresponding two
 * consecutive right parenthesis '))'. For example, "())", "())(())))" and
 * "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * 
 * You can insert the characters '(' and ')' at any position of the string to
 * balance it if needed.
 * 
 * Return the minimum number of insertions needed to make s balanced.
 * 
 * 
 * 
 */
public class BalanceParenthesesString {

	public int minInsertions(String s) {
		int count = 0;
		int res = 0;

		// s = s.replace("))", ")");
		int n = s.length();

		for (int i = 0; i < n; ++i) {

			count += s.charAt(i) == '(' ? 2 : -1;

			if (s.charAt(i) == '(') {
				if (count % 2 != 0) {
					res++;
					count--;
				}
			} else {
				if (count < 0) {
					res++;
					count += 2;
				}
			}
		}

		return count + res;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
