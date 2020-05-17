package com.leetcode.minmax;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * Example 1: Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"] 
 * 
 * Explanation: The only restaurant they both like is
 * "Shogun". 
 * 
 * Example 2: Input: 
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"] 
 * ["KFC", "Shogun", "Burger King"] 
 * Output: ["Shogun"] 
 * 
 * Explanation: The
 * restaurant they both like and have the least index sum is "Shogun" with index
 * sum 1 (0+1). 
 * Note: The length of both lists will be in the range of [1, 1000]. 
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1. No duplicates in
 * both lists.
 * 
 */
public class MinimumIndexSumOfLists {
	
	static class Restaurant {
		public int index;
		public String name;
		
		public Restaurant(String name, int index) {
			this.name = name;
			this.index = index;
		}
		
	}

	public static String[] findRestaurant(String[] list1, String[] list2) {
		
		Map<String, Integer> map = new HashMap<>();
		int idx = 0;
		for (String s : list2) {
			map.put(s, idx++);
		}
		List<Restaurant> shared = new ArrayList<>();
		idx = 0;
		for (String s : list1) {
			if (map.containsKey(s)) {
				shared.add(new Restaurant(s, idx + map.get(s)));
			}
			idx++;
		}
		Comparator<Restaurant> byIndex = (o,p) -> Integer.compare(o.index, p.index);
		shared.sort(byIndex);
		int index = shared.get(0).index;
		
		List<String> res = new ArrayList<>();
		for (Restaurant r : shared) {
			if (r.index == index) {
				res.add(r.name);
			}else {
				break;
			}
		}
		
		return res.toArray(new String[res.size()]);
        
    }

	public static void main(String[] arg) {

		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		Utils.print(findRestaurant(list1, list2));

		
		String[] list1a = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2a = {"KFC", "Shogun", "Burger King"};
		Utils.print(findRestaurant(list1a, list2a));

		String[] list1b = {"Shogun"};
		String[] list2b = {"Shogun"};
		Utils.print(findRestaurant(list1b, list2b));

	}

}
