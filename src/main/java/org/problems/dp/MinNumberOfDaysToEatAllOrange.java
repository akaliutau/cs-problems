package org.problems.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/
 * 
 * There are n oranges in the kitchen and you decided to eat some of these
 * oranges every day as follows:
 * 
 * Eat one orange. If the number of remaining oranges (n) is divisible by 2 then
 * you can eat n/2 oranges. If the number of remaining oranges (n) is divisible
 * by 3 then you can eat 2*(n/3) oranges. You can only choose one of the actions
 * per day.
 * 
 * Return the minimum number of days to eat n oranges.
 * 
 * Example 1:
 * 
 * Input: n = 10 Output: 4
 * 
 * Runtime: 6 ms, faster than 58.11% of Java online submissions for Minimum Number of Days to Eat N Oranges.
 * Memory Usage: 39.1 MB, less than 41.69% of Java online submissions for Minimum Number of Days to Eat N Oranges.
 */
public class MinNumberOfDaysToEatAllOrange {

	static int findMin(int n, Map<Integer, Integer> memo) {
		if (n == 0) {
			return 0;
		}
		if (memo.get(n) != null) {
			return memo.get(n);
		}
		if (n % 2 == 0 && n % 3 == 0) {
			int days = Math.min(findMin(n / 3, memo), findMin(n / 2, memo)) + 1;
			memo.put(n, days);
			return days;
		} else if (n % 2 == 0) {
			int days = Math.min(findMin(n / 2, memo), findMin(n - 1, memo)) + 1;
			memo.put(n, days);
			return days;
		} else if (n % 3 == 0) {
			int days = Math.min(findMin(n / 3, memo), findMin(n - 1, memo)) + 1;
			memo.put(n, days);
			return days;
		} else {
			int days = findMin(n - 1, memo) + 1;
			memo.put(n, days);
			return days;
		}
	}

	public static int minDays(int n) {
		Map<Integer, Integer> memo = new HashMap<>();
		if (n == 0) {
			return 0;
		}
		return findMin(n, memo);
	}

	public static void main(String[] arg) {
		System.out.println(minDays(0));
		System.out.println(minDays(1));
		System.out.println(minDays(2));
		System.out.println(minDays(7));// 4
		System.out.println(minDays(10));// 4
		System.out.println(minDays(400));// 10
		System.out.println(minDays(8292));// 14
		System.out.println(minDays(3641981));// 23
	}

}
