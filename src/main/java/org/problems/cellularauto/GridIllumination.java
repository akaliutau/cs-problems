package org.problems.cellularauto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/grid-illumination/
 * 
 * On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has
 * a lamp.
 * 
 * Initially, some number of lamps are on. lamps[i] tells us the location of the
 * i-th lamp that is on. Each lamp that is on illuminates every square on its
 * x-axis, y-axis, and both diagonals (similar to a Queen in chess).
 * 
 * For the i-th query queries[i] = (x, y), the answer to the query is 1 if the
 * cell (x, y) is illuminated, else 0.
 * 
 * After each query (x, y) [in the order given by queries], we turn off any
 * lamps that are at cell (x, y) or are adjacent 8-directionally (ie., share a
 * corner or edge with cell (x, y).)
 * 
 * Return an array of answers. Each value answer[i] should be equal to the
 * answer of the i-th query queries[i].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]] Output: [1,0]
 * Explanation: Before performing the first query we have both lamps [0,0] and
 * [4,4] on. The grid representing which cells are lit looks like this, where
 * [0,0] is the top left corner, and [4,4] is the bottom right corner:
 *  1 1 1 1 1
 *  1 1 0 0 1 
 *  1 0 1 0 1 
 *  1 0 0 1 1 
 *  1 1 1 1 1 
 *  
 *  Then the query at [1, 1] returns 1
 * because the cell is lit. After this query, the lamp at [0, 0] turns off, and
 * the grid now looks like this: 
 *  1 0 0 0 1 
 *  0 1 0 0 1 
 *  0 0 1 0 1 
 *  0 0 0 1 1 
 *  1 1 1 1 1 
 *  Before performing the second query we have only the lamp [4,4] on. Now the
 * query at [1,0] returns 0, because the cell is no longer lit.
 * 
 * 
 * Note:
 * 
 * 1 <= N <= 10^9 
 * 0 <= lamps.length <= 20000 
 * 0 <= queries.length <= 20000
 * lamps[i].length == queries[i].length == 2
 * 
 */
public class GridIllumination {
	
	static class Lamp {
		
		public final long id;
		
		public boolean on = true;

		public int[] pos;

		public Lamp(int[] pos) {
			this.pos = pos;
			this.id = (long) 1000000000 * pos[0]  + pos[1];
		}
		
		public boolean lit(int x, int y) {
			return x == pos[0] || y == pos[1] || Math.abs(x - pos[0]) == Math.abs(y - pos[1]);
		}
		
		public int dist(Lamp lamp) {
			return Math.abs(pos[0] - lamp.pos[0]) + Math.abs(pos[1] - lamp.pos[1]);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
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
			Lamp other = (Lamp) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Lamp [id=" + id + ", pos=" + Arrays.toString(pos) + "]";
		}
		

	}
	
	static int[] directions = { -1,0, 1,0, 0,-1, 0,1, -1,-1, 1,1, 1,-1, -1,1  };

	static boolean isValid(int x, int y, int rows, int cols) {
		if (x < 0 || x > rows - 1 || y < 0 || y > cols - 1) {
			return false;
		}
		return true;
	}
	


	public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		
		Set<Lamp> lmps = new HashSet<>();
		for (int[] lp : lamps) {
			lmps.add(new Lamp(lp));
		}

		Map<Long,List<Lamp>> map = new HashMap<>();
		Map<Integer,List<Lamp>> xLine = new HashMap<>();
		Map<Integer,List<Lamp>> yLine = new HashMap<>();
		Map<Integer,List<Lamp>> diagLine1 = new HashMap<>();
		Map<Integer,List<Lamp>> diagLine2 = new HashMap<>();
		for (Lamp cur : lmps) {
			// vert, hor
			if (!xLine.containsKey(cur.pos[0])) {
				xLine.put(cur.pos[0], new ArrayList<>());
			}
			xLine.get(cur.pos[0]).add(cur);
			if (!yLine.containsKey(cur.pos[1])) {
				yLine.put(cur.pos[1], new ArrayList<>());
			}
			yLine.get(cur.pos[1]).add(cur);
			// diagonals
			int diag1 = cur.pos[0] + cur.pos[1];
			int diag2 = cur.pos[0] - cur.pos[1];
			if (!diagLine1.containsKey(diag1)) {
				diagLine1.put(diag1, new ArrayList<>());
			}
			diagLine1.get(diag1).add(cur);
			if (!diagLine2.containsKey(diag2)) {
				diagLine2.put(diag2, new ArrayList<>());
			}
			diagLine2.get(diag2).add(cur);
			
		}		
		
		for (Lamp cur : lmps) {

			map.put(cur.id, new ArrayList<>());
			map.get(cur.id).add(cur);
			for (int j = 0; j < 16; j+=2) {
				int x = cur.pos[0] + directions[j];
				int y = cur.pos[1] + directions[j + 1];
				long id = (long) 1000000000 * x + y;
				if (!map.containsKey(id)) {
					map.put(id, new ArrayList<>());
				}
				map.get(id).add(cur);
			}
		}
		int[] res = new int[queries.length];
		int idx = 0;
		for (int[] q : queries) {
			long id = (long) 1000000000 * q[0]  + q[1];
			int isLit = 0;
			
			if ((xLine.containsKey(q[0]) && !xLine.get(q[0]).isEmpty()) || (yLine.containsKey(q[1]) && !yLine.get(q[1]).isEmpty())) {
				isLit = 1;
			}else {
				int diag1 = q[0] + q[1];
				int diag2 = q[0] - q[1];
				if ((diagLine1.containsKey(diag1) && !diagLine1.get(diag1).isEmpty()) || (diagLine2.containsKey(diag2) && !diagLine2.get(diag2).isEmpty())) {
					isLit = 1;
				}
			}
			
			res[idx++] = isLit;
			if (map.containsKey(id)) {
				List<Lamp> lst = map.get(id);
				for (Lamp l : lst) {
					xLine.get(l.pos[0]).remove(l);
					yLine.get(l.pos[1]).remove(l);
					int diag1 = l.pos[0] + l.pos[1];
					int diag2 = l.pos[0] - l.pos[1];
					diagLine1.get(diag1).remove(l);
					diagLine2.get(diag2).remove(l);
				}
			}
		}
		
		return res;

	}

	public static void main(String[] arg) {
		
		int[][] lamps = {
				{0, 0},
				{4, 4}
		};
		
		int[][] queries = {
				{1, 1},
				{1, 0}
		};

		Utils.print(gridIllumination(5, lamps, queries));

	}

}
