package com.leetcode.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * Input: "3-2*2/2" Output: 1 *- => *MINUS /- => /MINUS -- => + +- => +MINUS
 * split:
 * 
 * 3-2*2/2 -> [3]+[MINUS2*2/2] a1=3 a2=-2 a3=2 a4=2
 * 
 *
 *
 * 
 */
public class BasicCalculatorII {

	enum Operation {
		ADD, DIV, MULT, PUT, GET
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

	static class Block {
		public int val = 0;
		public List<Integer> values;
		public List<Character> operators;

		public Block(int sign, int val, Operation op) {
		}

		public void evaluate(Result result) {

		}

		@Override
		public String toString() {
			return "[vals=" + values + ",operators=" + operators + "]";
		}
	}

	public static void evaluateDiv(String s, List<Operation> operations, List<Integer> vals) {
		String[] divisors = s.split("DIV");
		vals.add(Integer.valueOf(divisors[0]));
		for (int i = 1; i < divisors.length; i++) {
			operations.add(Operation.DIV);
			vals.add(Integer.valueOf(divisors[i]));
		}
	}

	public static int calculate(String s) {
		String expr = s.replace("*--", "*").replace("*-", "*MINUS").replace("/--", "/").replace("/-", "/MINUS")
				.replace("--", "PLUS").replace("++", "PLUS").replace("+", "PLUS").replace("-", "PLUSMINUS")
				.replace("*", "PROD").replace("/", "DIV");
		;
		// normalize
		String[] blocks = expr.split("PLUS");
		Utils.print(blocks);

		int res = 0;
		for (String block : blocks) {
			int sign = 1;
			String normal = null;
			if (block.contains("MINUS")) {
				sign = -1;
				normal = block.replace("MINUS", "");
			} else {
				normal = block;
			}
			List<List<Integer>> numbers = new ArrayList<>();
			
			List<Operation> operations = new ArrayList<>();
			List<Integer> vals = new ArrayList<>();
			String[] products = normal.split("PROD");
			evaluateDiv(products[0], operations, vals);
			for (int i = 1; i < products.length; i++) {
				operations.add(Operation.MULT);
				evaluateDiv(products[i], operations, vals);
			}

			Integer temp = vals.get(0);
			for (int i = 1; i < vals.size(); i++) {
				if (operations.get(i-1) == Operation.MULT) {
					temp = temp * vals.get(i);
				}else if (operations.get(i-1) == Operation.DIV) {
					temp = temp / vals.get(i);
				}
			}
			
			res += sign * temp;
		}
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(calculate("1+2*3/2-5"));// -1
		System.out.println(calculate("1*5*3-2*3/2+5-2/3"));// 17
		System.out.println(calculate("1/2*3/2-5"));// -5

	}

}
