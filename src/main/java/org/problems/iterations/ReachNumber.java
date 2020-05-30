package org.problems.iterations;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reach-a-number/
 * 
 * You are standing at position 0 on an infinite number line. There is a goal at
 * position target.
 * 
 * On each move, you can either go left or right. During the n-th move (starting
 * from 1), you take n steps.
 * 
 * Return the minimum number of steps required to reach the destination.
 * 
 * Example 1: Input: target = 3 Output: 2 Explanation: On the first move we step
 * from 0 to 1. On the second step we step from 1 to 3.
 * 
 * Example 2: Input: target = 2 Output: 3 Explanation: On the first move we step
 * from 0 to 1. On the second move we step from 1 to -1. On the third move we
 * step from -1 to 2.
 * 
 * Note: target will be a non-zero integer in the range [-10^9, 10^9]
 * 
 */
public class ReachNumber {

	static class State {
		long target;
		int segment;
		int sign;

		public State(long target, int segment, int sign) {
			this.target = target;
			this.segment = segment;
			this.sign = sign;
		}

		@Override
		public String toString() {
			return "State [target=" + target + ", segment=" + segment + ", sign=" + sign + "]";
		}

	}

	static boolean find(long target, int segment, int sign) {
		Stack<State> stack = new Stack<>();
		State curState = new State(target, segment, sign);
		stack.add(curState);
		while (!stack.isEmpty()) {
			curState = stack.pop();
			if (curState.segment < 1) {
				continue;
			}
			long cur = curState.target + curState.sign * curState.segment;
			if (cur == 0 && curState.segment == 1) {
				return true;
			}
			if (cur != 0 && curState.segment == 1) {
				continue;
			}
			if (cur < 0) {
				State nextState = new State(cur, curState.segment - 1, +1);
				stack.add(nextState);
				continue;
			} else if (cur > 0) {
				State nextState = new State(cur, curState.segment - 1, -1);
				stack.add(nextState);
				continue;
			}
			// try both
			State nextState1 = new State(cur, curState.segment - 1, +1);
			stack.add(nextState1);
		}

		return false;

	}

	public static int reachNumber(int target) {
		if (target == 0) {
			return 0;
		}
		target = Math.abs(target);
		if (target == 1) {
			return 1;
		}
		int sum = 0;
		int n = 1;
		while (sum + n < target) {
			sum += n;
			n++;
		}
		while (true) {
			if (find(target, n, -1)) {
				return n;
			}
			n++;
		}
	}

	public static void main(String[] arg) {

		System.out.println(reachNumber(1));//1
		System.out.println(reachNumber(2));//3
		System.out.println(reachNumber(3));//2
		System.out.println(reachNumber(4));//3
		System.out.println(reachNumber(5));//5
		System.out.println(reachNumber(6));//3
		System.out.println(reachNumber(7));//5
		System.out.println(reachNumber(8));//4
		System.out.println(reachNumber(9));//5
		System.out.println(reachNumber(10000));// 5
		System.out.println(reachNumber(1000000000));// 5

	}

}
