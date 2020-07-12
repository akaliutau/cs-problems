package org.problems.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * 
 * For a non-negative integer X, the array-form of X is an array of its digits
 * in left to right order. For example, if X = 1231, then the array form is
 * [1,2,3,1].
 * 
 * Given the array-form A of a non-negative integer X, return the array-form of
 * the integer X+K.
 * 
 * Example 1:
 * 
 * Input: A = [1,2,0,0], K = 34 Output: [1,2,3,4] 
 * Explanation: 1200 + 34 = 1234
 * 
 */
public class AddToArray {

	public static List<Integer> addToArrayForm(int[] a, int k) {
		String num2 = String.valueOf(k);
		StringBuilder sb = new StringBuilder();
		int i1 = a.length - 1;
		int i2 = num2.length() - 1;
		int exs = 0;
		while (i1 > -1 && i2 > -1) {
			int d = a[i1] + (num2.charAt(i2) - '0') + exs;
			exs = d >= 10 ? 1 : 0;
			sb.append(d % 10);
			i1--;
			i2--;
		}
		while (i1 > -1) {
			int d = a[i1--] + exs;
			exs = d >= 10 ? 1 : 0;
			sb.append(d % 10);
		}
		while (i2 > -1) {
			int d = (num2.charAt(i2--) - '0') + exs;
			exs = d >= 10 ? 1 : 0;
			sb.append(d % 10);
		}
		if (exs != 0) {
			sb.append(1);
		}
		List<Integer> res = new ArrayList<>();
		sb = sb.reverse();
		for (int i = 0; i < sb.length(); i++) {
			res.add(sb.charAt(i) - '0');
		}
		return res;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 0, 0 };
		System.out.println(addToArrayForm(a, 34));

		int[] a1 = { 0 };
		System.out.println(addToArrayForm(a1, 34));
}

}
