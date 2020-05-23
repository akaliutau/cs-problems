package org.problems.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/
 * 
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self
 * dividing number, including the bounds if possible.
 * 
 * Example 1: Input: left = 1, right = 22 
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22] 
 * 
 * Note:
 * 
 * The boundaries of each input argument are 1 <= left <= right <= 10000
 */
public class SelfDividingNumbers {
	
	public static boolean isSelfDividingNumber(int num) {
		int i = num;
		while (i > 0) {
			int dig = i % 10;
			if (dig == 0) {
				return false;
			}
			if (num % dig != 0) {
				return false;
			}
			i -= dig;
			i /= 10;
		}
		return true;
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (isSelfDividingNumber(i)) {
				res.add(i);
			}
		}
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(selfDividingNumbers(1,100));

	}

}
