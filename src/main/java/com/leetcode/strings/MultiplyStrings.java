package com.leetcode.strings;

/**
 * Product of 2 numbers
 */
public class MultiplyStrings {

	public static int convert(String num) {
		int base = 1;
		int numb = 0;
		for (int i = num.length() - 1; i > -1; i--) {
			numb += base * (num.charAt(i) - 48);
			base *= 10;
		}
		System.out.println(numb);
		return numb;
	}

	public static String convert(int num) {
		int base = (int) Math.log10(num);
		int factor = (int) Math.pow(10, base);
		StringBuilder sb = new StringBuilder();
		while (factor > 1) {
			int n = (int) num / factor;
			sb.append(n);
			num -= n * factor;
			factor /= 10;
		}
		sb.append(num);
		return sb.toString();
	}

	public static String multiply(String num1, String num2) {
		return convert(convert(num1) * convert(num2));
	}

	public static void main(String[] arg) {

		System.out.println(multiply("123", "456"));

	}
}
