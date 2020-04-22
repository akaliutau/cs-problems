package com.leetcode.matricies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * 
 * You are asked to cut off trees in a forest for a golf event. The forest is
 * represented as a non-negative 2D map, in this map:
 * 
 * 0 represents the obstacle can't be reached. 1 represents the ground can be
 * walked through. The place with number bigger than 1 represents a tree can be
 * walked through, and this positive number represents the tree's height. In one
 * step you can walk in any of the four directions top, bottom, left and right
 * also when standing in a point which is a tree you can decide whether or not
 * to cut off the tree.
 * 
 * You are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after cutting,
 * the original place has the tree will become a grass (value 1).
 * 
 * You will start from the point (0, 0) and you should output the minimum steps
 * you need to walk to cut off all the trees. If you can't cut off all the
 * trees, output -1 in that situation.
 * 
 * You are guaranteed that no two trees have the same height and there is at
 * least one tree needs to be cut off.
 * 
 * Example 1: Input: [ [1,2,3], [0,0,4], [7,6,5] ] Output: 6
 * 
 * 
 * Example 2: Input: [ [1,2,3], [0,0,0], [7,6,5] ] Output: -1
 * 
 * 
 * Example 3: Input: [ [2,3,4], [0,0,5], [8,7,6] ] Output: 6 Explanation: You
 * started from the point (0,0) and you can cut off the tree in (0,0) directly
 * without walking.
 * 
 * 
 * Constraints:
 * 
 * 1 <= forest.length <= 50 
 * 1 <= forest[i].length <= 50 
 * 0 <= forest[i][j] <= 10^9
 * 
 * Runtime: 223 ms, faster than 91.84% of Java online submissions for Cut Off Trees for Golf Event.
 * Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Cut Off Trees for Golf Event.
 * 
 */
public class CutOffTrees {

	static class Path {
		public final int id;
		public Cell from;
		public Cell to;
		public int steps;// optimal way

		public Path(Cell from, Cell to) {
			this.from = from;
			this.to = to;
			this.steps = Integer.MAX_VALUE;
			this.id = calcPathId(from.id, to.id);
		}

		public void updateSteps() {
			if (from.visited && to.visited) {
				if (steps == Integer.MAX_VALUE) {
					steps = Math.abs(from.steps - to.steps);// not working if obstacles
				}
			}
		}

		@Override
		public String toString() {
			return "Path [id=" + id + ", from=" + from + ", to=" + to + ", steps=" + steps + "]";
		}

	}

	static int calcPathId(int c1, int c2) {
		return c1 > c2 ? c2 * 10000 + c1 : c1 * 10000 + c2;
	}

	static class Cell {
		public final int id;
		public int i;
		public int j;
		public int treeHeight;
		public boolean visited = false;
		public int steps;
		public Cell origin;

		public Cell(int i, int j, int treeHeight) {
			this.treeHeight = treeHeight;
			this.i = i;
			this.j = j;
			this.id = i * 100 + j;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Cell [id=" + id + ", i=" + i + ", j=" + j + ", treeHeight=" + treeHeight + ", visited=" + visited
					+ ", steps=" + steps + "]";
		}

	}

	static int[] directions = { -1, 0, 1, 0, 0, -1, 0, 1 };

	/**
	 * Calculates number of steps needed to walk from Cell=from to Cell=to During
	 * traversal checks non-processed paths from-to, and update/use them when it is
	 * possible
	 * 
	 * @param from
	 * @param to
	 * @return number of paths or -1 if impossible
	 */
	static int countSteps(Cell from, Cell to, Cell[][] field, int m, int n, Map<Integer, Path> toDoPaths) {
		Queue<Cell> queue = new LinkedList<>();
		queue.add(from);
		from.steps = 0;
		while (!queue.isEmpty()) {
			Cell c = queue.poll();
			c.visited = true;
			if (c == to) {
				break;
			}
			for (int i = 0; i < 8; i += 2) {
				int nexti = c.i + directions[i];
				int nextj = c.j + directions[i + 1];
				if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n) {
					Cell nextCell = field[nexti][nextj];
					if (!nextCell.visited && nextCell.treeHeight > 0) {
						nextCell.steps = Math.min(nextCell.steps, c.steps + 1);
						nextCell.origin = c;
						nextCell.visited = true;
						queue.add(nextCell);
					}
				}
			}
		}
		return to.visited ? to.steps : -1;
	}

	static void reset(Cell[][] field, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				field[i][j].steps = Integer.MAX_VALUE;
				field[i][j].visited = false;
				field[i][j].origin = null;
			}
		}
	}

	public static int cutOffTree(List<List<Integer>> forest) {

		int m = forest.size();
		int n = 0;
		if (m > 0) {
			n = forest.get(0).size();
		}

		Cell[][] field = new Cell[m][n];
		int r = 0;
		for (List<Integer> line : forest) {
			for (int i = 0; i < line.size(); i++) {
				field[r][i] = new Cell(r, i, line.get(i));
			}
			r++;
		}
		reset(field, m, n);
		// compose an ordered list of Cells to walk though
		List<Cell> trees = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Cell c = field[i][j];
				if (c.treeHeight > 1) {
					trees.add(c);
				}
			}
		}
		Comparator<Cell> byHeight = (o, p) -> Integer.compare(o.treeHeight, p.treeHeight);
		trees.sort(byHeight);

		Cell start = field[0][0];
		// all paths processed during BFS stage
		Map<Integer, Path> toDoPaths = new HashMap<>();
		for (Cell tree : trees) {
			Path p = new Path(start, tree);
			toDoPaths.put(p.id, p);
			start = tree;
		}

		start = field[0][0];
		int totalSteps = 0;
		// during path finding try maximally re-use already done paths
		for (Cell next : trees) {
			// try to find next using backtracking
			Cell initial = start;
			boolean found = false;
			System.out.println(start+"->"+next+"  :"+1);
			while (initial.origin != null) {
				initial = initial.origin;
				if (initial == next) {
//					System.out.println("initial.steps"+initial.steps);
					totalSteps += Math.abs(next.steps - start.steps);
					start = next;
					found = true;
					break;
				}
			}
			if (found) {
				continue;
			}

			reset(field, m, n);
			int curSteps = countSteps(start, next, field, m, n, toDoPaths);
			if (!next.visited) {
				return -1;
			}
			if (curSteps < 0) {
				return -1;
			}
			totalSteps += curSteps;
			start = next;
		}

		return totalSteps;

	}

	public static void main(String[] arg) {

		List<Integer> line1 = Arrays.asList(1, 2, 3);
		List<Integer> line2 = Arrays.asList(0, 0, 4);
		List<Integer> line3 = Arrays.asList(7, 6, 5);
		List<List<Integer>> forest = Arrays.asList(line1, line2, line3);
		System.out.println(cutOffTree(forest));

		List<Integer> line1a = Arrays.asList(1, 2, 3);
		List<Integer> line2a = Arrays.asList(0, 0, 0);
		List<Integer> line3a = Arrays.asList(7, 6, 5);
		List<List<Integer>> foresta = Arrays.asList(line1a, line2a, line3a);
		System.out.println(cutOffTree(foresta));

		List<Integer> line1b = Arrays.asList(1, 2, 3);
		List<Integer> line2b = Arrays.asList(0, 0, 4);
		List<Integer> line3b = Arrays.asList(7, 5, 6);
		List<List<Integer>> forestb = Arrays.asList(line1b, line2b, line3b);
		System.out.println(cutOffTree(forestb));

		List<Integer> line1c = Arrays.asList(0);
		List<Integer> line2c = Arrays.asList(0);
		List<Integer> line3c = Arrays.asList(621);
		List<List<Integer>> forestc = Arrays.asList(line1c, line2c, line3c);
		System.out.println(cutOffTree(forestc));

		List<Integer> line1d = Arrays.asList(1, 2, 3, 4);
		List<Integer> line2d = Arrays.asList(5, 0, 6, 7);
		List<Integer> line3d = Arrays.asList(9, 0, 0, 8);
		List<Integer> line4d = Arrays.asList(10, 11, 13, 12);
		List<List<Integer>> forestd = Arrays.asList(line1d, line2d, line3d, line4d);
		System.out.println(cutOffTree(forestd));

		List<List<Integer>> foreste = Arrays.asList(Arrays.asList(69438, 55243, 0, 43779, 5241, 93591, 73380),
				Arrays.asList(847, 49990, 53242, 21837, 89404, 63929, 48214),
				Arrays.asList(90332, 49751, 0, 3088, 16374, 70121, 25385),
				Arrays.asList(14694, 4338, 87873, 86281, 5204, 84169, 5024),
				Arrays.asList(31711, 47313, 1885, 28332, 11646, 42583, 31460),
				Arrays.asList(59845, 94855, 29286, 53221, 9803, 41305, 60749),
				Arrays.asList(95077, 50343, 27947, 92852, 0, 0, 19731),
				Arrays.asList(86158, 63553, 56822, 90251, 0, 23826, 17478),
				Arrays.asList(60387, 23279, 78048, 78835, 5310, 99720, 0),
				Arrays.asList(74799, 48845, 60658, 29773, 96129, 90443, 14391),
				Arrays.asList(65448, 63358, 78089, 93914, 7931, 68804, 72633),
				Arrays.asList(93431, 90868, 55280, 30860, 59354, 62083, 47669),
				Arrays.asList(81064, 93220, 22386, 22341, 95485, 20696, 13436),
				Arrays.asList(50083, 0, 89399, 43882, 0, 13593, 27847),
				Arrays.asList(0, 12256, 33652, 69301, 73395, 93440, 0),
				Arrays.asList(42818, 87197, 81249, 33936, 7027, 5744, 64710),
				Arrays.asList(35843, 0, 99746, 52442, 17494, 49407, 63016),
				Arrays.asList(86042, 44524, 0, 0, 26787, 97651, 28572),
				Arrays.asList(54183, 83466, 96754, 89861, 84143, 13413, 72921),
				Arrays.asList(89405, 52305, 39907, 27366, 14603, 0, 14104),
				Arrays.asList(70909, 61104, 70236, 30365, 0, 30944, 98378),
				Arrays.asList(20124, 87188, 6515, 98319, 78146, 99325, 88919),
				Arrays.asList(89669, 0, 64218, 85795, 2449, 48939, 12869),
				Arrays.asList(93539, 28909, 90973, 77642, 0, 72170, 98359),
				Arrays.asList(88628, 16422, 80512, 0, 38651, 50854, 55768),
				Arrays.asList(13639, 2889, 74835, 80416, 26051, 78859, 25721),
				Arrays.asList(90182, 23154, 16586, 0, 27459, 3272, 84893),
				Arrays.asList(2480, 33654, 87321, 93272, 93079, 0, 38394),
				Arrays.asList(34676, 72427, 95024, 12240, 72012, 0, 57763),
				Arrays.asList(97957, 56, 83817, 45472, 0, 24087, 90245),
				Arrays.asList(32056, 0, 92049, 21380, 4980, 38458, 3490),
				Arrays.asList(21509, 76628, 0, 90430, 10113, 76264, 45840),
				Arrays.asList(97192, 58807, 74165, 65921, 45726, 47265, 56084),
				Arrays.asList(16276, 27751, 37985, 47944, 54895, 80706, 2372),
				Arrays.asList(28438, 53073, 0, 67255, 38416, 63354, 69262),
				Arrays.asList(23926, 75497, 91347, 58436, 73946, 39565, 10841),
				Arrays.asList(34372, 69647, 44093, 62680, 32424, 69858, 68719),
				Arrays.asList(24425, 4014, 94871, 1031, 99852, 88692, 31503),
				Arrays.asList(24475, 12295, 33326, 37771, 37883, 74568, 25163),
				Arrays.asList(0, 18411, 88185, 60924, 29028, 69789, 0),
				Arrays.asList(34697, 75631, 7636, 16190, 60178, 39082, 7052),
				Arrays.asList(24876, 9570, 53630, 98605, 22331, 79320, 88317),
				Arrays.asList(27204, 89103, 15221, 91346, 35428, 94251, 62745),
				Arrays.asList(26636, 28759, 12998, 58412, 38113, 14678, 0),
				Arrays.asList(80871, 79706, 45325, 3861, 12504, 0, 4872),
				Arrays.asList(79662, 15626, 995, 80546, 64775, 0, 68820),
				Arrays.asList(25160, 82123, 81706, 21494, 92958, 33594, 5243));
		
		System.out.println(cutOffTree(foreste));


	}

}
