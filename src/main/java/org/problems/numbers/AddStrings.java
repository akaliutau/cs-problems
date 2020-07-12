package org.problems.numbers;

/**
 * https://leetcode.com/problems/add-strings/
 * 
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero.
 * 
 */
public class AddStrings {

	public static String addStrings(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();
		StringBuilder sb = new StringBuilder();
		int i1 = n1 - 1;
		int i2 = n2 - 1;
		int exs = 0;
		while ( i1 > -1 && i2 > -1) {
			int d = (num1.charAt(i1) - '0') + (num2.charAt(i2) - '0') + exs;
			exs = d >= 10 ? 1 : 0;
			sb.append(d % 10);
			i1 --;
			i2 --;
		}
		while ( i1 > -1) {
			int d = (num1.charAt(i1--) - '0') + exs;
			exs = d >= 10 ? 1 : 0;
			sb.append(d % 10);
		}
		while ( i2 > -1) {
			int d = (num2.charAt(i2--) - '0') + exs;
			exs = d >= 10 ? 1 : 0;
			sb.append(d % 10);
		}
		if (exs != 0) {
			sb.append(1);
		}
		return sb.reverse().toString();

	}

	public static void main(String[] arg) {

		System.out.println(addStrings("231","89"));
		System.out.println(addStrings("1","9"));
		System.out.println(addStrings("99","9"));

	}

}
