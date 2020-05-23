package org.problems.active;

import java.util.Arrays;
import java.util.Comparator;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 * 
 * Given an integer array A, you partition the array into (contiguous) subarrays
 * of length at most K. After partitioning, each subarray has their values
 * changed to become the maximum value of that subarray.
 * 
 * Return the largest sum of the given array after partitioning.
 * 
 * 
 * Example 1:
 * Input: A = [1,15,7,9,2,5,10], K = 3 Output: 84 
 * Explanation: A becomes [15,15,15,9,10,10,10]
 * 
 * Note:
 * 1 <= K <= A.length <= 500 
 * 0 <= A[i] <= 10^6
 */
public class PartitionArrayForMaximumSum {
	
	static class Number {
		public int pos;
		public int num;
		
		public Number(int pos, int num) {
			this.pos = pos;
			this.num = num;
		}

		@Override
		public String toString() {
			return "[pos=" + pos + ", n=" + num + "]";
		}
	}
	
	static Comparator<Number> byNum = (o,p) -> Integer.compare(p.num, o.num);// desc
	static Comparator<Number> byNumAsc = (o,p) -> Integer.compare(o.num, p.num);// asc
	
	// returns list of k max elems
	static Number[] getMax(int[] a, int point, int k) {
		int left = point - k;
		int right = point + k;
		if (left < 0 ) {
			left = 0;
		}
		if (right > a.length) {
			right = a.length;
		}
		int idx = 0;
		Number[] nums = new Number[right-left-1];
		for (int i = left; i < right; i++) {
			if (i != point) {
				nums[idx++] = new Number(i, a[i]);
			}
		}
		Arrays.sort(nums,byNumAsc);
		
		return nums.length < k ? nums : Arrays.copyOfRange(nums, 0, k-1);
	}
	
	public static int maxSumAfterPartitioning(int[] a, int k) {
		int sum = 0;
		if (a.length == 0) {
			return 0;
		}
		// find all points of grow
		int n = a.length;
		Number[] copy = new Number[n];
		for (int i = 0; i < n; i++) {
			copy[i] = new Number(i,a[i]);
		}
		Arrays.sort(copy,byNum);
		int idx = 0;
		int covered = 0;
		int[]  dup = new int[n];
		Arrays.fill(dup, -1);
		while (idx < n && covered < n) {
			// take grow point, find nearby in range [-k,k], sort
			Number numb = copy[idx];
			if (dup[numb.pos] == -1) {
				covered ++;
			}
			if (dup[numb.pos] < numb.num) {
				dup[numb.pos] = numb.num;
			}
			//dup[numb.pos] = numb.num;
			Number[] candidates = getMax(a, numb.pos, k);
			for (Number number : candidates) {
				if (dup[number.pos] == -1) {
					covered ++;
				}
				if (dup[number.pos] < numb.num) {
					dup[number.pos] = numb.num;
				}
			}
			idx++;
		}
		Utils.print(dup);
		
		for (int i = 0; i < n; i++) {
			sum += dup[i];
		}
		return sum;
        
    }


	public static void main(String[] arg) {

		int[] arr = {1,15,7,9,2,5,10};
		System.out.println(maxSumAfterPartitioning(arr, 3));

		int[] arr1 = {1,4,1,5,7,3,6,1,9,9,3};
		//           [7,4,7,5,7,9,6,9,9,9,9]
		System.out.println(maxSumAfterPartitioning(arr1, 4));
	}

}
