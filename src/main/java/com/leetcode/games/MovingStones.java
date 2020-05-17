package com.leetcode.games;

import java.util.Arrays;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 * 
 * Three stones are on a number line at positions a, b, and c.
 * 
 * Each turn, you pick up a stone at an endpoint (ie., either the lowest or
 * highest position stone), and move it to an unoccupied position between those
 * endpoints. Formally, let's say the stones are currently at positions x, y, z
 * with x < y < z. You pick up the stone at either position x or position z, and
 * move that stone to an integer position k, with x < k < z and k != y.
 * 
 * The game ends when you cannot make any more moves, ie. the stones are in
 * consecutive positions.
 * 
 * When the game ends, what is the minimum and maximum number of moves that you
 * could have made? Return the answer as an length 2 array: answer =
 * [minimum_moves, maximum_moves]
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: a = 1, b = 2, c = 5 Output: [1,2] Explanation: Move the stone from 5
 * to 3, or move the stone from 5 to 4 to 3. 
 * 
 * Example 2:
 * 
 * Input: a = 4, b = 3, c = 2 Output: [0,0] Explanation: We cannot make any
 * moves. 
 * 
 * Example 3:
 * 
 * Input: a = 3, b = 5, c = 1 Output: [1,2] Explanation: Move the stone from 1
 * to 4; or move the stone from 1 to 2 to 4.
 * 
 * 
 * Note:
 * 
 * 1 <= a <= 100 
 * 1 <= b <= 100 
 * 1 <= c <= 100 
 * a != b, b != c, c != a
 * 
 * 
 */
public class MovingStones {
	
	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	static int dist (int a, int b) {
		return Math.abs(a - b);
	}

	public static int[] numMovesStones(int a, int b, int c) {
		
		int[] pos = new int[3];
		pos[0] = a;
		pos[1] = b;
		pos[2] = c;
		Arrays.sort(pos);
		if (dist(pos[1], pos[0]) > dist(pos[2], pos[1])) {
			swap(pos,0,2);
		}
		int[] res = new int[2];
		if (dist(pos[1], pos[0]) == 1 && dist(pos[1], pos[2]) == 1) {
			return res; 
		}
		int min = 0, max = 0;
		if (dist(pos[1], pos[0]) == 1) {
			max = 1 + (dist(pos[1], pos[2]) - 2);
			min = 1;
		}else {
			max = dist(pos[0], pos[1]) + (dist(pos[1], pos[2]) - 2);
			min = 1;
			if (dist(pos[0], pos[1]) - 1 > 1) {
				min += 1;
			}
		}
		res[0] = min;
		res[1] = max;
		return res;
        
    }

	public static void main(String[] arg) {

		Utils.print(numMovesStones(1, 2, 5));//1,2
		Utils.print(numMovesStones(4, 3, 2));//0,0
		Utils.print(numMovesStones(3, 5, 1));//1,2
		Utils.print(numMovesStones(7, 4, 1));//2,4
		Utils.print(numMovesStones(3, 4, 1));//1,1

	}

}
