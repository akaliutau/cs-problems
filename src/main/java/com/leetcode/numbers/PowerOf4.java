package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/power-of-four/
 * 
 *  Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *  
 * 
 */
public class PowerOf4 {
	
	public static boolean isPowerOfFour(int num) {
        if (num == 0){
            return false;
        }
	    int pow = (int) (Math.log(num)/Math.log(4));
        if (num < 0){
            return false;
        }
	    return num == Math.pow(4, pow);
	}
	
	public static void main(String[] arg) {

		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(-16));
		System.out.println(isPowerOfFour(-64));
		System.out.println(isPowerOfFour(0));
		System.out.println(isPowerOfFour(1));

	}
}
