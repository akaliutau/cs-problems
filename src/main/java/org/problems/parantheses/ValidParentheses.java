package org.problems.parantheses;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 */
public class ValidParentheses {

	public static boolean isValid(String s) {
		int n = s.length();
		char[] in = new char[n];
		for (int i = 0; i < n; i++) {
			in[i] = s.charAt(i);
		}

		int level = 100;
		int indx = 0;
		for (int i = 0; i < n; i++) {
			char c = in[i];
			if (c == '(') {
				level += 100;
				indx += level * 1;
			} else if (c == '{') {
				level += 100;
				indx += level * 2;
			} else if (c == '[') {
				level += 100;
				indx += level * 3;
			} else if (c == ')') {
				indx -= level * 1;
				level -= 100;
			} else if (c == '}') {
				indx -= level * 2;
				level -= 100;
			} else if (c == ']') {
				indx -= level * 3;
				level -= 100;
			}
		}
		return indx == 0;
	}

	public static void main(String[] arg) {

		System.out.println(isValid("()"));
		System.out.println(isValid("{}"));
		System.out.println(isValid("[])"));
		System.out.println(isValid("[{]}"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("(])"));
		System.out.println(isValid("[([]])"));
		System.out.println(isValid("()[]"));
		System.out.println(isValid("[()]"));

	}

}
