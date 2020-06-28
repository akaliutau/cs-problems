package org.problems.misc;

import java.util.ArrayList;
import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/string-compression/
 * 
 * Given an array of characters, compress it in-place.
 * 
 * The length after compression must always be smaller than or equal to the
 * original array.
 * 
 * Every element of the array should be a character (not int) of length 1.
 * 
 * After you are done modifying the input array in-place, return the new length
 * of the array.
 * 
 * 
 * Follow up: Could you solve it using only O(1) extra space?
 * 
 * 
 * Example 1:
 * 
 * Input: ["a","a","b","b","c","c","c"]
 * 
 * Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 * 
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is
 * replaced by "c3".
 * 
 * 
 */
public class StringCompression {

	public static int compress(char[] chars) {
		int n = chars.length;
		if (n == 0) {
			return 0;
		}
		int size = 0;
		int idx = 1;
		char prev = chars[0];
		List<String> res = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (chars[i] == prev) {
				idx++;
			} else {
				res.add("" + prev);
				size++;
				int num = 0;
				if (idx > 1) {
					num = (int) Math.log10(idx) + 1;
				}
				size += num;
				res.add("" + idx);
				idx = 1;
				prev = chars[i];
			}
		}
		if (idx > 0) {
			res.add("" + prev);
			size++;
			int num = 0;
			if (idx > 1) {
				num = (int) Math.log10(idx) + 1;
			}
			size += num;
			res.add("" + idx);
		}

		int finalLen = Math.min(n, size);
		if (finalLen <= n) {
			char[] ans = new char[finalLen];
			idx = 0;
			for (int j = 0; j < res.size(); j += 2) {
				String s1 = res.get(j);
				ans[idx++] = (char) s1.charAt(0);
				String s2 = res.get(j + 1);
				int count = Integer.valueOf(s2);
				if (count > 1) {
					for (int k = 0; k < s2.length(); k++) {
						ans[idx++] = (char) s2.charAt(k);
					}
				}
			}
		     for (int i = 0; i < finalLen; i++){
		            chars[i] = ans[i];
		        }
		}
		return finalLen;

	}

	public static void main(String[] arg) {

		char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		System.out.println(compress(chars));

		char[] chars1 = { 'a', 'b', 'c' };
		System.out.println(compress(chars1));

		char[] chars2 = { 'a', 'a', 'b', 'a', 'b', 'c', 'c', 'c', 'a', 'c', 'c' };
		System.out.println(compress(chars2));

	}

}
