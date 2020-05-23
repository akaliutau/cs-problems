package org.problems.iterations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/keys-and-rooms/ Runtime: 1 ms, faster than
 * 91.80% of Java online submissions for Keys and Rooms. Memory Usage: 43.3 MB,
 * less than 58.62% of Java online submissions for Keys and Rooms.
 */
public class KeysAndRooms {

	static class Solution {
		public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
			int nRooms = rooms.size();
			boolean[] visited = new boolean[nRooms];
			int nVisited = 1;

			Queue<Integer> queue = new LinkedList<>();
			queue.add(0);
			visited[0] = true;

			while (!queue.isEmpty()) {
				int room = queue.poll();
				for (Integer r : rooms.get(room)) {
					if (!visited[r]) {
						visited[r] = true;
						nVisited++;
						queue.add(r);
					}
				}
			}
			return nVisited == nRooms;
		}

	}

	public static void main(String[] arg) {
		// 0 1 2 3
		// [[1], [2], [3], []]
		List<List<Integer>> list = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList());
		System.out.println(list);
		System.out.println(Solution.canVisitAllRooms(list));

		// 0 1 2 3
		// [[1, 3], [3, 0, 1], [2], [1]]
		List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 1, 1), Arrays.asList(2),
				Arrays.asList(1));
		System.out.println(list1);
		System.out.println(Solution.canVisitAllRooms(list1));

		// 0 1 2 3 4 5 6 7 8 9
		// [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
		List<List<Integer>> list2 = Arrays.asList(Arrays.asList(4), Arrays.asList(3), Arrays.asList(),
				Arrays.asList(2, 5, 7), Arrays.asList(1), Arrays.asList(), Arrays.asList(8, 9), Arrays.asList(),
				Arrays.asList(), Arrays.asList(6));
		System.out.println(list2);
		System.out.println(Solution.canVisitAllRooms(list2));

	}
}
