package org.problems.math;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class ReduceANumber {

	public static final int n = 12;

	public static int numberOfSteps(int num) {
		int steps = 0;
		while (num != 0) {
			num = num % 2 == 0 ? num / 2 : num - 1;
			steps++;
		}
		return steps;
	}

	public static void main(String[] arg) {

		int k = 8;

		int res = numberOfSteps(k);

		System.out.print(res);

	}

}
