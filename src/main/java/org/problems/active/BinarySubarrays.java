package org.problems.active;

/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * 
 * Example 1:
 * 
 * Input: A = [1,0,1,0,1], S = 2 Output: 4 
 * 
 * Explanation: 
 * The 4 subarrays are bolded below: 
 * 
 * [1,0,1] [1,0,1,0] [0,1,0,1] [1,0,1]
 * 
 * 
 * Note:
 * 
 * A.length <= 30000 0 <= S <= A.length A[i] is either 0 or 1
 * 
 */
public class BinarySubarrays {
	
	public static int numSubarraysWithSum(int[] a, int s) {
		int total = 0;
		int left = 0;
		int right = 0;
		
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		
		int sum = 0;
		boolean complete = false;
		int it = 0;
		while(!complete) {
			// find min LEFT array with sum = s
			boolean updated = false;
			while (right < n && sum < s) {
				sum += a[right];
				right++;
				updated = true;
			}
			// SUM[left,right] = s - inclusive
			total ++;
			System.out.println("right search:"+left+":"+right+"total="+total);
			// increase right until 0
			int i = right;
			while (i < n && a[i] == 0) {
				i++;
				total++;
			}
			System.out.println("extra 0:"+left+":"+right+"total="+total);
			// increase left until s changed
			sum -= a[left];
			left++;
			while (left < right && sum == s) {
				sum -= a[left];
				total++;
			}
			if (updated) {
				right--;
			}

			System.out.println("left search:"+left+":"+right+"total="+total);
			if (right < n) {
				right++;
			}
			System.out.println("end of cycle:"+left+":"+right);
			if (right == n) {
				complete = true;
			}
//			if (it++ > 100)
//				complete = true;
		}
		
		return total;
        
    }


	public static void main(String[] arg) {

		int[] arr = {1,0,1,0,1};
		System.out.println(numSubarraysWithSum(arr,2));

		int[] arr1 = {1,0,1,0,1};
		System.out.println(numSubarraysWithSum(arr1,3));

		int[] arr2 = {1,0,1,0,1};
		System.out.println(numSubarraysWithSum(arr2,1));

		int[] arr3 = {1,1,1};
		System.out.println(numSubarraysWithSum(arr3,1));

		int[] arr4 = {0};
		System.out.println(numSubarraysWithSum(arr4,1));

		int[] arr5 = {0,0,0};
		System.out.println(numSubarraysWithSum(arr5,0));

	}

}
