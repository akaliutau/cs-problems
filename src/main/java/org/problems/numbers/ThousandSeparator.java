package org.problems.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/thousand-separator/
 * 
 * Given an integer n, add a dot (".") as the thousands separator and return it
 * in string format.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 987 Output: "987" Example 2:
 * 
 * Input: n = 1234 Output: "1.234"
 * 
 * 
 */
public class ThousandSeparator {

	public String thousandSeparator(int n) {
		List<String> lst = new ArrayList<>();
		if (n == 0) {
			return "0";
		}
		while (n > 0) {
			int part = n % 1000;
			n -= part;
			n /= 1000;
			if (n == 0) {
				lst.add("" + part);
			} else if (part < 10) {
				lst.add("00" + part);
			} else if (part < 100) {
				lst.add("0" + part);
			} else {
				lst.add("" + part);
			}
		}
		String[] p = new String[lst.size()];
		int idx = 0;
		for (int i = lst.size() - 1; i > -1; i--) {
			p[idx++] = lst.get(i);
		}
		return String.join(".", p);
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
