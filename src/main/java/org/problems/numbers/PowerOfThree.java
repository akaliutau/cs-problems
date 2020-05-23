package org.problems.numbers;

/**
 * https://leetcode.com/problems/power-of-three/
 * 
 */
public class PowerOfThree {
	
	public static boolean isPowerOfThree(int n) {
        if (n == 1){
            return true;
        }
        if (n < 3){
            return false;
        }
        double d = n;
        while (d>=3){
            d /= 3;
        }
        return d == 1.0;
    }

	public static void main(String[] arg) {
		
		System.out.println(isPowerOfThree(27));

	}

}

