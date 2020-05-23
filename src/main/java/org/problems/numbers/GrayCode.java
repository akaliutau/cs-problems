package org.problems.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 * 
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * Example 1:
 * 
 * Input: 2 Output: [0,1,3,2] Explanation:
 * 
 * Generate a new bundle of codes consisting from 2 groups: 
 * 00 - 0 
 * 01 - 1 
 * 11 - 3
 * 10 - 2
 * 
 * 
 * 
 * 
 */
public class GrayCode {

	public static List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		if (n < 0) {
			return res;
		}

		if (n == 0) {
			return Arrays.asList(0);
		}
		List<String> codes = new ArrayList<>();
		codes.add("0");
		codes.add("1");

		while (n-- > 1) {
			List<String> newGroup1 = new ArrayList<>();
			List<String> newGroup2 = new ArrayList<>();

			for (String s : codes) {
				newGroup1.add("0" + s);
				newGroup2.add("1" + s);
			}
			codes.clear();
			codes.addAll(newGroup1);
			for (int i = newGroup2.size() - 1; i > -1; i--) {
				codes.add(newGroup2.get(i));
			}
		}

		for (String s : codes) {
			res.add(Integer.parseInt(s, 2));
		}

		return res;

	}

	public static void main(String[] arg) {

		System.out.println(grayCode(0));
		System.out.println(grayCode(1));
		System.out.println(grayCode(2));
		System.out.println(grayCode(3));

	}
}
