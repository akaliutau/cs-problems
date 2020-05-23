package org.problems.minmax;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * 
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n - 1
 * elements by 1.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 3
 * 
 * Explanation: Only three moves are needed (remember each move increments two
 * elements):
 * 
 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 */
public class MinMovesToEqualizeArray {

	public static int minMoves(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int num : nums) {
			min = Math.min(num, min);
			sum += num;
		}
		return sum - min * n;
	}

	public static void main(String[] arg) {

		int[] nums = { 1, 2, 3 };
		System.out.println(minMoves(nums));

		int[] nums1 = { 1, 2, 2, 3, 7 };
		System.out.println(minMoves(nums1));

		int[] nums2 = { 1, 1, 1, 1, 1 };
		System.out.println(minMoves(nums2));

		int[] nums3 = { 1 };
		System.out.println(minMoves(nums3));

		int[] nums4 = { 1, 0, 0, 8, 6 };
		System.out.println(minMoves(nums4));

	}
}
