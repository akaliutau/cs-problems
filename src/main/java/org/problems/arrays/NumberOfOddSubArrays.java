package org.problems.arrays;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 * 
 * 
 * Given an array of integers arr. Return the number of sub-arrays with odd sum.
 * 
 * As the answer may grow large, the answer must be computed modulo 10^9 + 7
 * 
 * Example 1:
 * 
 * Input: arr = [1,3,5] Output: 4 
 * 
 * Explanation: All sub-arrays are
 * [[1],[1,3],[1,3,5],[3],[3,5],[5]] All sub-arrays sum are [1,4,9,3,8,5]. Odd
 * sums are [1,9,3,5] so the answer is 4.
 */
public class NumberOfOddSubArrays {

	public static int numOfSubarrays(int[] arr) {
		int n = arr.length;
		long count[] = { 1, 0 };

		long res = 0;
		int val = 0;

		for (int i = 0; i <= n - 1; i++) {
			val = ((val + arr[i]) % 2 + 2) % 2;
			count[val]++;
			count[val] = count[val] % 1000000007;
		}
		res = (count[0] * count[1]) % 1000000007;

		return (int) res;
	}

	public static void main(String[] arg) {
		
		int[] arr = {1,3,5};
		
		System.out.println(numOfSubarrays(arr));
	}

}
