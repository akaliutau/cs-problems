package org.problems.favourite;

import java.util.Arrays;

/**
 * Longest String Without 3 Consecutive Characters
 * 
 * Given 3 counters A, B, C, find any string of maximum length that can be created such
 * that no 3 consecutive characters are same. 
 * There can be at max A 'a', B 'b' and C 'c'.
 * 
 * Example 1:
 * 
 * Input: A = 1, B = 1, C = 6 Output: "ccbccacc"
 * 
 * Example 2:
 * 
 * Input: A = 1, B = 2, C = 3 Output: "acbcbc"
 * 
 * 
 * 
 */
public class StringWithNoConsecutiveChar {
	
	static class Letter {
		public char c;
		public int freq;
		
		public Letter(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}
		
	}
	
	public static String largestSequence(int[] freq) {
		Letter[] letters = new Letter[3];
		for (int i = 0; i < 3; i++) {
			letters[i] = new Letter((char)('a' + i), freq[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			Arrays.parallelSort(letters, (o,p) -> Integer.compare(p.freq, o.freq));
			Letter choice = letters[0];
	        if (choice.freq == 0) {
	        	break; // If no more character available
	        }
	        if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == choice.c && sb.charAt(sb.length() - 2) == choice.c) {
	            choice = letters[1];
	            if (choice.freq == 0) {
	            	break;
	            }
	        }
	        choice.freq --; 
	        sb.append(choice.c);
	    }
		return sb.toString();
	}
	

	public static void main(String[] arg) {
		
		int[] freq = {1, 1, 6};
		System.out.println(largestSequence(freq));

		int[] freq1 = {1, 2, 3};
		System.out.println(largestSequence(freq1));

		int[] freq2 = {1, 1, 1};
		System.out.println(largestSequence(freq2));

		int[] freq3 = {1, 0, 1};
		System.out.println(largestSequence(freq3));

		int[] freq4 = {1, 2, 1};
		System.out.println(largestSequence(freq4));

		int[] freq5 = {2, 0, 4};
		System.out.println(largestSequence(freq5));

		int[] freq6 = {5, 0, 5};
		System.out.println(largestSequence(freq6));

		int[] freq7 = {0, 0, 0};
		System.out.println(largestSequence(freq7));

		
	}

}
