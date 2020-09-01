package org.problems.favourite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Island I
 * 
 * You have a map that marks the location of a treasure map. Some of the map
 * area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
 * There are other explorers trying to find the treasure. So you must figure out
 * a shortest route to the treasure map. Assume the map area is a two
 * dimensional grid, represented by a matrix of characters. You must start from
 * the top-left corner of the map and can move one block up, down, left or right
 * at a time. The treasure map is marked as 'X' in a block of the matrix. 'X'
 * will not be at the top-left corner. Any block with dangerous rocks or reefs
 * will be marked as 'D'. You must not enter dangerous blocks. You cannot leave
 * the map area. Other areas 'O' are safe to sail in. The top-left corner is
 * always safe. Output the minimum number of steps to get to the treasure.
 *
 * Example Input 
 * [ 
 * ['O', 'O', 'O', 'O'], 
 * ['D', 'O', 'D', 'O'], 
 * ['O', 'O', 'O', 'O'], 
 * ['X', 'D', 'D', 'O'], ]
 * 
 * Output Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum
 * route takes 5 steps.
 * 
 * 
 */
public class IslandI {

	static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int treasureIsland(char[][] map) {
		
		int n = map.length;
		int m = 0;
		if (n > 0) {
			m = map[0].length;
		}

		if (map == null || n == 0) {
			return 0;
		}

		int steps = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		// bfs
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] coordinate = queue.poll();
				int x = coordinate[0];
				int y = coordinate[1];
				if (map[x][y] == 'X')
					return steps;

				for (int[] dir : dirs) {
					int newX = x + dir[0];
					int newY = y + dir[1];

					if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] != 'D' && !visited[newX][newY]) {
						queue.add(new int[] {newX, newY});
						visited[newX][newY] = true;
					}
				}
			}
			steps++;
		}

		return 0;
	}

	public static void main(String[] arg) {
		
		char[][] map = {
				{'O', 'O', 'O', 'O'}, 
				{'D', 'O', 'D', 'O'},
				{'O', 'O', 'O', 'O'}, 
				{'X', 'D', 'D', 'O'}
		};
		System.out.println(treasureIsland(map));
	}

}
