package org.problems.numbers;

/**
 * https://leetcode.com/problems/divide-two-integers/
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 */
public class DivideTwoIntegers {

	public static int divide(int div, int dvs) {
		int sign = 1;
		long counter = 0;
		long dividend = div;
		long divisor = dvs;
		if (dividend == 0) {
			return 0;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		if (dividend == Integer.MIN_VALUE && divisor < 0) {
			counter++;
			dividend -= divisor;
		}
		if (dividend == Integer.MIN_VALUE && divisor > 0) {
			counter++;
			dividend += divisor;
		}
		
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = -1;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int incBase = 1;
		
		// dividend = 9
		// divisor = 2
		// cumulative
		// 0			9
		// 2			7
		// (2+2)	3
		// (2+2+2+2)	stop: (2+2+2+2) > 3
		// 2			1
		// 2+2			stop: 2+2 > 1
		// 2			stop: 2 > 1 : exit
		// count(2) = 4
		
		long cumulative = divisor;

		while (true) {
			if (dividend == 0) {
				break;
			}
			if (cumulative > dividend ) {
				if (cumulative == divisor) {
					break;
				}else {
					cumulative = divisor;
					incBase = 1;
				}
			}else {
				dividend -= cumulative;
				counter += incBase;
				incBase += incBase;
				cumulative += cumulative;
			}
		}
		
		return (sign*(int)counter);
	}

	public static void main(String[] arg) {

		System.out.println(divide(10,3));
		System.out.println(divide(7,-3));
		System.out.println(divide(0,-3));
		System.out.println(divide(1,1));
		System.out.println(divide(1,-1));
		System.out.println(divide(-1,1));
		System.out.println(divide(-1,-1));
		System.out.println(divide(-4,2));
		
		System.out.println(divide(Integer.MIN_VALUE,-1));
		System.out.println(divide(Integer.MIN_VALUE,1));
		System.out.println(divide(Integer.MAX_VALUE,-1));
		System.out.println(divide(Integer.MAX_VALUE,1));
		System.out.println(divide(Integer.MAX_VALUE,2));
		System.out.println(divide(2,Integer.MIN_VALUE));
		
	}

}
