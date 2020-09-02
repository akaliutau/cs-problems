package org.problems.favourite;

/**
 * Balance the array
 * 
 * Given an array containing only positive integers, return if you can pick two
 * integers from the array which cuts the array into three pieces such that the
 * sum of elements in all pieces is equal.
 * 
 * Example 1:
 * 
 * Input: array = [2, 4, 5, 3, 3, 9, 2, 2, 2]
 * 
 * Output: true
 * 
 * Explanation: choosing the number 5 and 9 results in three pieces [2, 4], [3, 3] and [2, 2, 2]. 
 * Sum = 6.
 * 
 * Example 2:
 * 
 * Input: array =[1, 1, 1, 1],
 * 
 * Output: false
 * 
 */
public class BalanceTheArray {
	
	static long sum(long[] sums, int l, int r) {
		if (l - 1 < 0) {
			return sums[r];
		}
		return sums[r] - sums[l - 1];
	}
	
	static boolean balance(long[] sums) {
		int n = sums.length;
		// analyse 3 parts:
		//[0, l-1], [l+1,r-1], [r+1,n-1]
		for (int l = 1; l < n - 1; l ++) {
			long sum1 = sum(sums, 0, l - 1);
			long sum23 = sum(sums, l + 1, n - 1);
			if (sum1 > 2 * sum23) {
				break;
			}
			for (int r = l + 2; r < n; r ++) {
				long sum2 = sum(sums, l + 1, r - 1);
				long sum3 = sum(sums, r + 1, n - 1);
				if (sum2 > sum3) {
					break;
				}
				if (sum2 == sum3 && sum2 == sum1) {
					return true;
				}
			}			
		}
		return false;
	}
	
	public static boolean balancePartition(int[] nums) {
		int n = nums.length;
		if (n < 5) {
			return false;
		}
		long[] sums = new long[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
        	sums[i] = sums[i - 1] + nums[i];
        }
        
		return balance(sums);
    }

	public static void main(String[] arg) {
		
		int[] nums = {2, 4, 5, 3, 3, 9, 2, 2, 2};
		System.out.println(balancePartition(nums));

	
		int[] nums1 = {1, 4, 1, 1, 1};
		System.out.println(balancePartition(nums1));
		
		int[] nums2 = {1, 4, 5, 1, 1};
		System.out.println(balancePartition(nums2));

	}

}
