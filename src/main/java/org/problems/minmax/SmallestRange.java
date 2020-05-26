package org.problems.minmax;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/smallest-range-ii/
 * 
 * Given an array A of integers, for each integer A[i] we need to choose either
 * x = -K or x = K, and add x to A[i] (only once).
 * 
 * After this process, we have some array B.
 * 
 * Return the smallest possible difference between the maximum value of B and
 * the minimum value of B.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1], K = 0 Output: 0 Explanation: B = [1] 
 * 
 * Example 2:
 * 
 * Input: A = [0,10], K = 2 Output: 6 Explanation: B = [2,8] 
 * 
 * Example 3:
 * 
 * Input: A = [1,3,6], K = 3 Output: 3 Explanation: B = [4,6,3]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 
 * 0 <= A[i] <= 10000 
 * 0 <= K <= 10000
 * 
 */
public class SmallestRange {
	
	public static int smallestRangeII(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : arr) {
        	set.add(i);
        }
        int[] a = new int[set.size()];
    	int idx = 0;
        for (Integer i : set) {
			a[idx++] = i;
        }
        int n = a.length;
        if (n == 1) {
        	return 0;
        }
        Arrays.sort(a);
        if (n == 2) {
        	int range1 =  Math.abs(a[0] - a[1]);
        	int range2 =  Math.abs(2 * k - Math.abs(a[0]- a[1]));
        	return Math.min(range1, range2);
        }
        int range = a[n-1] - a[0];

        for (int i = 0; i < n - 1; ++i) {
            int h = a[i];
            int l = a[i+1];
            int high = Math.max(a[n-1] - k, h + k);
            int low = Math.min(a[0] + k, l - k);
            range = Math.min(range, high - low);
        }
        return range;
      }

	public static void main(String[] arg) {
		
		int[] a = {1};
		System.out.println(smallestRangeII(a, 0));

		int[] a1 = {0, 10};
		System.out.println(smallestRangeII(a1, 2));

		int[] a2 = {1,3,6};
		System.out.println(smallestRangeII(a2, 3));

		int[] a3 = {1, 3, 5, 6};
		System.out.println(smallestRangeII(a3, 3));

		int[] a4 = {7,8,8};
		System.out.println(smallestRangeII(a4, 5));

		int[] a5 = {7,8,8,2,5};
		System.out.println(smallestRangeII(a5, 4));//5

		int[] a6 = {4,8,7,2,7};
		System.out.println(smallestRangeII(a6, 5));

	}

}
