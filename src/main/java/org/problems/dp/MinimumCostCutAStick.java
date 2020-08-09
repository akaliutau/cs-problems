package org.problems.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 * 
 * Given a wooden stick of length n units. The stick is labelled from 0 to n
 * 
 * Given an integer array cuts where cuts[i] denotes a position you should
 * perform a cut at.
 * 
 * You should perform the cuts in order, you can change the order of the cuts as
 * you wish.
 * 
 * The cost of one cut is the length of the stick to be cut, the total cost is
 * the sum of costs of all cuts. When you cut a stick, it will be split into two
 * smaller sticks (i.e. the sum of their lengths is the length of the stick
 * before the cut). Please refer to the first example for a better explanation.
 * 
 * Return the minimum total cost of the cuts.
 * 
 * Solution:
 * 
 * Let f(i, j) be the minimum magic power needed to break at all the breaking
 * points between the ith breaking point and the jth breaking point, inclusive,
 * then
 * 
 * f(i, j) = pj − pi + min (f(i, k) + f(k, j)) 
 * 					i < k < j
 *
 *
 */
public class MinimumCostCutAStick {


	public int minCost(int n, int[] cuts) {
		int size = cuts.length + 2;
		int[] cutsAll = new int[size];
		cutsAll[0] = 0;
		cutsAll[size - 1] = n;
		Arrays.parallelSort(cuts);
		for (int i = 0; i < cuts.length; i++) {
			cutsAll[i + 1] = cuts[i];
		}
		int[][] dp = new int[size][size];
		int sum = 0;

		for (int rightpos = 2; rightpos < size; rightpos++) {
			for (int leftpos = rightpos - 2; leftpos > -1; leftpos--) { // walk along the diagonals
				dp[leftpos][rightpos] = Integer.MAX_VALUE;
				for (int cutpos = leftpos + 1; cutpos <= rightpos - 1; cutpos++) {
					sum = dp[leftpos][cutpos] + dp[cutpos][rightpos];
					if (sum < dp[leftpos][rightpos]) {
						dp[leftpos][rightpos] = sum;
					}
				}
				// add own length
				dp[leftpos][rightpos] = dp[leftpos][rightpos] + cutsAll[rightpos] - cutsAll[leftpos];

			}
		}

		return dp[0][size - 1];
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
