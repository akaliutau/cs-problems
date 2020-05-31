package org.problems.arrays;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * 
 * Given an array of integers A, find the sum of min(B), where B ranges over
 * every (contiguous) subarray of A.
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * Example 1:
 * 
 * Input: [3,1,2,4] Output: 17 
 * 
 * Explanation: Subarrays are 
 * [3], [1], [2], [4],
 * [3,1], [1,2], [2,4], 
 * [3,1,2], [1,2,4], 
 * [3,1,2,4]. 
 * 
 * Minimums are 
 *   3,  1,  2,  4, 
 *     1,  1,  2, 
 *       1,  1, 
 *         1.   
 *         
 * Sum is 17.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 30000 1 <= A[i] <= 30000
 * 
 */
public class SumOfSubarrayMins {


	public static int sumSubarrayMins(int[] a) {
		int n = a.length;

		Stack<Integer> stack = new Stack<>();
		int[] baseLevel = new int[n];
		for (int i = 0; i < n; ++i) {
			while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
				stack.pop();
			}
			baseLevel[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		stack = new Stack<>();
		int[] nextLevel = new int[n];
		for (int k = n - 1; k >= 0; --k) {
			while (!stack.isEmpty() && a[k] < a[stack.peek()]) {
				stack.pop();
			}
			nextLevel[k] = stack.isEmpty() ? n : stack.peek();
			stack.add(k);
		}

		long res = 0;
		for (int i = 0; i < n; ++i) {
			res += (i - baseLevel[i]) * (nextLevel[i] - i) % 1000000007 * a[i] % 1000000007;
			res %= 1000000007;
		}
		return (int) res;

	}

	
	public static void main(String[] arg) {

		int[] a = { 3, 1, 2, 4 };
		System.out.println(sumSubarrayMins(a));

		int[] a1 = { 1 };
		System.out.println(sumSubarrayMins(a1));

		int[] a2 = { 48, 87, 27 };
		System.out.println(sumSubarrayMins(a2));// 48 + 87 + 27 + 48 + 27 + 27




	}

}
