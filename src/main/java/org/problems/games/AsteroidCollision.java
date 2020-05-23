package org.problems.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/asteroid-collision/
 * 
 * We are given an array asteroids of integers representing asteroids in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 * 
 * Example 1: Input: asteroids = [5, 10, -5] Output: [5, 10] Explanation: The 10
 * and -5 collide resulting in 10. The 5 and 10 never collide.
 * 
 * 
 */
public class AsteroidCollision {

	public static int[] asteroidCollision(int[] asteroids) {

		List<Integer> astr = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
		boolean isCollisions = true;
		while (isCollisions) {
			isCollisions = false;
			List<Integer> updt = new ArrayList<>();
			int size = astr.size();
			int i = 0;
			if (size == 1) {
				break;
			}
			while (i < size - 1) {
				int first = astr.get(i);
				int second = astr.get(i + 1);
				if (first > 0 && second < 0) {
					int res = first + second;
					if (res > 0) {
						updt.add(first);
					} else if (res < 0) {
						updt.add(second);
					}
					i += 2;
					isCollisions = true;
				} else {
					updt.add(first);
					i += 1;
				}
			}

			if (size > 1 && ((astr.get(size - 1) < 0 && astr.get(size - 2) < 0)
					|| (astr.get(size - 1) > 0 && astr.get(size - 2) > 0)
					|| (astr.get(size - 1) > 0 && astr.get(size - 2) < 0))) {
				updt.add(astr.get(size - 1));
			}
			astr = updt;
		}

		int[] results = new int[astr.size()];
		int i = 0;
		for (Integer val : astr) {
			results[i++] = val;
		}

		return results;

	}

	public static void main(String[] arg) {

		int[] arr = { 5, 10, -5 };
		Utils.print(asteroidCollision(arr));

		int[] arr1 = { 5, -5 };
		Utils.print(asteroidCollision(arr1));

		int[] arr2 = { -2, -1, 1, 2 };
		Utils.print(asteroidCollision(arr2));

		int[] arr3 = { 51, 2, -5 };
		Utils.print(asteroidCollision(arr3));

		int[] arr4 = { -2, -2, -5, 2 };
		Utils.print(asteroidCollision(arr4));

	}

}
