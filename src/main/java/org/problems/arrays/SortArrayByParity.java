package org.problems.arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * 
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and
 * [4,2,1,3] would also be accepted.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 5000 
 * 0 <= A[i] <= 5000
 * 
 * 
 */
public class SortArrayByParity {

	public static int[] sortArrayByParity(int[] a) {
		int n = a.length;
		int[] res = new int[n];
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				res[idx++] = a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				res[idx++] = a[i];
			}
		}
		return res;

	}

	public static void main(String[] arg) {
		
		int[] a = {3,1,2,4};

		Utils.print(sortArrayByParity(a));

	}

}
