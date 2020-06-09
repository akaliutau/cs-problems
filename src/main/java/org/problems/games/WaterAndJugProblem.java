package org.problems.games;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 *
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water contained
 * within one or both buckets by the end.
 * 
 * Operations allowed:
 * 
 * Fill any of the jugs completely with water. 
 * Empty any of the jugs. 
 * Pour water from one jug into another till the other jug is completely full or the first
 * jug itself is empty. 
 * 
 * Example 1: (From the famous "Die Hard" example)
 * Input: x = 3, y = 5, z = 4 Output: True 
 * 
 * Example 2:
 * Input: x = 2, y = 6, z = 5 Output: False
 * 
 */
public class WaterAndJugProblem {
	
	static int gcd(int vol1, int vol2) {
		if (vol2 == 0) {
			return vol1;
		}
		return gcd(vol2, vol1 % vol2);
	}

	public static boolean canMeasureWater(int x, int y, int z) {
		
		int big, small;
		if (x > y) {
			big = x;
			small = y;
		}else {
			big = y;
			small = x;
		}
		
		if (z == 0) {
			return true;
		}
        if (x + y < z) {
            return false;
        }
		int diff = gcd(big,small);
        if (diff == 0){
            return false;
        }
		if (z % diff != 0) {
			return false;
		}

		return true;
	}

	public static void main(String[] arg) {

		System.out.println(canMeasureWater(3, 5, 4));//true
		System.out.println(canMeasureWater(2, 6, 5));//false
		System.out.println(canMeasureWater(34, 5, 6));//true
		System.out.println(canMeasureWater(4, 6, 8));//true

	}
}
