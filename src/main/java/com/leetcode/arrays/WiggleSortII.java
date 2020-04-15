package com.leetcode.arrays;

import java.util.Arrays;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 * 
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example 1:
 * 
 * Input: nums = [1, 5, 1, 1, 6, 4] 
 * Output: One possible answer is [1, 4, 1, 5, 1, 6]. 
 * 
 * [1, 1, 1, 2, 4, 5, 6, 7]
 * [6, 1, 1, 2, 4, 5, 1, 7]
 * [6, 2, 1, 1, 4, 5, 1, 7]
 * 
 * Example 2:
 * 
 * Input: nums = [1, 3, 2, 2, 3, 1] 
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 *  
 * Note: You may assume all input has valid answer
 * 
 */
public class WiggleSortII {
	
	static void swap(int[] nums, int i, int j) {
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
	}
	
	public static void wiggleSort(int[] nums) {
	    Arrays.sort(nums);
	    int n = nums.length;
        if (n <= 2){
            return;
        }
	    int left = n / 2 - 1;
	    int right = n - 1;
	    int[] res = new int[n];
	    int idx = 0;
	    while (idx < n) {
	    	res[idx++] = nums[left--];
	    	res[idx++] = nums[right--];
	    	if (idx == n) {
	    		break;
	    	}else if (left < 0) {
	    		res[idx++] = nums[right--];
	    		break;
	    	}else if (right == n / 2 - 1) {
	    		res[idx++] = nums[left--];
	    		break;
	    	}
	    }
	    for (int i = 0; i < n; i++) {
	    	nums[i] = res[i];
	    }
	    // check dup case
	    if (nums[n-1] == nums[n-2]) {
	    	// find best pos
	    	if (n % 2 == 0) {
	    		int start = 1;
		    	while (start < n) {
		    		if (nums[start] != nums[n-1] && nums[n-1] > nums[start-1]) {
		        		swap(nums,start,n-1);
		        		return;
		    		}
		    		start += 2;
		    	}
	    	}else {
	    		int start = 0;
		    	while (start < n) {
		    		if (nums[start] != nums[n-1] && nums[n-1] < nums[start+1]) {
		        		swap(nums,start,n-1);
		        		return;
		    		}
		    		start += 2;
		    	}
	    		
	    	}
	    }
	}

	public static void main(String[] arg) {
		
		int[] nums = {1, 5, 1, 1, 6, 4};
		wiggleSort(nums);
		Utils.print(nums);

		int[] nums1 = {1, 5, 1, 1, 6, 4, 7};
		wiggleSort(nums1);
		Utils.print(nums1);

		int[] nums2 = {5, 3, 1, 2, 6, 7, 8, 5, 5};
		wiggleSort(nums2);
		Utils.print(nums2);

		int[] nums3 = {1,3,2,2,2,1,1,3,1,1,2};
		wiggleSort(nums3);
		Utils.print(nums3);

	}
}
