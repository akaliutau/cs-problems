package org.problems.numbers;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * Input: 1 Output: true 
 * Explanation: 2^0 = 1 
 * 
 * Example 2:
 * 
 * Input: 16 Output: true 
 * Explanation: 2^4 = 16
 * 
 * 
 */
public class PowerofTwo {
	
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
        	return true;
        }else if (n == -1 || n == 0) {
        	return false;
        }
        int sign = n >= 0 ? 1 : -1; 
        n = n > 0 ? n : -n; 
        if (sign == -1) {
        	return false;
        }
        
        int pow = 1;
        int counter = 0;

        while (n > 1) {
        	if (n % 2 != 0) {
        		return false;
        	}
        	n = n - n / 2;
        	counter ++;
        	pow *= 2;
        }
        
        return true;
    }

	public static void main(String[] arg) {

		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(-1));
		System.out.println(isPowerOfTwo(0));
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(8));
		System.out.println(isPowerOfTwo(24));
		System.out.println(isPowerOfTwo(224));
		System.out.println(isPowerOfTwo(256));
		System.out.println(isPowerOfTwo(-8));
		System.out.println(isPowerOfTwo(-24));
		System.out.println(isPowerOfTwo(-224));
		System.out.println(isPowerOfTwo(-256));

	}
}
