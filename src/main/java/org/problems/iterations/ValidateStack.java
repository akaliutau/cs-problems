package org.problems.iterations;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * 
 * Given two sequences pushed and popped with distinct values, return true if
 * and only if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] Output: true 
 * Explanation:
 * We might do the following sequence: push(1), push(2), push(3), push(4), pop()
 * -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1 
 * 
 * Example 2:
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2] Output: false 
 * Explanation:
 * 1 cannot be popped before 2.
 * 
 * 
 * Note:
 * 
 * 0 <= pushed.length == popped.length <= 1000 
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped. pushed and popped have distinct values.
 * 
 * 
 * 
 */
public class ValidateStack {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		
		int pushIdx = 0;
		int popIdx = 0;
		int n = pushed.length;

		Stack<Integer> have = new Stack<>();
		while (pushIdx <= n && popIdx < n) {
			int need = popped[popIdx];
			if (!have.isEmpty() && have.peek() == need) {
				have.pop();
				popIdx ++;//next
			}else {
				if (pushIdx == n) {
					break;
				}
				have.push(pushed[pushIdx]);
				pushIdx++;
			}
		}

		return pushIdx == n && popIdx == n;

	}

	public static void main(String[] arg) {
		
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		System.out.println(validateStackSequences(pushed, popped));

		int[] pushed1 = {1,2,3,4,5};
		int[] popped1 = {4,3,5,1,2};
		System.out.println(validateStackSequences(pushed1, popped1));

	}

}
