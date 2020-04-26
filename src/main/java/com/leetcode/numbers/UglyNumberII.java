package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example:
 * 
 * Input: n = 10 Output: 12 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the
 * sequence of the first 10 ugly numbers
 */
public class UglyNumberII {
	
	static long number(long n) {
		// calculate number of 2-, 3- and 5-cycles
		// remove coincidences in cycles
		long numberOf2 = n / 2;
		long numberOf3 = n / 3;
		long numberOf5 = n / 5;
		
		long coincidences23 = n / (2 * 3);
		long coincidences35 = n / (3 * 5);
		long coincidences25 = n / (2 * 5);
		
		return numberOf2 + numberOf3 + numberOf5 + 1 - (coincidences23 + coincidences35 + coincidences25);
		
	}
	
	static boolean isUgly(long n) {
		while ( n % 2 == 0) {
			n = n / 2;
		}
		while ( n % 3 == 0) {
			n = n / 3;
		}
		while ( n % 5 == 0) {
			n = n / 5;
		}
		return n == 1;
	}

	public static int nthUglyNumber(int n) {
		
		if (n == 1) {
			return 1;
		}
		
        if(n <= 6) return n;
        int[] cache = new int[n];
        cache[0] = 1;
        int div2 = 0;
        int div3 = 0;
        int div5 = 0;
        int index = 1;
        while(index < n){
            int n2 = 2*cache[div2], n3 = 3*cache[div3], n5 = 5*cache[div5];
            int temp = Math.min(n2, Math.min(n3, n5));
            cache[index++] = temp;
            if(temp == n2) {
            	div2++;
            }
            if(temp == n3) {
            	div3++;
            }
            if(temp == n5) {
            	div5++;
            }
        }
        return cache[n-1];

	}

	public static void main(String[] arg) {

		System.out.println(nthUglyNumber(2));//2
		System.out.println(nthUglyNumber(5));//5
		System.out.println(nthUglyNumber(6));//6
		System.out.println(nthUglyNumber(7));//8
		System.out.println(nthUglyNumber(8));//9
		System.out.println(nthUglyNumber(9));//10
		System.out.println(nthUglyNumber(10));//12
		System.out.println(nthUglyNumber(11));//15
		System.out.println(nthUglyNumber(12));//16

	}

}
