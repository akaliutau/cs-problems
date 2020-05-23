package org.problems.games;

import org.problems.utils.Utils;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 *
 * 
 */
public class ClimbingTheLeaderboard {

	static int equalOrBigger(int[] scores, int score, int n) {
		int left = 0;
		int right = n - 1;
		while (right - left > 1) {
			int median = (left + right) / 2;
			if (scores[median] >= score) {
				left = median;
			} else {
				right = median;
			}
		}
		return left;
	}

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int n = scores.length;
		int m = alice.length;
		int[] res = new int[m];
		int[] rank = new int[n];
		int r = 0;
		int latest = -1;
		for (int i = 0; i < n; i++) {
			if (latest != scores[i]) {
				r++;
				latest = scores[i];
			}
			rank[i] = r;
		}
		for (int i = 0; i < m; i++) {
			int pos = equalOrBigger(scores, alice[i], n);
			if (scores[pos] == alice[i]) {
				res[i] = rank[pos];
			} else if (scores[pos] < alice[i]) {
				res[i] = rank[pos] - 1;
				res[i] = res[i] <= 0 ? 1 : res[i];
			} else {// check also next
				if (pos < n - 1 && scores[pos + 1] > alice[i]) {
					res[i] = rank[pos + 1] + 1;
				} else if (pos < n - 1 && scores[pos + 1] == alice[i]) {
					res[i] = rank[pos + 1];
				} else {
					res[i] = rank[pos] + 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] arg) {

		int[] scores = { 100, 100, 50, 40, 40, 20, 10 };
		int[] alice = { 5, 25, 50, 120 };

		Utils.print(climbingLeaderboard(scores, alice));

	}

}
