package org.problems.active;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/convert-to-base-2/
 * 
 * Given a number N, return a string consisting of "0"s and "1"s that represents
 * its value in base -2 (negative two).
 * 
 * The returned string must have no leading zeroes, unless the string is "0".
 * 
 * Example 1:
 * Input: 2 Output: "110" Explanation: (-2) ^ 2 + (-2) ^ 1 = 2 
 * 
 * Example 2:
 * Input: 3 Output: "111" Explanation: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3 
 * 
 * Example 3:
 * Input: 4 Output: "100" Explanation: (-2) ^ 2 = 4
 * 
 * Note:
 * 0 <= N <= 10^9
 * 
 */
public class ConvertoBase2 {
	
	static class Sum {
		public int index;
		public int power;
		public int value;
		
		public boolean even() {
			return power % 2 == 0;
		}
		
		public int getPower() {
			return (int) Math.pow(2, power);
		}
		
	}
	
	public static String baseNeg2(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 1) {
			return "0";
		}
		
		int max = 1;
		int idx = 0;
		if (n > 0) {
			int normalVal = n;
			idx = 0;
			while (max <= normalVal) {
				max = (int) Math.pow(2, idx);
				idx += 2;
			}
		}else {
			int normalVal = -n;
			idx = 1;
			while (max <= normalVal) {
				max = (int) Math.pow(2, idx);
				idx += 2;
			}
		}
		System.out.println("idx="+idx);
		int[] a = new int[idx+2];
		
		Sum firstSum = new Sum();
		firstSum.index = 0;
		firstSum.power = 0;
		firstSum.value = 0;
		
		Sum secondSum = new Sum();
		secondSum.index = 1;
		secondSum.power = 1;
		secondSum.value = 0;
		
		int sum = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			}else {
				n = n - 1;
			}
			if (firstSum.index % 2 == 0) {
				a[firstSum.index] = 1;
				firstSum.index++;
			}else {
				a[secondSum.index] = 1;
				secondSum.index++;
			}
			firstSum.index += 2;
			secondSum.index += 2;
		}
		
		Utils.print(a);
		return sb.toString();
        
    }


	public static void main(String[] arg) {

		System.out.println(baseNeg2(2));//110
		System.out.println(baseNeg2(3));//111
		System.out.println(baseNeg2(16));

	}

}
