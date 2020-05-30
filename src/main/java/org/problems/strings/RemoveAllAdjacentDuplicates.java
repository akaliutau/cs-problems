package org.problems.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * 
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abbaca" Output: "ca" 
 * Explanation: For example, in "abbaca" we could
 * remove "bb" since the letters are adjacent and equal, and this is the only
 * possible move. The result of this move is that the string is "aaca", of which
 * only "aa" is possible, so the final string is "ca".
 * 
 * 
 * Note:
 * 
 * 1 <= S.length <= 20000 
 * S consists only of English lowercase letters.
 * 
 * 
 */
public class RemoveAllAdjacentDuplicates {

	public static String removeDuplicates(String s) {
		
		int n = s.length();
		if (n == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		boolean removed = true;
		Stack<Character> stack = new Stack<>();
		while (removed) {
			n = s.length();
			int i = 0;
			while (i < n) {
				char c = s.charAt(i);
				if (!stack.isEmpty()) {
					if (stack.peek().equals(c)) {
						stack.pop();
					}else {
						stack.push(c);
					}
				}else {
					stack.push(c);
				}
				i++;
			}
			removed = false;
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();

	}

	public static void main(String[] arg) {

		System.out.println(removeDuplicates("abbaca"));
		System.out.println(removeDuplicates("abbdsddddaca"));
		System.out.println(removeDuplicates("aaa"));

	}

}
