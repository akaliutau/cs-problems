package org.problems.minmax;

/**
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 * 
 * Given the string croakOfFrogs, which represents a combination of the string
 * "croak" from different frogs, that is, multiple frogs can croak at the same
 * time, so multiple “croak” are mixed. Return the minimum number of different
 * frogs to finish all the croak in the given string.
 * 
 * A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’
 * sequentially. The frogs have to print all five letters to finish a croak. If
 * the given string is not a combination of valid "croak" return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: croakOfFrogs = "croakcroak" Output: 1 
 * Explanation: One frog yelling
 * "croak" twice. Example 2:
 * 
 * Input: croakOfFrogs = "crcoakroak" Output: 2 
 * Explanation: The minimum number
 * of frogs is two. The first frog could yell "crcoakroak". The second frog
 * could yell later "crcoakroak"
 * 
 * 
 * 
 */
public class MinNumberOfFrogsCroak {

	public static int minNumberOfFrogs(String croakOfFrogs) {
		int counter = 0;
		int[] letters = new int[256];
		int thread = 0;

		for (int i = 0; i < croakOfFrogs.length(); i++) {
			char c = croakOfFrogs.charAt(i);
			if (c == 'c') {
				letters[c]++;
				thread++;
			} else if (c == 'r') {
				if (letters['c'] == 0) {
					return -1;
				} else {
					letters['c']--;
					letters[c]++;
				}
			} else if (c == 'o') {
				if (letters['r'] == 0) {
					return -1;
				} else {
					letters['r']--;
					letters[c]++;
				}
			} else if (c == 'a') {
				if (letters['o'] == 0) {
					return -1;
				} else {
					letters['o']--;
					letters[c]++;
				}
			} else if (c == 'k') {
				if (letters['a'] == 0) {
					return -1;
				} else {
					letters['a']--;
					counter = Math.max(thread, counter);
					thread--;
				}
			} else {
				return -1;
			}
		}
		for (int i = 0; i < 256; i++) {
			if (letters[i] != 0) {
				return -1;
			}
		}
		return counter;
	}

	public static void main(String[] arg) {

		System.out.println(minNumberOfFrogs("croakcroak"));
		System.out.println(minNumberOfFrogs("crcoakroak"));
		System.out.println(minNumberOfFrogs("croakcrook"));
		System.out.println(minNumberOfFrogs("croakcroa"));

	}

}
