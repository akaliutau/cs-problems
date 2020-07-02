package org.problems.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 * 
 * Given a binary string s and an integer k.
 * 
 * Return True if any binary code of length k is a substring of s. Otherwise,
 * return False
 * 
 */
public class BinaryCodesOfSizek {

	public static boolean hasAllCodes(String s, int k) {
		int n = s.length();
		if (n < k) {
			return false;
		}
		Set<Integer> all = new HashSet<>();
		int total = (int) Math.pow(2, k);
		int mask = total - 1;
		int num = 0;
		for (int i = 0; i < k; i++) {
			char c = s.charAt(i);
			if (c == '1') {
				num += 1;
			}
			num = num << 1;
		}
		num = num >> 1;
		num = num & mask;
		all.add(num);
		num = num << 1;
		for (int i = k; i < n; i++) {
			char c = s.charAt(i);
			if (c == '1') {
				num += 1;
			}
			num = num & mask;
			all.add(num);
			num = num << 1;
		}
		System.out.println(all);
		return all.size() == total;
	}

	public static void main(String[] arg) {

		System.out.println(hasAllCodes("00110110", 2));
		System.out.println(hasAllCodes("00110", 2));
		System.out.println(hasAllCodes("0110", 1));
		System.out.println(hasAllCodes("0110", 2));
		System.out.println(hasAllCodes("0000000001011100", 4));
		System.out.println(hasAllCodes("0000", 1));
		System.out.println(hasAllCodes("0", 1));
		System.out.println(hasAllCodes("01100", 2));

	}

}
