package org.problems.minmax;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 * 
 * We define a harmonious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Now, given an integer array, you need to find the length of its longest
 * harmonious subsequence among all its possible subsequences.
 * 
 * Example 1:
 * 
 * Input: [1,3,2,2,5,2,3,7] Output: 5 
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * 
 * Note: The length of the input array will not exceed 20,000
 * 
 * 
 */
public class LongestHarmoniousSubsequenceII {
	
	static class Subarray {
		public int start = 0;
		public int end = 0;
		public int max = 0;
		public int min = 0;
		public int maxIdx = 0;
		public int minIdx = 0;
		
			
		public int outOfRange(int elem) {
			if (elem > min) {
				if ( elem - min > 1) {
					return  elem - max > 1 ? 2 : 1;
				}
				//elem - min == 1
			}else if (elem < max) {
				if ( max - elem > 1) {
					return  min - elem > 1 ? -2 : -1;
				}
			}
			return 0;
		}

		
		public int length() {
			return end - start;
		}


		@Override
		public String toString() {
			return "Subarray [start=" + start + ", end=" + end + ", max=" + max + ", min=" + min + ", maxIdx=" + maxIdx
					+ ", minIdx=" + minIdx + "]";
		}
	}

	public static int findLHS(int[] nums) {
		int n = nums.length;
		if (n < 2) {// 0 or 1
			return n;
		}
		int longest = 0;
		Subarray subarr = new Subarray();
		while (subarr.end < n) {
			int cur = nums[subarr.end];
			int compare = subarr.outOfRange(cur);
			if (compare != 0) {
				if (compare == 2) {
					longest = Math.max(longest, subarr.length());
					subarr.start = subarr.end;
					subarr.max = cur;
					subarr.min = cur;
					subarr.maxIdx = subarr.end;
					subarr.minIdx = subarr.end;
				}else if (compare == 1) {
					longest = Math.max(longest, subarr.length());
					subarr.start = subarr.maxIdx;
					subarr.min = subarr.max;
					subarr.max = cur;
					subarr.minIdx = subarr.maxIdx;
					subarr.maxIdx = subarr.end;
				}else if (compare == -2) {
					longest = Math.max(longest, subarr.length());
					subarr.start = subarr.end;
					subarr.max = cur;
					subarr.min = cur;
					subarr.maxIdx = subarr.end;
					subarr.minIdx = subarr.end;
				}else if (compare == -1) {
					longest = Math.max(longest, subarr.length());
					subarr.start = subarr.minIdx;
					subarr.max = subarr.min;
					subarr.min = cur;
					subarr.maxIdx = subarr.minIdx;
					subarr.minIdx = subarr.end;
				}
			} else {// in range [min,max]
				longest = Math.max(longest, subarr.length());
				if (cur > subarr.min) {
					subarr.max = cur;
					subarr.maxIdx = subarr.end;
				}else if (cur < subarr.max) {
					subarr.min = cur;
					subarr.minIdx = subarr.end;
				}else {
					subarr.max = cur;
					subarr.min = cur;
					subarr.maxIdx = subarr.end;
					subarr.minIdx = subarr.end;
				}
			}
			System.out.println(subarr);
			subarr.end ++;
		}
		
		
		return longest;

	}

	public static void main(String[] arg) {

		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(findLHS(nums));

	}

}
