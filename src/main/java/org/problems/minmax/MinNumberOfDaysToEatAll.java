package org.problems.minmax;

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
 * Explanation: You have 10 oranges. Day 1: Eat 1
 * orange, 10 - 1 = 9. Day 2: Eat 6 oranges, 9 - 2*(9/3) = 9 - 6 = 3. (Since 9
 * is divisible by 3) Day 3: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. Day 4: Eat
 * the last orange 1 - 1 = 0. You need at least 4 days to eat the 10 oranges.
 * 
 * 
 */
public class MinNumberOfDaysToEatAll {
	
	static class Result {
		public int counter;
		public boolean done = false;
		
		public Result(int counter, boolean b) {
			this.counter = counter;
			done = b;
		}
	}
	
	
	static Result trace(int cur, int counter, Map<Integer, Integer> memo) {
		if (cur == 0) {
			Result r = new Result(counter, true);
			return r;
		}
		if (cur == 1) {
			Result r = new Result(counter + 1, true);
			return r;
		}
		if (memo.containsKey(cur) && memo.get(cur) <= counter) {
			return new Result(memo.get(cur), true);
		}

		Result r, r1 = null, r2 = null;
		if (cur % 2 == 0 || cur % 3 == 0) {
			if (cur % 2 == 0) {
				r1 = trace(cur - cur / 2, counter + 1, memo);
			}
			if (cur % 3 == 0) {
				r2 = trace(cur - 2 * cur / 3, counter + 1, memo);
			}
		}
		r = trace(cur - 1, counter + 1, memo);
		int ri0 = r == null ? Integer.MAX_VALUE : r.counter;
		int ri1 = r1 == null ? Integer.MAX_VALUE : r1.counter;
		int ri2 = r2 == null ? Integer.MAX_VALUE : r2.counter;
		
		Result ret = new Result(Math.min(ri0, Math.min(ri1, ri2)), true);
		if (memo.containsKey(cur)) {
			int saved = memo.get(cur);
			memo.put(cur, Math.min(ret.counter, saved));
		}else {
			memo.put(cur, ret.counter);
		}
		return ret;
		
	}

	public static int minDays(int n) {
		Map<Integer,Integer> memo = new HashMap<>();
		Result res = trace(n, 0, memo);
		return res.counter;

	}

	public static void main(String[] arg) {
		System.out.println(minDays(0));
		System.out.println(minDays(1));
		System.out.println(minDays(2));
		System.out.println(minDays(7));//4
		System.out.println(minDays(10));//4
		System.out.println(minDays(400));//10
		System.out.println(minDays(8292));//14
	}

}
