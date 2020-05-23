package org.problems.combinatorics;

/**
 * https://leetcode.com/problems/count-number-of-teams
 * 
 * There are n soldiers standing in a line. Each soldier is assigned a unique
 * rating value.
 * 
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * 
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j],
 * rating[k]). A team is valid if: (rating[i] < rating[j] < rating[k]) or
 * (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n). 
 * Return the
 * number of teams you can form given the conditions. (soldiers can be part of
 * multiple teams).
 * 
 * Example 1:
 * 
 * Input: rating = [2,5,3,4,1] Output: 3 Explanation: We can form three teams
 * given the conditions. (2,3,4), (5,4,1), (5,3,1)
 * 
 * 
 */
public class CountNumberofTeams {

	public static int numTeams(int[] rating) {
		int num = 0;
		int n = rating.length;
		if (n < 3) {
			return 0;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (rating[i] < rating[j]) {
					for (int k = j + 1; k < n; k++) {
						if (rating[j] < rating[k]) {
							num++;
						}
					}
				}
				if (rating[i] > rating[j]) {
					for (int k = j + 1; k < n; k++) {
						if (rating[j] > rating[k]) {
							num++;
						}
					}
				}
			}
		}
		return num;
	}

	public static void main(String[] arg) {

		int[] rating = { 2, 5, 3, 4, 1 };
		System.out.println(numTeams(rating));

		int[] rating1 = { 2, 1, 3 };
		System.out.println(numTeams(rating1));

		int[] rating2 = { 1, 2, 3, 4 };
		System.out.println(numTeams(rating2));

	}

}
