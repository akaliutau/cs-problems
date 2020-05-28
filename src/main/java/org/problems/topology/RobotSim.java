package org.problems.topology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/walking-robot-simulation/
 * 
 * A robot on an infinite grid starts at point (0, 0) and faces north. The robot
 * can receive one of three possible types of commands:
 * 
 * -2: turn left 90 degrees 
 * -1: turn right 90 degrees 
 * 1 <= x <= 9: move forward x units 
 * Some of the grid squares are obstacles.
 * 
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * 
 * If the robot would try to move onto them, the robot stays on the previous
 * grid square instead (but still continues following the rest of the route.)
 * 
 * Return the square of the maximum Euclidean distance that the robot will be
 * from the origin.
 * 
 * Example 1:
 * 
 * Input: commands = [4,-1,3], obstacles = [] Output: 25 
 * Explanation: robot will go to (3, 4) 
 * 
 * Example 2:
 * 
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]] Output: 65 
 * Explanation:
 * robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * 
 * Note:
 * 
 * 0 <= commands.length <= 10000 
 * 
 * 0 <= obstacles.length <= 10000
 *  
 * -30000 <= obstacle[i][0] <= 30000
 *  
 * -30000 <= obstacle[i][1] <= 30000
 *  
 * The answer is guaranteed to be less than 2 ^ 31.
 * 
 * Runtime: 14 ms, faster than 66.98% of Java online submissions for Walking Robot Simulation.
 * Memory Usage: 47.1 MB, less than 100.00% of Java online submissions for Walking Robot Simulation
 */
public class RobotSim {
	
	static int[] directions = {0,1, 1,0, 0,-1, -1,0};
	
	static class Obstacle{
		public int[] pos;
		public long dist;

		public Obstacle(int[] pos, long dist) {
			this.pos = pos;
			this.dist = dist;
		}
	}
	
	static long sqr(int a) {
		return a * a;
	}
	
	static long dist(int[] coords) {
		return sqr(coords[0]) + sqr(coords[1]);
	}
	
	static boolean checkObstacles(int x, int y, Map<Long, List<Obstacle>> layers) {
		long d = sqr(x) + sqr(y);
		if (layers.containsKey(d)) {
			List<Obstacle> obstacles = layers.get(d);
			for (Obstacle o : obstacles) {
				if (o.pos[0] == x && o.pos[1] == y) {
					return true;
				}
			}
		}
		return false;
	}

	public static int robotSim(int[] commands, int[][] obstacles) {
		Map<Long, List<Obstacle>> layers = new HashMap<>();
		for(int[] obstacle : obstacles) {
			long d = dist(obstacle);
			if (!layers.containsKey(d)) {
				layers.put(d, new ArrayList<>());
			}
			layers.get(d).add(new Obstacle(obstacle, d));
		}
		int curX = 0;
		int curY = 0;
		int dir = 0;
		long maxDist = 0;
		for (int i = 0; i < commands.length; i++) {
			int cmd = commands[i];
			if (cmd == -1) {
				dir += 2;
				dir = dir % 8; 
			}else if (cmd == -2) {
				dir -= 2;
				if (dir < 0) {
					dir += 8;
				}
			}else {
				for (int j = 0; j < cmd; j++) {
					int x =  curX + directions[dir];
					int y =  curY + directions[dir+1];
					if (!checkObstacles(x, y, layers)) {
						curX = x;
						curY = y;
					}else {
						break;
					}
				}				
			}
			maxDist = Math.max(maxDist, sqr(curX) + sqr(curY));
		}
		return (int) (maxDist);

	}

	public static void main(String[] arg) {
		
		int[] commands = {4,-1,3};
		int[][] obstacles = {};

		System.out.println(robotSim(commands, obstacles));

		int[] commands1 = {4,-1,4,-2,4};
		int[][] obstacles1 = {
				{2,4}
		};

		System.out.println(robotSim(commands1, obstacles1));

	}

}
