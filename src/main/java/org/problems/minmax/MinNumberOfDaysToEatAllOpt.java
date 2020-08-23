package org.problems.minmax;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
 * Explanation: You have 10 oranges. 
 * Day 1: Eat 1 orange, 10 - 1 = 9. 
 * Day 2: Eat 6 oranges, 9 - 2*(9/3) = 9 - 6 = 3. (Since 9 is divisible by 3) 
 * Day 3: Eat 2 oranges, 3 - 2*(3/3) = 3 - 2 = 1. 
 * Day 4: Eat the last orange 1 - 1 = 0. 
 * You need at least 4 days to eat the 10 oranges.
 * 
 * 
 */
public class MinNumberOfDaysToEatAllOpt {
	
	static enum CMD {CALLSTACK, DROP, COMPARE}
	
	static class Command {
		public CMD cmd;
		public int arg = 0;
		public int cur = 0;

		public Command(CMD cmd) {
			this.cmd = cmd;
		}

		public Command(CMD cmd, int arg) {
			this.cmd = cmd;
			this.arg = arg;
		}

		@Override
		public String toString() {
			return "Command [cmd=" + cmd + ", arg=" + arg + ", cur=" + cur + "]";
		}
	}
	
	static class Result {
		public int counter;
		public boolean done = false;
		
		public Result(int counter, boolean b) {
			this.counter = counter;
			done = b;
		}

		@Override
		public String toString() {
			return "Result [counter=" + counter + ", done=" + done + "]";
		}
	}
	
	static class Elem {
		public int cur;
		public int counter;

		public Elem(int cur, int counter) {
			this.cur = cur;
			this.counter = counter;
		}

		@Override
		public String toString() {
			return "Elem [cur=" + cur + ", counter=" + counter + "]";
		}
	}
	
	
	static void trace(int cur, int counter, Map<Integer, Integer> memo, Stack<Elem> stack, Stack<Result> results, Stack<Command> commands) {
		if (cur == 0) {
			results.add(new Result(counter, true));
			return;
		}
		if (cur == 1) {
			results.add(new Result(counter + 1, true));
			return;
		}
		if (memo.containsKey(cur) && memo.get(cur) <= counter) {
			results.add(new Result(memo.get(cur), true));
			return;
		}

		Command cmd = new Command(CMD.COMPARE);
		cmd.cur = cur;
		commands.add(cmd);
		stack.add(new Elem(cur - 1, counter + 1));
		cmd.arg ++;// at least 1 always
		commands.add(new Command(CMD.CALLSTACK));
		if (cur % 2 == 0 || cur % 3 == 0) {
			if (cur % 2 == 0) {
				stack.add(new Elem(cur - cur / 2, counter + 1));
				commands.add(new Command(CMD.CALLSTACK));
				cmd.arg ++;
			}
			if (cur % 3 == 0) {
				stack.add(new Elem(cur - 2 * cur / 3, counter + 1));
				commands.add(new Command(CMD.CALLSTACK));
				cmd.arg ++;
			}
		}
	}

	public static int minDays(int n) {
		Map<Integer,Integer> memo = new HashMap<>();
		
		// input for each cycle
		Stack<Elem> stack = new Stack<>();
		stack.add(new Elem(n, 0));
		
		// commands
		Stack<Command> commands= new Stack<>();
		commands.add(new Command(CMD.CALLSTACK));

		// results of calculations
		Stack<Result> res = new Stack<>();

		
		while (!commands.empty()) {
			Command c = commands.pop();
			if (c.cmd.equals(CMD.CALLSTACK)) {
				Elem elem = stack.pop();
				trace(elem.cur, elem.counter, memo, stack, res, commands);
			}else if (c.cmd.equals(CMD.COMPARE)) {
				int[] ret = new int[3];
				Arrays.fill(ret, Integer.MAX_VALUE);
				for (int i = 0; i < c.arg; i ++) {
					Result r = res.pop();
					ret[i] = r.counter;
				}
				
				Result result = new Result(Math.min(ret[0], Math.min(ret[1], ret[2])), true);
				if (memo.containsKey(c.cur)) {
					int saved = memo.get(c.cur);
					memo.put(c.cur, Math.min(result.counter, saved));
				}else {
					memo.put(c.cur, result.counter);
				}
				res.add(result);
			}
		}

		return res.isEmpty() ? 0 : res.pop().counter;

	}

	public static void main(String[] arg) {
		System.out.println(minDays(0));
		System.out.println(minDays(1));
		System.out.println(minDays(2));
		System.out.println(minDays(7));//4
		System.out.println(minDays(10));//4
		System.out.println(minDays(400));//10
		System.out.println(minDays(8292));//14
		System.out.println(minDays(3641981));//23
	}

}
