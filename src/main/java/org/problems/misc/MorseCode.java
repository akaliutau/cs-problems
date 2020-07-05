package org.problems.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-morse-code-words/
 * 
 * International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps
 * to "-...", "c" maps to "-.-.", and so on.
 * 
 * For convenience, the full table for the 26 letters of the English alphabet is
 * given below:
 * 
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
 *  "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
 *  "-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of
 * the Morse code of each letter. For example, "cba" can be written as
 * "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call
 * such a concatenation, the transformation of a word.
 * 
 * Return the number of different transformations among all words we have.
 * 
 * Example: Input: words = ["gin", "zen", "gig", "msg"] Output: 2 
 * Explanation:
 * The transformation of each word is: "gin" -> "--...-." "zen" -> "--...-."
 * "gig" -> "--...--." "msg" -> "--...--."
 * 
 * There are 2 different transformations, "--...-." and "--...--." 
 * 
 * Note:
 * 
 * The length of words will be at most 100. 
 * Each words[i] will have length in range [1, 12]. 
 * words[i] will only consist of lowercase letters.
 * 
 * 
 * 
 */
public class MorseCode {
	
	static class Vector {
		public char[] fp;
		
		public Vector(String code) {
			int n = code.length();
			fp = new char[n];
			for (int i = 0; i < n; i++) {
				fp[i] = code.charAt(i);
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(fp);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vector other = (Vector) obj;
			if (!Arrays.equals(fp, other.fp))
				return false;
			return true;
		}
	}

	public static int uniqueMorseRepresentations(String[] words) {
		
		String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
				   "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
				   "-.--","--.."};
		
		Set<Vector> set = new HashSet<>();
		for (String w : words) {
			StringBuilder sb  = new StringBuilder();
			for (int i = 0; i < w.length(); i++) {
				sb.append(codes[w.charAt(i) - 'a']);
			}
			Vector v = new Vector(sb.toString());
			set.add(v);
		}
		return set.size();

	}

	public static void main(String[] arg) {

		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));

	}

}
