package org.problems.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * 
 * Given an array of integers arr and an integer k. Find the least number of
 * unique integers after removing exactly k elements.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [5,5,4], k = 1 Output: 1 Explanation: Remove the single 4, only
 * 5 is left.
 * 
 */
public class UniqueIntegersAfterKremovals {

	static class Holder {
		public int counter = 0;
		public int num;

		public Holder(int num) {
			this.num = num;
		}

		@Override
		public String toString() {
			return "Holder [counter=" + counter + ", num=" + num + "]";
		}
	}

	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Holder> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new Holder(arr[i]));
			}
			map.get(arr[i]).counter++;
		}
		List<Holder> all = new ArrayList<>(map.values());
		Comparator<Holder> byCount = (o, p) -> Integer.compare(o.counter, p.counter);
		Collections.sort(all, byCount);
		int least = 0;
		System.out.println(all);
		for (int i = 0; i < all.size(); i++) {
			k -= all.get(i).counter;
			if (k < 0) {
				least = all.size() - i;
				break;
			}
		}
		return least;
	}

	public static void main(String[] arg) {

		int[] arr = { 5, 5, 4 };

		System.out.println(findLeastNumOfUniqueInts(arr, 1));

		int[] arr1 = { 4, 3, 1, 1, 3, 3, 2 };

		System.out.println(findLeastNumOfUniqueInts(arr1, 3));

	}

}
