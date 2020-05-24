package org.problems.arrays;

import java.util.List;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * 
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
 * these elements is repeated N times.
 * 
 * Return the element repeated N times.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3] Output: 3 
 * 
 * Example 2:
 * 
 * Input: [2,1,2,5,3,2] Output: 2 
 * 
 * Example 3:
 * 
 * Input: [5,1,5,2,5,3,5,4] Output: 5
 * 
 * 
 * Note:
 * 
 * 4 <= A.length <= 10000 
 * 0 <= A[i] < 10000 
 * A.length is even
 * 
 */
public class NRepeatedElement {

	public static int repeatedNTimes(int[] a) {
		int[] counters = new int[10001];
		for (int i = 0; i < a.length; i++) {
			counters[a[i]] ++;
			if (counters[a[i]] > 1) {
				return a[i];
			}
		}
		return -1;
        
    }

	public static void main(String[] arg) {
		int[] a = {1,2,3,3};
		System.out.println(repeatedNTimes(a));

		int[] a1 = {2,1,2,5,3,2};
		System.out.println(repeatedNTimes(a1));

		int[] a2 = {5,1,5,2,5,3,5,4};
		System.out.println(repeatedNTimes(a2));

	}

}
