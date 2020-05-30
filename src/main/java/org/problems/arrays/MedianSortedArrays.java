package org.problems.arrays;

import static org.problems.utils.Utils.print;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Runtime: 3 ms, faster than 30.29% of Java online submissions for Median of
 * Two Sorted Arrays. Memory Usage: 47.3 MB, less than 84.03% of Java online
 * submissions for Median of Two Sorted Arrays.
 */
public class MedianSortedArrays {

	public static double median(int[] nums, int len) {
		if (len % 2 == 1) {
			return (double) nums[(len - 1) / 2];
		} else {
			return ((double) nums[len / 2 - 1] + (double) nums[len / 2]) / 2;
		}
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int i = 0, j = 0, r = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[r] = arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				result[r] = arr2[j];
				j++;
			} else {
				result[r] = arr1[i];
				i++;
			}
			r++;
		}
		if (i < arr1.length) {
			System.arraycopy(arr1, i, result, r, (arr1.length - i));
			r += (arr1.length - i);
		}
		if (j < arr2.length) {
			System.arraycopy(arr2, j, result, r, (arr2.length - j));
			r += (arr2.length - j);
		}
		if (result.length > r) {
			return Arrays.copyOfRange(result, 0, r);
		}
		return result;
	}

	static class Solution {
		public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
			if (nums1.length == 0 && nums2.length == 0) {
				return 0.0;
			} else if (nums1.length == 0) {
				return median(nums2, nums2.length);
			} else if (nums2.length == 0) {
				return median(nums1, nums1.length);
			} else {
				int[] merged = merge(nums1, nums2);
				print(merged);
				return median(merged, merged.length);
			}
		}
	}

	public static void main(String[] arg) {
		// nums1 = [1, 2]
		// nums2 = [3, 4]

		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { 3, 4 };
		double res = Solution.findMedianSortedArrays(nums1, nums2);
		System.out.println(res);

		int[] nums3 = new int[] { 3 };
		int[] nums4 = new int[] { -2, -1 };
		double res2 = Solution.findMedianSortedArrays(nums3, nums4);
		System.out.println(res2);

		int[] nums5 = new int[] { 1 };
		int[] nums6 = new int[] { 1 };
		double res3 = Solution.findMedianSortedArrays(nums5, nums6);
		System.out.println(res3);

		// [1,1,1,1,1,1,1,1,1,1,4,4]
		// [1,3,4,4,4,4,4,4,4,4,4]
		// 1,1,1,1,1,1,1,1,1,1,1,3,4,4,4,4,4,4,4,4,4,4,4
		int[] nums7 = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4 };
		int[] nums8 = new int[] { 1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		double res4 = Solution.findMedianSortedArrays(nums7, nums8);
		System.out.println(res4);

	}

}
