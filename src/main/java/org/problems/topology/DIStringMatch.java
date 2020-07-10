package org.problems.topology;

import java.util.Arrays;
import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/di-string-match/
 * 
 * Given a string S that only contains "I" (increase) or "D" (decrease), 
 * let N = S.length.
 * 
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * 
 * If S[i] == "I", then A[i] < A[i+1] 
 * If S[i] == "D", then A[i] > A[i+1]
 * 
 * 
 * Example 1:
 * 
 * Input: "IDID" Output: [0,4,1,3,2] 
 * 
 * Example 2:
 * 
 * Input: "III" Output: [0,1,2,3] 
 * 
 * Example 3:
 * 
 * Input: "DDI" Output: [3,2,0,1]
 * 
 * 
 * Note:
 * 
 * 1 <= S.length <= 10000 
 * S only contains characters "I" or "D".
 * 
 * 
 * 
 */
public class DIStringMatch {
	
	static class Number {
		public int pos;
		public int val;
		
		public Number(int pos, int val) {
			this.pos = pos;
			this.val = val;
		}
		
	}

	public static int[] diStringMatch(String s) {
		int n = s.length();
		int[] rel = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'I') {
				rel[i + 1] = rel[i] + 1;
			}else if (s.charAt(i) == 'D') {
				rel[i + 1] = rel[i] - 1;
			}
		}
		Number[] nums = new Number[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nums[i] = new  Number(i, rel[i]);
		}
		Arrays.parallelSort(nums, (o,p) -> Integer.compare(o.val, p.val));
		int[] res = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			res[nums[i].pos] = i;
		}
		
		return res;

	}

	public static void main(String[] arg) {
		Utils.print(diStringMatch("IDID"));

	}

}
