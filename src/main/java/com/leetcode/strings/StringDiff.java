package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class StringDiff {

	public static final int n = 12;

	public static Map<Integer, Integer> convert(String s) {
		Map<Integer, Integer> chars1 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			if (!chars1.containsKey(ch)) {
				chars1.put(ch, 0);
			}
			chars1.put(ch, chars1.get(ch) + 1);
		}
		return chars1;
	}

	public static int minSteps(String s, String t) {
		Map<Integer, Integer> chars1 = convert(s);
		Map<Integer, Integer> chars2 = convert(t);

		int steps = 0;
		for (Integer i : chars1.keySet()) {
			if (chars2.containsKey(i)) {
				steps += Math.abs(chars1.get(i) - chars2.get(i));
			} else {
				steps += Math.abs(chars1.get(i));
			}
		}
		for (Integer i : chars2.keySet()) {
			if (!chars1.containsKey(i)) {
				steps += Math.abs(chars2.get(i));
			}
		}

		return steps;

	}

	public static void main(String[] arg) {

		int res = minSteps("bab", "aba");

		System.out.println(res);
	}

}
