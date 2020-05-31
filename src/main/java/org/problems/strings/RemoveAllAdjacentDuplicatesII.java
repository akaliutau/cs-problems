package org.problems.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * 
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side of
 * the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to
 * delete. 
 * 
 * Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
 * "ddd", get "aa" 
 * 
 * Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 10^5 
 * 2 <= k <= 10^4 
 * s only contains lower case English
 * letters.
 * 
 * 
 */
public class RemoveAllAdjacentDuplicatesII {

	static class MemStack extends Stack<Character> {

		private static final long serialVersionUID = -3783784675823070785L;
		private char lastPushedChar = '\n';
		private Stack<Integer> lastPushedCharTimes = new Stack<>();


		public MemStack() {
			super();
		}
		
		public boolean canPop(int k, char c) {
			int len = this.size();
			if (len < k - 1) {
				return false;
			}
			if (c == lastPushedChar && !lastPushedCharTimes.isEmpty() && lastPushedCharTimes.peek() >= k - 1) {
				this.setSize(len - k + 1);
				this.trimToSize();
				lastPushedCharTimes.setSize(len - k + 1);
				lastPushedCharTimes.trimToSize();
				lastPushedChar = this.isEmpty() ? '\n' : this.peek();
				return true;
			}
			return false;
		}

		@Override
		public Character push(Character character) {
			if (character.equals(lastPushedChar)) {
				int times = lastPushedCharTimes.isEmpty() ? 1 : lastPushedCharTimes.peek() + 1;
				lastPushedCharTimes.push(times);
			} else {
				lastPushedCharTimes.push(1);
				lastPushedChar = character;
			}
			return super.push(character);
		}

	}

	public static String removeDuplicates(String s, int k) {
		int n = s.length();
		if (n == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		MemStack stack = new MemStack();
		n = s.length();
		int i = 0;
		while (i < n) {
			char c = s.charAt(i);
			if (!stack.isEmpty()) {
				if (!stack.canPop(k, c)) {
					stack.push(c);
				}
			} else {
				stack.push(c);
			}
			i++;
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();

	}

	public static void main(String[] arg) {

		System.out.println(removeDuplicates("ab", 3));
		System.out.println(removeDuplicates("abcd", 2));
		System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
		System.out.println(removeDuplicates("deedddebbcccbdaa", 3));

	}

}
