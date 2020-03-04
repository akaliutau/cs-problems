package com.leetcode.numbers;

/**
 * https://leetcode.com/contest/biweekly-contest-19/problems/angle-between-hands-of-a-clock/
 */
public class AngleBetweenHands {

	public static final int n = 12;

	public static double angleClock(int hour, int minutes) {

		double hourAng = (double) hour * 360 / 12;
		double minutesAng = (double) minutes * 360 / 60;
		double hourCorrection = (double) (360 / 12) * minutes / 60;

		double diff = Math.abs(hourAng + hourCorrection - minutesAng);

		return diff > 180 ? 360 - diff : diff;

	}

	public static void main(String[] arg) {

		int hour = 12;
		int minutes = 0;
		double res = angleClock(hour, minutes);

		System.out.print(res);

	}

}
