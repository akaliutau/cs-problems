package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/hamming-distance/
 *
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 2^31.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 
 * 1 (0 0 0 1) 
 * 4 (0 1 0 0)
 *      ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 */
public class HammingDistance {
	
	public static int hammingDistance(int x, int y) {
        int counter = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
        	if (((x ^ y) & mask) == mask) {
        		counter ++;
        	}
        	mask = mask << 1;
        }
        
		return counter;
    }

	public static void main(String[] arg) {

		System.out.println(hammingDistance(1,4));
		System.out.println(hammingDistance(0,0));
		System.out.println(hammingDistance(7,7));
		System.out.println(hammingDistance(1,0));

	}
}
