package org.problems.iterations;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 * 
 * Your country has an infinite number of lakes. Initially, all the lakes are
 * empty, but when it rains over the nth lake, the nth lake becomes full of
 * water. If it rains over a lake which is full of water, there will be a flood.
 * Your goal is to avoid the flood in any lake.
 * 
 * Given an integer array rains where:
 * 
 * rains[i] > 0 means there will be rains over the rains[i] lake. rains[i] == 0
 * means there are no rains this day and you can choose one lake this day and
 * dry it. Return an array ans where:
 * 
 * ans.length == rains.length ans[i] == -1 if rains[i] > 0. ans[i] is the lake
 * you choose to dry in the ith day if rains[i] == 0. If there are multiple
 * valid answers return any of them. If it is impossible to avoid flood return
 * an empty array.
 * 
 * Notice that if you chose to dry a full lake, it becomes empty, but if you
 * chose to dry an empty lake, nothing changes. (see example 4)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: rains = [1,2,3,4] Output: [-1,-1,-1,-1] 
 * 
 * Explanation: After the first
 * day full lakes are [1] After the second day full lakes are [1,2] After the
 * third day full lakes are [1,2,3] After the fourth day full lakes are
 * [1,2,3,4] There's no day to dry any lake and there is no flood in any lake.
 * 
 * 
 * Example 2:
 * 
 * Input: rains = [1,2,0,0,2,1] Output: [-1,-1,2,1,-1,-1] 
 * 
 * Explanation: After the
 * first day full lakes are [1] After the second day full lakes are [1,2] After
 * the third day, we dry lake 2. Full lakes are [1] After the fourth day, we dry
 * lake 1. There is no full lakes. After the fifth day, full lakes are [2].
 * After the sixth day, full lakes are [1,2]. It is easy that this scenario is
 * flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
 * 
 * 
 * 
 */
public class AvoidFlood {

	static class Res {
		public Stack<Integer> days = new Stack<>();

		public Res() {
		}

		public void add(int day) {
			days.add(day);
		}

		public boolean isEmpty() {
			return days.isEmpty();
		}

		public int getDay(int from) {
			for (int i = 0; i < days.size(); i++) {
				if (days.get(i) > from) {
					return days.remove(i);
				}
			}
			return -1;
		}

	}

	public static int[] avoidFlood(int[] rains) {
		int n = rains.length;
		int[] ans = new int[n];
		Map<Integer, Integer> full = new HashMap<>();
		// map lake = reserved stat
		Res rsv = new Res();
		for (int i = 0; i < n; i++) {
			if (rains[i] > 0) {
				if (!full.containsKey(rains[i])) {
					ans[i] = -1;
					full.put(rains[i], i);// lake => day
				} else if (!rsv.isEmpty()) {
					int day = full.remove(rains[i]);
					int reserved = rsv.getDay(day);
					if (reserved == -1) {
						return new int[0];
					}
					ans[reserved] = rains[i];
					ans[i] = -1;
					full.put(rains[i], i);
				} else {
					return new int[0];
				}
			} else {
				rsv.add(i);
				ans[i] = 1;
			}
		}

		return ans;

	}

	public static void main(String[] arg) {
		
		int[] rains = {1,2,0,0,2,1};

		Utils.print(avoidFlood(rains));

	}

}
