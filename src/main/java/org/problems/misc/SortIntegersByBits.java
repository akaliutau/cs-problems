package org.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 * Runtime: 14 ms, faster than 33.33% of Java online submissions for Sort
 * Integers by The Number of 1 Bits. Memory Usage: 41.7 MB, less than 100.00% of
 * Java online submissions for Sort Integers by The Number of 1 Bits
 */
public class SortIntegersByBits {

	public int[] sortByBits(int[] arr) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			String str = Integer.toBinaryString(arr[i]);
			int count = str.length() - str.replace("1", "").length();
			if (!map.containsKey(count)) {
				map.put(count, new ArrayList<>());
			}
			map.get(count).add(arr[i]);
		}
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		List<Integer> res = new ArrayList<>();
		for (Integer i : keys) {
			List<Integer> nums = map.get(i);
			Collections.sort(nums);
			res.addAll(nums);
		}
		int[] fin = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			fin[i] = res.get(i);
		}
		return fin;
	}

	public static void main(String[] arg) {

		int res = 0;
		System.out.println(res);

	}

}
