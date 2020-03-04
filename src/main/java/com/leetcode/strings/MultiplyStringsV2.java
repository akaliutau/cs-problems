package com.leetcode.strings;

/**
 * https://leetcode.com/problems/multiply-strings/
 * 
 * Runtime: 10 ms, faster than 28.27% of Java online submissions for Multiply
 * Strings. Memory Usage: 38 MB, less than 26.67% of Java online submissions for
 * Multiply Strings.
 */
public class MultiplyStringsV2 {

	private static void addDigit(int[] result, int resultIndex, int addendDigit) {
		int sum = result[resultIndex] + addendDigit;
		result[resultIndex] = sum % 10;
		int carry = sum / 10;
		if (carry > 0) {
			addDigit(result, resultIndex - 1, carry);
		}
	}

	private static void addDigits(int[] result, int resultIndex, int base, int addend) {
		addDigit(result, resultIndex, addend);
		addDigit(result, resultIndex - 1, base);
	}

	private static void multiplyDigit(int[] result, int resultIndex, int firstFactor, int secondFactor) {
		int product = firstFactor * secondFactor;
		int productDigit = (int) (product % 10);
		int carry = (int) (product / 10);
		addDigits(result, resultIndex, carry, productDigit);
	}

	private static void multiplyDigits(int[] result, int resultIndex, int[] firstFactor, int[] secondFactor) {
		for (int i = 0; i < firstFactor.length; i++) {
			for (int j = 0; j < secondFactor.length; j++) {
				multiplyDigit(result, resultIndex - (i + j), firstFactor[firstFactor.length - i - 1],
						secondFactor[secondFactor.length - j - 1]);
			}
		}
	}

	public static int[] convert(String num) {
		int[] res = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			res[i] = num.charAt(i) - 48;
		}
		return res;
	}

	public static String convert(int[] num) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		if (num.length > 1) {
			while (num[start] == 0 && start < num.length - 1) {
				start++;
			}
		}
		for (int i = start; i < num.length; i++) {
			sb.append(num[i]);
		}
		return sb.toString();
	}

	public static String multiply(String num1, String num2) {
		int resultLen = num1.length() + num2.length() + 1;
		int[] result = new int[resultLen];
		multiplyDigits(result, resultLen - 1, convert(num1), convert(num2));
		return convert(result);
	}

	public static void main(String[] arg) {

		System.out.println(multiply("123", "456"));
		System.out.println(multiply("0", "0"));

	}
}
