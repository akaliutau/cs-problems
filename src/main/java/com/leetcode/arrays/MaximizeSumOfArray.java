package com.leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 * 
 * Given an array A of integers, we must modify the array in the following way:
 * we choose an i and replace A[i] with -A[i], and we repeat this process K
 * times in total. (We may choose the same index i multiple times.)
 * 
 * Return the largest possible sum of the array after modifying it in this way.
 * 
 * Example 1:
 * 
 * Input: A = [4,2,3], K = 1 Output: 5 
 * Explanation: Choose indices (1,) and A becomes [4,-2,3]. 
 * 
 * Example 2:
 * 
 * Input: A = [3,-1,0,2], K = 3 Output: 6 
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2]. 
 * 
 * Example 3:
 * 
 * Input: A = [2,-3,-1,5,-4], K = 2 Output: 13 
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 
 * 1 <= K <= 10000 
 * -100 <= A[i] <= 100
 * 
 */
public class MaximizeSumOfArray {
	// 1) negatives = 0, k % 2 == 0 return a sum of all set 

	// 2) negatives = 0, k % 2 == 1 find min elem, apply operator (-1) to min element

	// 3) negatives > 0, k < negatives - replace mins from negative set

	// 4) negatives > 0, k > negatives - replace mins from negative set, then case 2
	
	static int findMinElem(int[] a) {
		int idx = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				idx = i;
				min = a[i];
			}
		}
		return idx;
	}

	public static int largestSumAfterKNegations(int[] a, int k) {
		int negatives = 0;
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		for (int i = 0; i < n; i++) {
			if (a[i] < 0) {
				negatives ++;
			}
		}
		if (negatives == 0 && k % 2 == 0){
			
		}else if (negatives == 0 && k % 2 == 1){
			int minIdx = findMinElem(a);
			a[minIdx] = - a[minIdx];
		}else if (negatives > 0 && k < negatives){
			Arrays.sort(a);
			for (int i = 0; i < k; i++) {
				a[i] = -a[i];
			}			
		}else if (negatives > 0 && k >= negatives){
			Arrays.sort(a);
			for (int i = 0; i < negatives; i++) {
				a[i] = -a[i];
			}
			if (k > negatives && (k-negatives) % 2 == 1) {
				int minIdx = findMinElem(a);
				a[minIdx] = - a[minIdx];
			}
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		return sum;

	}

	public static void main(String[] arg) {
		int[] a = {4,2,3};
		System.out.println(largestSumAfterKNegations(a,1));

		int[] a1 = {3,-1,0,2};
		System.out.println(largestSumAfterKNegations(a1,3));

		int[] a2 = {2,-3,-1,5,-4};
		System.out.println(largestSumAfterKNegations(a2,2));

		int[] a3 = {-4,-2,-3};
		System.out.println(largestSumAfterKNegations(a3,2));

	}

}
