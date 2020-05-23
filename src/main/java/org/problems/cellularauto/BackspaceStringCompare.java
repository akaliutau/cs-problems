package org.problems.cellularauto;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * 
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true 
 * Explanation: Both S and T become "ac". 
 * 
 * Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true 
 * Explanation: Both S and T become "". 
 * 
 * Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true 
 * Explanation: Both S and T become "c". 
 * 
 * Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false 
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * 
 */
public class BackspaceStringCompare {
	
	public static String convert(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s.charAt(0) == '#' ? "" : ""+s.charAt(0);
		}
		int idx = 0;
		Stack<Character> stack = new Stack<>();
		while (idx < s.length()) {
			char c = s.charAt(idx);
			if (c != '#') {
				stack.add(c);
			}else if (!stack.isEmpty()){
				stack.pop();
			}
			idx ++;
		}
		return stack.toString();
	}

	public static boolean backspaceCompare(String s, String t) {
		return convert(s).equals(convert(t));

	}

	public static void main(String[] arg) {

		System.out.println(backspaceCompare("ab#c","ad#c"));
		System.out.println(backspaceCompare("ab##","c#d#"));
		System.out.println(backspaceCompare("a##c","#a#c"));
		System.out.println(backspaceCompare("a#c","b"));
		System.out.println(backspaceCompare("a","b"));

	}

}
