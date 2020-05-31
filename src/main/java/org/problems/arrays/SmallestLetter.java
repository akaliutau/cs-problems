package org.problems.arrays;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that
 * is larger than the given target.
 * 
 * Letters also wrap around. For example, if the target is target = 'z' and
 * letters = ['a', 'b'], the answer is 'a'.
 * 
 * Examples: Input: letters = ["c", "f", "j"] target = "a" Output: "c"
 * 
 * Input: letters = ["c", "f", "j"] target = "c" Output: "f"
 * 
 * Input: letters = ["c", "f", "j"] target = "d" Output: "f"
 * 
 * Input: letters = ["c", "f", "j"] target = "g" Output: "j"
 * 
 * Input: letters = ["c", "f", "j"] target = "j" Output: "c"
 * 
 * Input: letters = ["c", "f", "j"] target = "k" Output: "c" 
 * Note: letters has a
 * length in range [2, 10000]. letters consists of lowercase letters, and
 * contains at least 2 unique letters. target is a lowercase letter
 * 
 */
public class SmallestLetter {
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length;
        for (int i = 0; i < n; i++) {
        	if (letters[i] > target) {
        		return letters[i];
        	}
        }
        return letters[0];
    }

	public static void main(String[] arg) {

		char[] letters = {'a', 'b'};
		System.out.println(nextGreatestLetter(letters, 'z'));

		char[] letters1 = {'c', 'f', 'j'};
		System.out.println(nextGreatestLetter(letters1, 'a'));

		char[] letters2 = {'c', 'f', 'j'};
		System.out.println(nextGreatestLetter(letters2, 'c'));

	}

}
