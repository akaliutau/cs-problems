package com.leetcode.minmax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 
 * Given a non-empty integer array, find the minimum number of moves required to
 * make all array elements equal, where a move is incrementing a selected
 * element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: Only two moves are needed (remember each move increments or
 * decrements one element):
 * 
 * [1,2,3] => [2,2,3] => [2,2,2]
 * 
 * Solution: 
 * 1) find the most frequent number
 * 2) if there are more than 1, get average and find nearest
 */
public class MinMovesToEqualizeArrayII {
	
	static class Number {
		public int num;
		public int diff;
		
		public Number(int num, int diff) {
			this.num = num;
			this.diff = diff;
		}
	}
	
	public static int minMoves2(int[] nums) {
        int n = nums.length;
 		if (n < 2) {
			return 0;
		}
        Arrays.sort(nums);
        int median = nums[n/2];
        int moves=0;
        
        for(int i = 0; i < n; i++){
          moves+= Math.abs(nums[i]-median);
        }
        return moves;
	}
	

	public static void main(String[] arg) {

		int[] nums = {1, 2, 3};
		System.out.println(minMoves2(nums));

		int[] nums1 = {1, 2, 2, 3, 7};
		System.out.println(minMoves2(nums1));

		int[] nums2 = {1, 1, 1, 1, 1};
		System.out.println(minMoves2(nums2));

		int[] nums3 = {1};
		System.out.println(minMoves2(nums3));

		int[] nums4 = {1, 0, 0, 8, 6};
		System.out.println(minMoves2(nums4));


	}

}
