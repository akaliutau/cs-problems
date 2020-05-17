package com.leetcode.arrays;

import java.util.Arrays;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 * 
 * Given an array of integers A, a move consists of choosing any A[i], and
 * incrementing it by 1.
 * 
 * Return the least number of moves to make every value in A unique.
 * 
 * Example 1:
 * 
 * Input: [1,2,2] Output: 1 Explanation: After 1 move, the array could be [1, 2, 3]. 
 * 
 * Example 2:
 * 
 * Input: [3,2,1,2,1,7] Output: 6 
 * Explanation: After 6 moves, the array could be
 * [3, 4, 1, 2, 5, 7]. It can be shown with 5 or less moves that it is
 * impossible for the array to have all unique values.
 * 
 * 1(2) 2(2) 3(1) 4(0) 5(0) 6(0) 7(1)
 * 
 * 1    1    2    2    4    5    7
 * 
 * 
 * 1   2   3->4   5->8
 * 1   1      4   8
 * 
 * 
 * Note:
 * 0 <= A.length <= 40000 
 * 0 <= A[i] < 40000
 * 
 * Runtime: 12 ms, faster than 80.16% of Java online submissions for Minimum Increment to Make Array Unique.
 * Memory Usage: 47.1 MB, less than 100.00% of Java online submissions for Minimum Increment to Make Array Unique.
 */
public class MinimumArrayIncrement {

	public static int minIncrementForUnique(int[] a) {
		
		int n = a.length;
		int[] target = new int[n];
		int cur = 0;
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			if (a[i] > cur) {
				cur = a[i];
			}
			target[i] = cur;
			cur++;
		}
		
		int changeCounter = 0;
		for (int i = 0; i < n; i++) {
			changeCounter += (target[i]-a[i]);
		}
		Utils.print(target);
		return changeCounter;

	}

	public static void main(String[] arg) {

		int[] a = {1,2,2};
		System.out.println(minIncrementForUnique(a));

		int[] a1 = {3,2,1,2,1,7};
		System.out.println(minIncrementForUnique(a1));

		int[] a2 = {1,1,1};
		System.out.println(minIncrementForUnique(a2));

		int[] a3 = {1,2,3};
		System.out.println(minIncrementForUnique(a3));

	}

}
