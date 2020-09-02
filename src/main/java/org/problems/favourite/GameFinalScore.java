package org.problems.favourite;

import java.util.Stack;

/**
 * Baseball game
 * 
 * Each block comes with a symbol which can be an integer, ‘X’, ‘+’, or ‘Z’.
 * Given a list of strings represent blocks, return the final score
 * 
 * if the block is integer, add it to final score X - double the score + - sum
 * last 2 scores Z - remove last score
 * 
 */
public class GameFinalScore {

	public int calPoints(String[] ops) {

		Stack<Integer> stack = new Stack<>();
		int points = 0;
		for (int i = 0; i < ops.length; i++) {
			int n = stack.size();
			if (ops[i].equals("+")) {
				int change = stack.get(n - 1) + stack.get(n - 2);
				points += change;
				stack.push(change);
			} else if (ops[i].equals("X")) {
				int change = 2 * stack.lastElement();
				points += change;
				stack.push(change);
			} else if (ops[i].equals("Z")) {
				if (!stack.isEmpty()) {
					int lastChange = stack.pop();
					points -= lastChange;
				}
			} else {
				int change = Integer.valueOf(ops[i]);
				points += change;
				stack.push(change);
			}
		}
		return points;

	}

	public static void main(String[] arg) {

		System.out.println(true);
	}

}
