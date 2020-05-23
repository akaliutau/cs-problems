package org.problems.numbers;

/**
 * https://leetcode.com/problems/reverse-bits/
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:  00000010100101000001111010011100 
 * Output: 00111001011110000010100101000000 
 * 
 * 
 */
public class ReverseBits {

	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	long l = n;
    	long res = 0;
    	int sign = n >= 0 ? 0 : 1; 
    	for (int i = 0; i < 31; i++) {
    		if ((l & 1) == 1) {
    			res += 1;
    		}
    		res = res << 1;
    		l = l >> 1;
    	}
    	res += sign;
		return (int)res;
        
    }
    
	public static void main(String[] arg) {

		System.out.println(reverseBits(43261596));//964176192
		System.out.println(reverseBits(-3));//-1073741825 

	}
}
