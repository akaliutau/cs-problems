package org.problems.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * 
 * Input: "1 + 1" Output: 2
 * 
 * Runtime: 14 ms, faster than 35.17% of Java online submissions for Basic
 * Calculator. Memory Usage: 45.8 MB, less than 30.77% of Java online
 * submissions for Basic Calculator.
 * 
 */
public class BasicCalculator {

	enum Operation {
		ADD, PUT, GET
	}

	static abstract class Expression {
		protected Expression parent;
		protected int sign;

		public abstract void evaluate(Stack<Result> stack);

		public void add(Expression expr) {
		}

		public Expression getParent() {
			return parent;
		}
	}

	static class Result {
		public int sign = 1;
		public int res = 0;

		public Result(int sign) {
			this.sign = sign;
		}

		@Override
		public String toString() {
			return String.format("%d:%d", sign, res);
		}

	}

	static class MultiElem extends Expression {
		public List<Expression> elems = new ArrayList<>();
		private Stack<Integer> inner = new Stack<>();

		public MultiElem(Expression parent) {
			this.parent = parent;
			inner.add(0);
		}

		@Override
		public void add(Expression expr) {
			this.elems.add(expr);
		}

		@Override
		public void evaluate(Stack<Result> stack) {
			for (int i = 0; i < elems.size(); i++) {
				Expression e = elems.get(i);
				e.evaluate(stack);
			}
			Result r = stack.peek();
			// r.res = r.res * sign;
		}

		@Override
		public String toString() {
			return elems.toString();
		}

	}

	static class Elem extends Expression {
		public int val;
		public Operation op;

		public Elem(Expression parent, int sign, int val, Operation op) {
			this.val = sign * val;
			this.op = op;
			this.parent = parent;
		}

		@Override
		public void evaluate(Stack<Result> stack) {
			Result seed;
			if (op == Operation.ADD) {
				seed = stack.peek();
				seed.res += val;
			} else if (op == Operation.PUT) {
				stack.add(new Result(val));
			} else {
				Result last = stack.pop();
				seed = stack.peek();
				if (val != Integer.MIN_VALUE) {
					last.res += val;
				}
				seed.res += parent.sign * last.res;
			}
		}

		@Override
		public String toString() {
			return "[sign= " + parent.sign + ",val=" + val + ",op=" + op + "]";
		}
	}

	private static void build(Expression expression, StringBuilder numb, int sign, Operation op) {
		if (numb.length() > 0) {
			expression.add(new Elem(expression, sign, Integer.parseInt(numb.toString()), op));
		} else if (op == Operation.PUT) {
			expression.add(new Elem(expression, sign, 1, op));
		} else if (op == Operation.GET) {
			expression.add(new Elem(expression, 1, Integer.MIN_VALUE, op));
		}
		numb.setLength(0);
	}

	public static int calculate(String s) {
		String expr = s.replace(" ", "");
		Stack<Result> stack = new Stack<>();

		int i = 0;

		StringBuilder numb = new StringBuilder();
		Expression expression = new MultiElem(null);
		expression.sign = 1;
		int curSign = 1;
		while (i < expr.length()) {

			char c = expr.charAt(i);
			if (c == '+') {
				build(expression, numb, curSign, Operation.ADD);
				curSign = 1;
			} else if (c == '-') {
				build(expression, numb, curSign, Operation.ADD);
				curSign = -1;
			} else if (c == '(') {
				build(expression, numb, curSign, Operation.PUT);
				Expression child = new MultiElem(expression);
				child.sign = curSign;
				expression.add(child);
				expression = child;
				curSign = 1;
			} else if (c == ')') {
				build(expression, numb, curSign, Operation.GET);
				expression = expression.getParent();
				curSign = 1;
			} else {
				numb.append(c);
			}
			i++;
		}
		build(expression, numb, curSign, Operation.ADD);

		System.out.println(expression);

		Result proc = new Result(1);
		stack.add(proc);
		expression.evaluate(stack);
		System.out.println(stack);

		return proc.res;

	}

	public static void main(String[] arg) {

		System.out.println(calculate("1+2"));// 3
		System.out.println(calculate("1+(1-3)+2"));// 1
		System.out.println(calculate("1-(1-3)-(1-3)+2"));// 7
		System.out.println(calculate("1-(-(1-3)+(1-3))+2"));// 3
		System.out.println(calculate("+1+2"));// 3
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));// 23

		System.out.println(calculate("(5-(1+(5)))"));// -1

		System.out.println(calculate("(5-(1+(5)+(-1)))"));// -1

	}

}
