package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/rotate-function/
 * 
 * Given an array of integers A and let n to be its length.
 * 
 * Assume Bk to be an array obtained by rotating the array A k positions
 * clock-wise, we define a "rotation function" F on A as follow:
 * 
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * 
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * 
 * Note: n is guaranteed to be less than 105.
 * 
 * Example:
 * 
 * A = [4, 3, 2, 6]
 * 
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25 
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16 
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23 
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * 
 */
public class RotateFunction {
	
	static int weightedSum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += i * a[i];
		}
		return sum;
	}

	static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static int maxRotateFunction(int[] a) {
		int n = a.length;
		int[] prefix = new int[n];
		int[] suffix = new int[n];
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 0;
		}if (n == 2) {
			return Math.max(a[0],a[1]);
		}
		// calc prefix sums
		int prefixSum = 0;
		for (int idx = n - 3; idx > -1; idx--) {
			prefixSum += a[idx+2];
			prefix[n - 1 - idx] = prefixSum;
		}
		
		int suffixSum = sum(a);
		for (int idx = n - 2; idx > -1; idx--) {
			suffix[n - 1 - idx] = suffixSum - n * a[idx+1];
			suffixSum -= a[idx+1];
		}

		int[] sums = new int[n];
		sums[0] = weightedSum(a);;
		for (int i = 1; i < n; i++) {
			sums[i] = sums[i-1] + prefix[i] + suffix[i];
		}

		int max = Integer.MIN_VALUE;
		for (Integer val : sums) {
			max = Math.max(max, val);
		}
		return max;
        
    }

	public static void main(String[] arg) {

		int[] a = {4, 3, 2, 6};
		System.out.println(maxRotateFunction(a));

		int[] a1 = {4, 3, 2};
		System.out.println(maxRotateFunction(a1));

		int[] a2 = {2};
		System.out.println(maxRotateFunction(a2));

		int[] a3 = {4, 2};
		System.out.println(maxRotateFunction(a3));

	}

}
