package org.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * 
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 * 
 * Example 1: Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
 * greater number is 2; The number 2 can't find next greater number; The second
 * 1's next greater number needs to search circularly, which is also 2. Note:
 * The length of given array won't exceed 10000
 * 
 */
public class NextGreaterElementII {
	
	static class Number {
		public int n;
		public int pos;
		
		public Number(int num, int pos) {
			this.n = num;
			this.pos = pos;
		}
		
	}

	public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        Number[] numbers = new Number[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = new Number(nums[i], i);
		}

		for (int i = 0; i < n; i++) {
			Number num = numbers[i];
				int found = -1;
				int idx = n;
				for (int j = i+1; j < i+n; j++) {
					int k = j % n;
					if (numbers[k].n > num.n) {
						if (numbers[k].pos > num.pos) {
							found = numbers[k].n;
							break;
						}						
						if (numbers[k].pos < idx) {
							found = numbers[k].n;
							idx = num.pos;
							break;
						}
					}
				}
				res[num.pos] = found;
		}
        
		return res;

        
    }

	public static void main(String[] arg) {

		int[] nums = {1, 2, 1};
		Utils.print(nextGreaterElements(nums));

		int[] nums1 = {5, 4, 3, 2, 1};
		Utils.print(nextGreaterElements(nums1));

		int[] nums2 = {1, 5, 3, 6, 8};
		Utils.print(nextGreaterElements(nums2));

		int[] nums3 = {100,1,11,1,120,111,123,1,-1,-100};
		Utils.print(nextGreaterElements(nums3));

	}

}
