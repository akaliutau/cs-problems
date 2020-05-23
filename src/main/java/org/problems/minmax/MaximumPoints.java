package org.problems.minmax;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * 
 * There are several cards arranged in a row, and each card has an associated
 * number of points The points are given in the integer array cardPoints.
 * 
 * In one step, you can take one card from the beginning or from the end of the
 * row. You have to take exactly k cards.
 * 
 * Your score is the sum of the points of the cards you have taken.
 * 
 * Given the integer array cardPoints and the integer k, return the maximum
 * score you can obtain
 * 
 * 
 */
public class MaximumPoints {

	public static int maxScore(int[] cardPoints, int k) {
		int score = 0;
		int n = cardPoints.length;
		int[] leftSum = new int[n];
		int[] rightSum = new int[n];
		leftSum[0] = cardPoints[0];
		for (int i = 1; i < n; i++) {
			leftSum[i] = leftSum[i - 1] + cardPoints[i];
		}
		rightSum[n - 1] = cardPoints[n - 1];
		for (int i = n - 2; i > -1; i--) {
			rightSum[i] = rightSum[i + 1] + cardPoints[i];
		}
		score = Math.max(rightSum[n - k], leftSum[k - 1]);

		for (int i = 1; i < k; i++) {
			score = Math.max(score, leftSum[i - 1] + rightSum[n - k + i]);
		}
		return score;

	}

	public static void main(String[] arg) {

		int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
		System.out.println(maxScore(cardPoints, 3));// 12

		int[] cardPoints1 = { 2, 2, 2 };
		System.out.println(maxScore(cardPoints1, 2));

		int[] cardPoints2 = { 9, 7, 7, 9, 7, 7, 9 };
		System.out.println(maxScore(cardPoints2, 7));// 55

		int[] cardPoints3 = { 1, 1000, 1 };
		System.out.println(maxScore(cardPoints3, 1));// 1

		int[] cardPoints4 = { 1, 79, 80, 1, 1, 1, 200, 1 };
		System.out.println(maxScore(cardPoints4, 3));// 202

		int[] cardPoints5 = { 100, 40, 17, 9, 73, 75 };
		System.out.println(maxScore(cardPoints5, 3));// 248

		int[] cardPoints6 = { 11, 49, 100, 20, 86, 29, 72 };
		System.out.println(maxScore(cardPoints6, 4));// 232

		int[] cardPoints7 = { 96, 90, 41, 82, 39, 74, 64, 50, 30 };
		System.out.println(maxScore(cardPoints7, 8));// 536

	}

}
