package org.problems.active;

/**
 * https://leetcode.com/problems/k-concatenation-maximum-sum/
 * 
 * Given an integer array arr and an integer k, modify the array by repeating it
 * k times.
 * 
 * For example, if arr = [1, 2] and k = 3 then the modified array will be 
 * [1, 2, 1, 2, 1, 2].
 * 
 * Return the maximum sub-array sum in the modified array. Note that the length
 * of the sub-array can be 0 and its sum in that case is 0.
 * 
 * As the answer can be very large, return the answer modulo 10^9 + 7.
 * 
 * Example 1:
 * Input: arr = [1,2], k = 3 Output: 9 
 * 
 * Example 2:
 * Input: arr = [1,-2,1], k = 5 Output: 2 
 * 
 * Example 3:
 * Input: arr = [-1,-2], k = 7 Output: 0
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5 
 * 1 <= k <= 10^5 
 * -10^4 <= arr[i] <= 10^4
 */
public class sol136 {
	
	/**
	 * find the biggest sum in arr starting from start
	 * (modified Kadan's alg)
	 * @param arr
	 * @return
	 */
	static long processSubArrays(int[] arr, int start, int end) {
		long maxSum = arr[start];
		long cumulativeSum = arr[start];
		int n = arr.length;
		for (int i = start + 1; i < end; i++) {
			int idx = i % n;// [0,n-1]
			cumulativeSum = arr[idx] + Math.max(cumulativeSum, 0);// will be reset to 0, if cumulativeSum falls under 0
			maxSum = Math.max(maxSum, cumulativeSum);
		}
		return maxSum < 0 ? 0 : maxSum;
	}
	
	public static int maximumSum(int[] arr, int k) {
		long base = processSubArrays(arr, 0, arr.length);
//		System.out.println("base="+base);
		if (k == 1) {
			return (int) (base % 1000000007);
		}else {
			long sum2x = processSubArrays(arr, 0, 2*arr.length);
			long sum3x = processSubArrays(arr, 0, 3*arr.length);
//			System.out.println("sum="+sum2x);
//			System.out.println("sum="+sum3x);
			if (sum2x > 0 && sum3x > 0) {
				if (2*base == sum2x && 3*base == sum3x) {
					return (int) ((base + (sum2x - base) * (k - 1)) % 1000000007);
				}else {
					return (int) sum2x % 1000000007;
				}
			}
			return 0;
		}
	}

	public static void main(String[] arg) {
		
		int[] arr = {1,2};
		System.out.println(maximumSum(arr,3));

		int[] arr1 = {1,-2,1};
		System.out.println(maximumSum(arr1,5));

		int[] arr2 = {-1,-2};
		System.out.println(maximumSum(arr2,7));

	}

}
