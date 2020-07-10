package org.problems.numbers;

/**
 * https://leetcode.com/problems/complex-number-multiplication/
 * 
 * Given two strings representing two complex numbers.
 * 
 * You need to return a string representing their multiplication. Note i^2 = -1
 * according to the definition.
 * 
 * Example 1: Input: "1+1i", "1+1i" Output: "0+2i" 
 * Explanation: (1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i, 
 * and you need convert it to the form of 0+2i.
 * 
 * Example 2: Input: "1+-1i", "1+-1i" Output: "0+-2i" 
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, 
 * and you need convert it to the form of 0+-2i.
 * 
 * Note:
 * 
 * The input strings will not have extra blank. The input strings will be given
 * in the form of a+bi, where the integer a and b will both belong to the range
 * of [-100, 100]. 
 * And the output should be also in this form.
 */
public class ComplexNumbers {
	
	static class Complex {

		public int[] coef = new int[2];

		public Complex(String str) {
			String[] parts = str.split("\\+");
			this.coef[0] = Integer.valueOf(parts[0]);
			this.coef[1] = Integer.valueOf(parts[1].substring(0, parts[1].length() - 1));
		}
		
		public void mult(Complex c) {
			int real = coef[0] * c.coef[0] - coef[1] * c.coef[1];
			int im = coef[0] * c.coef[1] + coef[1] * c.coef[0];
			coef[0] = real;
			coef[1] = im;
		}
		
		@Override
		public String toString() {
			return String.format("%d+%di", coef[0], coef[1]);
		}
	}

	public static String complexNumberMultiply(String a, String b) {
		
		Complex ca = new Complex(a);
		Complex cb = new Complex(b);
		ca.mult(cb);
		
		return ca.toString();

	}

	public static void main(String[] arg) {

		System.out.println(complexNumberMultiply("1+1i", "1+1i"));
		System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));

	}

}
