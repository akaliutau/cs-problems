package org.problems.minmax;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Your
 * algorithm's time complexity must be better than O(n log n), where n is the
 * array's size. It's guaranteed that the answer is unique, in other words the
 * set of the top k frequent elements is unique. You can return the answer in
 * any order.
 * 
 * Runtime: 7 ms, faster than 99.19% of Java online submissions for Top K Frequent Elements.
 * Memory Usage: 42.2 MB, less than 43.62% of Java online submissions for Top K Frequent Elements
 * 
 */
public class TopkElems {
	
	static class Elem {
		public int freq = 0;
		public int num;
		
		public Elem(int num) {
			this.num = num;
		}

	}

	public static int[] topKFrequent(int[] nums, int k) {
		int n = nums.length;
		Comparator<Elem> byFreq = (o,p) -> Integer.compare(p.freq, o.freq);
		PriorityQueue<Elem> queue = new PriorityQueue<>(n, byFreq);
		Map<Integer,Elem> map = new HashMap<>();
		for (int i : nums) {
			if (!map.containsKey(i)) {
				map.put(i, new Elem(i));
			}
			map.get(i).freq ++;
		}
		queue.addAll(map.values());
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll().num;
		}
		
		return res;

	}

	public static void main(String[] arg) {
		
		int[] nums = {1,1,1,2,2,3};

		Utils.print(topKFrequent(nums,2));

		int[] nums1 = {1};

		Utils.print(topKFrequent(nums1,1));

	}

}
