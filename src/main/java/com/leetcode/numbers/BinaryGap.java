package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/binary-gap/
 *
 * Given a positive integer N, find and return the longest distance between two
 * consecutive 1's in the binary representation of N.
 * 
 * If there aren't two consecutive 1's, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 22 Output: 2 
 * 
 * Explanation: 22 in binary is 0b10110. In the binary
 * representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2. The second consecutive
 * pair of 1's have distance 1. The answer is the largest of these two
 * distances, which is 2.
 *
 *
 * 
 */
public class BinaryGap {
	
	public static int binaryGap(int N) {
		
		String bin = Integer.toBinaryString(N);
		int left = -1;
		int right = -1;
		int dist = 0;
		
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(i) == '1') {
				left = i;
				break;
			}
		}
		if (left < 0) {
			return 0;
		}
		
		right = left;
		
		while (++right < bin.length()) {
			if (bin.charAt(right) == '1') {// next 1
				if (right-left > dist) {
					dist = right-left;
				}
				left = right;
			}
		}
		
		
		return dist;
        
    }


	public static void main(String[] arg) {

		System.out.println(binaryGap(5));
		System.out.println(binaryGap(1));
	}

}
