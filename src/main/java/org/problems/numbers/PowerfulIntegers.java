package org.problems.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/powerful-integers/
 * 
 * Given two positive integers x and y, an integer is powerful if it is equal to
 * x^i + y^j for some integers i >= 0 and j >= 0.
 * 
 * Return a list of all powerful integers that have value less than or equal to
 * bound.
 * 
 * You may return the answer in any order. In your answer, each value should
 * occur at most once.
 * 
 * Example 1:
 * 
 * Input: x = 2, y = 3, bound = 10 Output: [2,3,4,5,7,9,10] Explanation: 
 * 2 = 2^0 + 3^0 
 * 3 = 2^1 + 3^0 
 * 4 = 2^0 + 3^1 
 * 5 = 2^1 + 3^1 
 * 7 = 2^2 + 3^1 
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2 
 * 
 * Example 2:
 * 
 * Input: x = 3, y = 5, bound = 15 Output: [2,4,6,8,10,14]
 * 
 * 
 * Note:
 * 
 * 1 <= x <= 100 
 * 1 <= y <= 100 
 * 0 <= bound <= 10^6
 * 
 * Runtime: 1 ms, faster than 95.87% of Java online submissions for Powerful Integers.
 * Memory Usage: 36.9 MB, less than 12.50% of Java online submissions for Powerful Integers
 */
public class PowerfulIntegers {

	public static List<Integer> powerfulIntegers(int x, int y, int bound) {
		
		Set<Integer> res = new HashSet<>();
		int[] nums = {x, y};
		Arrays.parallelSort(nums);
		int base = 1;
		while (base < bound) {
			int curBound = bound - base;
			int num = 1;
			while (curBound >= num) {
				res.add(num + base);
				num *= nums[0];
				if (num == 1) {
					break;
				}
			}
			base *= nums[1];
			if (base == 1) {
				break;
			}
		}
		
		return new ArrayList<>(res);
        
    }

	public static void main(String[] arg) {

		System.out.println(powerfulIntegers(2, 3, 10));
		System.out.println(powerfulIntegers(3, 5, 15));
		System.out.println(powerfulIntegers(1, 1, 2));

	}

}
