package org.problems.minmax;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-sightseeing-pair/
 * 
 * Given an array A of positive integers, A[i] represents the value of the i-th
 * sightseeing spot, and two sightseeing spots i and j have distance j - i
 * between them.
 * 
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
 * the sum of the values of the sightseeing spots, minus the distance between
 * them.
 * 
 * Return the maximum score of a pair of sightseeing spots.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [8,1,5,2,6] Output: 11 
 * 
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 
 * 
 * Note:
 * 
 * 2 <= A.length <= 50000 
 * 1 <= A[i] <= 1000
 * 
 * 
 */
public class BestSightseeingPair {
	
	static class Score {
		public int pos;
		public int val;
		
		public Score(int pos, int val) {
			this.pos = pos;
			this.val = val;
		}
	}
	
	public static int maxScoreSightseeingPair(int[] a) {
		int n = a.length;
		Score[] scores = new Score[n];
		for (int i = 0; i < n; i++) {
			scores[i] = new Score(i, a[i]);
		}
		Arrays.sort(scores, (o,p) -> Integer.compare(p.val, o.val));
		int maxCost = 0;
		for (int i = 0; i < n - 1; i++) {
			Score s1 = scores[i];
			int localCost = s1.val + scores[i + 1].val;
			if (localCost <= maxCost) {
				break;
			}
			
			for (int j = i + 1; j < n; j++) {
				int cost = s1.val + scores[j].val;
				if (cost <= maxCost) {
					break;
				}
				maxCost = Math.max(maxCost, cost - Math.abs(scores[i].pos - scores[j].pos));
			}
		}
		
		return maxCost;
        
    }


	public static void main(String[] arg) {

		int[] a = {8,1,5,2,6};
		
		System.out.println(maxScoreSightseeingPair(a));

	}

}
