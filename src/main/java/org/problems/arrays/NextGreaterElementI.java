package org.problems.arrays;

import java.util.HashMap;
import java.util.Map;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to
 * its right in nums2. If it does not exist, output -1 for this number.
 * 
 * Example 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. 
 * Output: [-1,3,-1]
 * Explanation: For number 4 in the first array, you cannot find the next
 * greater number for it in the second array, so output -1. For number 1 in the
 * first array, the next greater number for it in the second array is 3. For
 * number 2 in the first array, there is no next greater number for it in the
 * second array, so output -1. 
 * 
 * Example 2: Input: nums1 = [2,4], nums2 = [1,2,3,4]. 
 * Output: [3,-1] 
 * Explanation: For number 2 in the first array, the
 * next greater number for it in the second array is 3. For number 4 in the
 * first array, there is no next greater number for it in the second array, so
 * output -1. 
 * Note: All elements in nums1 and nums2 are unique. The length of
 * both nums1 and nums2 would not exceed 1000
 * 
 * Runtime: 2 ms, faster than 98.61% of Java online submissions for Next Greater Element I.
 * Memory Usage: 39.6 MB, less than 7.41% of Java online submissions for Next Greater Element I.
 * 
 */
public class NextGreaterElementI {
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		Map<Integer,Integer> numbMap = new HashMap<>();
		int[] minBoundary = new int[n2];//
		boolean[] existBigger = new boolean[n2];
		for (int i = 0; i < n2; i++) {
			numbMap.put(nums2[i], i);
		}
		
		int[] res = new int[n1];
		for (int i = 0; i < n1; i++) {
			int from = numbMap.get(nums1[i]) + 1;
			int found = -1;
			for (int j = from; j < n2; j++) {
				if (nums2[j] > nums1[i]) {
					found = nums2[j];
					break;
				}
			}
			res[i] = found;
		}		
		
		
		return res;

	}

	public static void main(String[] arg) {
		
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		Utils.print(nextGreaterElement(nums1, nums2));

		System.out.println(true);

	}

}
