package org.problems.strings;

/**
 * https://leetcode.com/problems/maximum-number-of-balloons/
 * 
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number of
 * instances that can be formed.
 * 
 * 
 * 
 * Example 1:
 * Input: text = "nlaebolko" Output: 1 
 * 
 * Example 2:
 * Input: text = "loonbalxballpoon" Output: 2 
 * 
 * Example 3:
 * Input: text = "leetcode" Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= text.length <= 10^4 text consists of lower case English letters only
 * 
 */
public class MaximumNumberOfBalloons {

	public static int maxNumberOfBalloons(String text) {
		char[] hist = new char[26];
		for (int i = 0; i < text.length(); i++) {
			hist[text.charAt(i)-'a'] ++;
		}
		int words = Integer.MAX_VALUE;
		words = Math.min(words, hist['b'-'a']);
		words = Math.min(words, hist['a'-'a']);
		words = Math.min(words, hist['l'-'a'] / 2);
		words = Math.min(words, hist['o'-'a'] / 2);
		words = Math.min(words, hist['n'-'a']);
		return words;

	}

	public static void main(String[] arg) {

		System.out.println(maxNumberOfBalloons("nlaebolko"));
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(maxNumberOfBalloons("leetcode"));

	}

}
