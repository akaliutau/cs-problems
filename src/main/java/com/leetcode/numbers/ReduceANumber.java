package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 * 
 * Given a number s in their binary representation. Return the number of steps
 * to reduce it to 1 under the following rules:
 * 
 * If the current number is even, you have to divide it by 2.
 * If the current number is odd, you have to add 1 to it.
 * It's guaranteed that you can always reach to one for all testcases.
 * 
 * Example 1:
 * 
 * Input: s = "1101" Output: 6 
 * 
 * Explanation: "1101" corressponds to number 13 in
 * their decimal representation. Step 1) 13 is odd, add 1 and obtain 14. Step 2)
 * 14 is even, divide by 2 and obtain 7. Step 3) 7 is odd, add 1 and obtain 8.
 * Step 4) 8 is even, divide by 2 and obtain 4. Step 5) 4 is even, divide by 2
 * and obtain 2. Step 6) 2 is even, divide by 2 and obtain 1.
 * 
 * 
 */
public class ReduceANumber {

	public static int numSteps(String s) {
		int n = s.length();
		int steps = 0;
		int excess = 0;
		if (n <= 1) {
			return 0;
		}
		for (int i = n - 1; i > 0; i--) {
			char c = s.charAt(i);
			if (c == '0' && excess == 0) {
				steps++;
				excess = 0;
			} else if (c == '1' && excess == 0) {
				steps += 2;
				excess = 1;
			} else if (c == '0' && excess == 1) {
				steps += 2;
				excess = 1;
			} else if (c == '1' && excess == 1) {
				steps++;
				excess = 1;
			}
		}
		// last step - check length
		if (excess == 1) {
			return steps + 1;
		}
		return steps;
	}

	public static void main(String[] arg) {

		System.out.println(numSteps("111"));
		System.out.println(numSteps("1101"));
		System.out.println(numSteps("10"));
		System.out.println(numSteps("1"));

	}

}
