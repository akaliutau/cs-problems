package org.problems.favourite;

import java.util.PriorityQueue;

/**
 * Maximal Minimum Value Path II
 * 
 * Given a two 2D integer array, find the max score of a path from the upper
 * left cell to bottom right cell that doesn't visit any of the cells twice. The
 * score of a path is the minimum value in that path.
 * 
 * For example:
 * 
 * Input:
 * 
 * [7,5,3] [2,0,9] [4,5,9]
 * 
 * Here are some paths from [0,0] to [2,2] and the minimum value on each path:
 * 
 * path: 7->2->4->5->9, minimum value on this path: 2 path: 7->2->0->9->9,
 * minimum value on this path: 0 path: 7->2->0->5->9, minimum value on this
 * path: 0
 * 
 * Notice: the path can move in all four directions.
 * 
 * Here 7->2->0->5->3->9->9 is also a path, and the minimum value on this path
 * is 0.
 * 
 * The path doesn't visit the same cell twice. So 7->2->0->5->3->9->0->5->9 is
 * not a path.
 * 
 * In the end the max score(the min value) of all the paths is 3.
 * 
 * Output: 3
 */
public class MaxMinPathII {
	
	static class Cell {
		int cur, next;
		int r;
		int c;

		public Cell(int cur, int next, int r, int c) {
			this.cur = cur;
			this.next = next;
			this.r = r;
			this.c = c;
		}
	}

	public static int maxMin(int[][] data) {
		int n = data.length;
		int m = 0;
		if (n > 0) {
			m = data[0].length;
		}
		PriorityQueue<Cell> queue = new PriorityQueue<>((o, p) -> Integer.compare(p.cur, o.cur));
		queue.add(new Cell( data[0][0], data[0][0], 0, 0));
		int[] dr = new int[] { 1, 0, -1, 0 };
		int[] dc = new int[] { 0, -1, 0, 1 };
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Cell cur = queue.poll();
			if (cur.c == m - 1 && cur.r == n - 1) {
				return cur.next;
			}

			for (int i = 0; i < 4; i++) {
				int r = cur.r + dr[i];
				int c = cur.c + dc[i];
				if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
					queue.add(new Cell( data[r][c], Math.min(data[r][c], cur.next), r, c ));
					visited[r][c] = true;
				}
			}
		}
		return -1;
	}

	public static void main(String[] arg) {

		int[][] data = { { 7, 5, 3 }, { 2, 0, 9 }, { 4, 5, 9 } };
		System.out.println(maxMin(data));

	
		int[][] data1 = { 
				{ 7, 3, 3, 4}, 
				{ 6, 8, 9, 7 }, 
				{ 6, 6, 4, 8 },
				{ 4, 5, 9, 6 } 
				};
		System.out.println(maxMin(data1));
}

}
