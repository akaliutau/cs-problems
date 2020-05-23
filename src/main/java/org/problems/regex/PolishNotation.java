package org.problems.regex;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * Division between two integers should truncate toward zero. The given RPN
 * expression is always valid. That means the expression would always evaluate
 * to a result and there won't be any divide by zero operation. 
 * Example 1:
 * 
 * Input: ["2", "1", "+", "3", "*"] Output: 9 
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * Example 2:
 * 
 * Input: ["4", "13", "5", "/", "+"] Output: 6 
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * Runtime: 4 ms, faster than 92.80% of Java online submissions for Evaluate Reverse Polish Notation.
 * Memory Usage: 39.5 MB, less than 6.00% of Java online submissions for Evaluate Reverse Polish Notation
 * 
 */
public class PolishNotation {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("*")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op1 * op2);
			}else if (token.equals("+")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op1 + op2);
			}else if (token.equals("-")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op2 - op1);
			}else if (token.equals("/")) {
				int op1 = stack.pop();
				int op2 = stack.pop();
				stack.push(op2 / op1);
			}else {
				stack.push(Integer.valueOf(token));
			}
		}

		return stack.isEmpty() ? 0 : stack.pop();

	}

	public static void main(String[] arg) {

		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(tokens));

		String[] tokens1 = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens1));

	}

}
