package org.problems.numbers;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 * 
 * Given an integer n. No-Zero integer is a positive integer which doesn't
 * contain any 0 in its decimal representation.
 * 
 * Return a list of two integers [A, B] where:
 * 
 * A and B are No-Zero integers. A + B = n 
 * It's guaranteed that there is at least
 * one valid solution. If there are many valid solutions you can return any of
 * them.
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: [1,1] Explanation: A = 1, B = 1. 
 * A + B = n and both A and B don't contain any 0 in their decimal representation. 
 * 
 * Example 2:
 * 
 * Input: n = 11 Output: [2,9] 
 * 
 * Example 3:
 * 
 * Input: n = 10000 Output: [1,9999] 
 * 
 * Example 4:
 * 
 * Input: n = 69 Output: [1,68]
 * 
 * 
 */
public class ConvertIntegerToTheSum {
	
	public static int[] getNoZeroIntegers(int n) {
		int normal = n > 0 ? n : -n;
		String s = String.valueOf(normal);

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int excess = 0;
		for (int i = s.length()-1; i > 0; i--) {
			int num = s.charAt(i)-'0';

			int dig1 = 0,dig2 = 0;
			if (num > 2) {
				dig1 = 1;
				dig2 = num - dig1 - excess;
				sb1.append(dig1);
				sb2.append(dig2);
				excess = 0;
			}else {
				if (num == 0) {
					if (excess == 0) {
						sb2.append(9);
						sb1.append(1);
					}else {
						sb2.append(8);
						sb1.append(1);
					}
				}else {
					dig1 = 9;
					dig2 = num - excess + 1;
					sb1.append(dig1);
					sb2.append(dig2);
				}
				excess = 1;
			}
		}
		int num = s.charAt(0)-'0';
		if (num == 1) {
			if (excess == 0) {
				sb1.append(1);
			}
		}else {
			int dig1 = 1;
			int dig2 = num - dig1 - excess;
			sb1.append(dig1);
			sb2.append(dig2);
		}

		int[] res = new int[2];
		res[0] = Integer.valueOf(sb1.reverse().toString());
		res[1] = Integer.valueOf(sb2.reverse().toString());
		return res;
        
    }

	public static void main(String[] arg) {

		Utils.print(getNoZeroIntegers(7));
		Utils.print(getNoZeroIntegers(11));
		Utils.print(getNoZeroIntegers(10000));
		Utils.print(getNoZeroIntegers(69));
		Utils.print(getNoZeroIntegers(137));
		Utils.print(getNoZeroIntegers(999));
		Utils.print(getNoZeroIntegers(10101));
		Utils.print(getNoZeroIntegers(1001));
		Utils.print(getNoZeroIntegers(2218));

	}

}
