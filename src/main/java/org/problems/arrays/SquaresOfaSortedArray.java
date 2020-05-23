package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * Example 1:
 * 
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100] Example 2:
 * 
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 * 
 * 
 * Note:
 * 1 <= A.length <= 10000 
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order
 */
public class SquaresOfaSortedArray {
	
	static int sqr(int n) {
		return n * n;
	}

	public static int[] sortedSquares(int[] a) {
		int n = a.length;
		int[] res = new int[n];
		int center = 0;
		while (center < n && a[center] < 0) {
			center ++;
		}
		int left = center-1;
		int right = center;
		int idx = 0;
		while (idx < n) {
			if (left >=0 && right < n) {
				if (-a[left] < a[right]) {
					res[idx] = sqr(a[left--]);
				}else {
					res[idx] = sqr(a[right++]);
				}
			}else if (left >= 0) {
				res[idx] = sqr(a[left--]);
			}else {
				res[idx] = sqr(a[right++]);
			}
			idx++;
		}
		
		return res;
        
    }

	public static void main(String[] arg) {
		
		int[] a = {-4,-1,0,3,10};
		Utils.print(sortedSquares(a));

		int[] a1 = {-7,-3,2,3,11};
		Utils.print(sortedSquares(a1));

		int[] a2 = {-1};
		Utils.print(sortedSquares(a2));

	}

}
