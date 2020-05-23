package org.problems.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-multiple-of-three/
 * 
 * Given an integer array of digits, return the largest multiple of three that
 * can be formed by concatenating some of the given digits in any order.
 * 
 * Since the answer may not fit in an integer data type, return the answer as a
 * string.
 * 
 * If there is no answer return an empty string.
 * 
 */
public class LargestMultipleThree {

	public static String findMaxMultupleOf3(int digits[]) {
		Arrays.sort(digits);

		Deque<Integer> q0 = new LinkedList<>();
		Deque<Integer> q1 = new LinkedList<>();
		Deque<Integer> q2 = new LinkedList<>();

		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
			if ((digits[i] % 3) == 0) {
				q0.add(digits[i]);
			} else if ((digits[i] % 3) == 1) {
				q1.add(digits[i]);
			} else {
				q2.add(digits[i]);
			}
		}

		if ((sum % 3) == 1) {
			if (!q1.isEmpty()) {
				q1.remove();
			} else {
				if (q2.size() > 1) {
					q2.remove();
					q2.remove();
				} else if (q2.size() > 0) {
					q2.remove();
				} else {
					return "";
				}
			}
		} else if ((sum % 3) == 2) {
			if (!q2.isEmpty()) {
				q2.remove();
			} else {
				if (q1.size() > 1) {
					q1.remove();
					q1.remove();
				} else if (q1.size() > 0) {
					q1.remove();
				} else {
					return "";
				}
			}
		}

		List<Integer> lst = new ArrayList<>();

		lst.addAll(q0);
		lst.addAll(q1);
		lst.addAll(q2);

		Collections.sort(lst);

		if (!lst.isEmpty() && lst.get(lst.size() - 1) == 0) {
			return "0";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = lst.size() - 1; i >= 0; i--) {
			sb.append("" + lst.get(i));
		}

		return sb.toString();
	}

	public static void main(String[] arg) {

		int[] digits = { 8, 1, 7, 6, 0 };
		System.out.println(findMaxMultupleOf3(digits));

		int[] digits1 = { 8, 1, 9 };
		System.out.println(findMaxMultupleOf3(digits1));

		int[] digits2 = { 0, 0, 0 };
		System.out.println(findMaxMultupleOf3(digits2));

		int[] digits3 = { 1 };
		System.out.println(findMaxMultupleOf3(digits3));

	}

}
