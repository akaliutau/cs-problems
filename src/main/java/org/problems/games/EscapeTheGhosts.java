package org.problems.games;

/**
 * https://leetcode.com/problems/escape-the-ghosts/
 * 
 * You are playing a simplified Pacman game. You start at the point (0, 0), and
 * your destination is (target[0], target[1]). There are several ghosts on the
 * nodes, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).
 * 
 * Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal
 * directions: north, east, west, or south, going from the previous point to a
 * new point 1 unit of distance away.
 * 
 * You escape if and only if you can reach the target before any ghost reaches
 * you (for any given moves the ghosts may take.) If you reach any square
 * (including the target) at the same time as a ghost, it doesn't count as an
 * escape.
 * 
 * Return True if and only if it is possible to escape.
 * 
 * Example 1: 
 * Input: ghosts = [[1, 0], [0, 3]] target = [0, 1] Output: true
 * Explanation: You can directly reach the destination (0, 1) at time 1, while
 * the ghosts located at (1, 0) or (0, 3) have no way to catch up with you.
 * 
 * Example 2: Input: ghosts = [[1, 0]] target = [2, 0] Output: false
 * Explanation: You need to reach the destination (2, 0), but the ghost at (1,
 * 0) lies between you and the destination. 
 * 
 * Example 3: Input: ghosts = [[2, 0]] target = [1, 0] Output: false 
 * Explanation: The ghost can reach the target at
 * the same time as you. 
 * 
 * Note:
 * 
 * All points have coordinates with absolute value <= 10000. The number of
 * ghosts will not exceed 100
 * 
 * 
 */
public class EscapeTheGhosts {
	
	static int dist(int[] src, int[] tgt) {
		return Math.abs(src[0] - tgt[0]) + Math.abs(src[1] - tgt[1]); 
	}

	public static boolean escapeGhosts(int[][] ghosts, int[] target) {
		int minDist = Integer.MAX_VALUE;
		for (int[] ghost : ghosts) {
			minDist = Math.min(minDist, dist(ghost, target));
		}
		int[] src = {0,0};
		return minDist > dist(src , target);

	}

	public static void main(String[] arg) {
		
		int[][] ghosts = {
				{1, 0},
				{0, 3}
		};
		
		int[] target = {0, 1};

		System.out.println(escapeGhosts(ghosts,target));

	}

}
