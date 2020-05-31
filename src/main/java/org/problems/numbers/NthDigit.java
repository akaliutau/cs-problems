package org.problems.numbers;

/**
 * https://leetcode.com/problems/nth-digit/
 * 
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8,
 * 9, 10, 11, ...
 * 
 * Note: n is positive and will fit within the range of a 32-bit signed integer
 * (n < 2^31).
 * 
 * Example 1:
 * 
 * Input: 3 Output: 3 
 * 
 * Example 2:
 * 
 * Input: 11 Output: 0
 * 
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ... is a 0, which is part of the number 10.
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Nth Digit.
 * Memory Usage: 35.8 MB, less than 10.00% of Java online submissions for Nth Digit.
 */
public class NthDigit {
	
	static class Number {
		public int digit;
		public long num;
		public int len;

		public Number(int digit, long num, int len) {
			this.digit = digit;
			this.num = num;
			this.len = len;
		}
	}
	
	/**
	 *  detect block
	 * @param n
	 * @return
	 */
	static Number getMileStone(int n) {

		if (n < 10) {
			return new Number(0,n,1);
		}
		long counter = 10;
		long block = 10;
		int len = 1;
		while (true) {

			long nextBlock = 10 * block;
			int nextLen = len + 1;
			long nextCounter = counter + 9 * nextBlock * nextLen / 10; 
			if (nextCounter > n) {
				break;
			}
			block = nextBlock;
			len = nextLen;
			counter = nextCounter;
		}

		int word = len + 1;
		long offset = (n - counter) / word;
		int digit = (int) ((n - counter) % word);
		long num = (long) Math.pow(10, word-1) + offset;

		
		return new Number(digit,num,word);
		
	}
	
	public static int findNthDigit(int n) {
		Number num = getMileStone(n);
		int idx = num.len - num.digit - 1;
		int i = 0;
		int d = 0;
		long numb = num.num;
		while (i < num.len) {
			d = (int) (numb % 10);
			numb -= d;
			numb /= 10;
			if (i == idx) {
				return d;
			}
			i++;
		}
		return d;
        
    }

	public static void main(String[] arg) {

		System.out.println(findNthDigit(12334));
		System.out.println(findNthDigit(11));
		System.out.println(findNthDigit(15));
		System.out.println(findNthDigit(3));
		System.out.println(findNthDigit(1000));//3
		System.out.println(findNthDigit(100000000));//3
	}
}
