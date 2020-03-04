package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class GenerateParentheses {

	static void generateParenthesis(Stack<Character> s, int n, int left, int right, Set<String> results) {
		if (right == n) {
			// print the possible combinations
			StringBuffer sb = new StringBuffer();
			Iterator<Character> itr = s.iterator();
			while (itr.hasNext()) {
				sb.append(itr.next());
			}
			results.add(sb.toString());
		} else {
			if (left > right) {
				s.add(')');
				generateParenthesis(s, n, left, right + 1, results);
				s.pop();
			}
			if (left < n) {
				s.add('(');
				generateParenthesis(s, n, left + 1, right, results);
				s.pop();
			}
		}
	}


	public static List<String> generateParenthesis(int n) {
		Stack<Character> s = new Stack<Character>();
		Set<String> set = new HashSet<>();
		if (n > 0) {
			generateParenthesis(s, n, 0, 0, set);
		}
		return new ArrayList<>(set);

	}

	public static void main(String[] arg) {

		System.out.println(generateParenthesis(1));
		System.out.println(generateParenthesis(2));
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(4));

	}

	// ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]

}
