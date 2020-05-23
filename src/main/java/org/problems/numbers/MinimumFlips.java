package org.problems.numbers;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 * 
 * Given 3 positives numbers a, b and c. Return the minimum flips required in
 * some bits of a and b to make ( a OR b == c ). (bitwise OR operation). Flip
 * operation consists of change any single bit 1 to 0 or change the bit 0 to 1
 * in their binary representation
 * 
 * Example 1:
 * Input: a = 2, b = 6, c = 5 Output: 3 Explanation: After flips a = 1 , b = 4 ,
 * c = 5 such that (a OR b == c) 
 * 
 * Example 2:
 * 
 * Input: a = 4, b = 2, c = 7 Output: 1 
 * 
 * Example 3:
 * 
 * Input: a = 1, b = 2, c = 3 Output: 0
 * 
 * Constraints:
 * 
 * 1 <= a <= 10^9 
 * 1 <= b <= 10^9 
 * 1 <= c <= 10^9
 * 
 * algorithm:
 * 1) bit = 1 in both a & b, c = 0 +2
 * 2) bit = 1 in a | b and c = 0 : +1
 * 3) bit = 0 in a & b and c = 0 : +0 
 * 4) bit = 1 in both a & b, c = 1 +0
 */
public class MinimumFlips {
	
	static class Number {
		boolean[] bits;
		
		public Number(int n){
			
			int len = n <= 1 ? 1 : (int) (Math.log(n)/Math.log(2)) + 1;
			bits = new boolean[len];
			int idx = 0;
			while (len > idx) {
				bits[idx++] = (n & 1) == 1;
				n = n >> 1;
			}
		}
		
		public boolean bit(int i) {
			return i >= bits.length ? false : bits[i];
		}
		
		public int len() {
			return bits.length;
		}

		@Override
		public String toString() {
			return "Number [bits=" + Arrays.toString(bits) + "]";
		}
	}

	public static int minFlips(int a, int b, int c) {
		
		Number numA = new Number(a);
		Number numB = new Number(b);
		Number numC = new Number(c);
		int length = Math.max(numC.len(), Math.max(numA.len(), numB.len()));
		int flips = 0;
		for (int i = 0; i < length; i++) {
			if (numC.bit(i)) {
				if (!numA.bit(i) && !numB.bit(i)) {
					flips ++;
				}
			} else {
				if (numA.bit(i) && numB.bit(i)) {
					flips += 2;
				}else if (numA.bit(i) || numB.bit(i)) {
					flips ++;
				}
			}
		}
		
		return flips;
        
    }

	public static void main(String[] arg) {

		System.out.println(minFlips(2, 6, 5));
		System.out.println(minFlips(4, 2, 7));
		System.out.println(minFlips(1, 2, 3));
		System.out.println(minFlips(0, 0, 3));
		System.out.println(minFlips(8, 3, 5));

	}

}
