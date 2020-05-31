package org.problems.regex;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/shortest-completing-word/
 * 
 * Find the minimum length word from a given dictionary words, which has all the
 * letters from the string licensePlate. Such a word is said to complete the
 * given string licensePlate
 * 
 * Here, for letters we ignore case. For example, "P" on the licensePlate still
 * matches "p" on the word.
 * 
 * It is guaranteed an answer exists. If there are multiple answers, return the
 * one that occurs first in the array.
 * 
 * The license plate might have the same letter occurring multiple times. For
 * example, given a licensePlate of "PP", the word "pair" does not complete the
 * licensePlate, but the word "supper" does.
 * 
 * Example 1: Input: licensePlate = "1s3 PSt", words = ["step", "steps",
 * "stripe", "stepple"] Output: "steps" Explanation: The smallest length word
 * that contains the letters "S", "P", "S", and "T". Note that the answer is not
 * "step", because the letter "s" must occur in the word twice. Also note that
 * we ignored case for the purposes of comparing whether a letter exists in the
 * word.
 * 
 * Example 2: Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew",
 * "show"] Output: "pest" Explanation: There are 3 smallest length words that
 * contains the letters "s". We return the one that occurred first.
 * 
 * Note: licensePlate will be a string with length in range [1, 7]. licensePlate
 * will contain digits, spaces, or letters (uppercase or lowercase). words will
 * have a length in the range [10, 1000]. Every words[i] will consist of
 * lowercase letters, and have length in range [1, 15]
 * 
 */
public class ShortestCompletingWord {

	static class Word {
		public String str;
		public int pos;
		// shows letters in this word
		public int[] distr = new int[26];

		public Word(String str, int pos) {
			this.str = str;
			this.pos = pos;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c >= 'a' && c <= 'z') {
					distr[c - 'a'] ++;
				} else if (c >= 'A' && c <= 'Z') {
					distr[c - 'A'] ++;
				}
			}
		}

		public boolean match(int[] required) {
			for (int i = 0; i < 26; i++) {
				if (required[i] > 0 && distr[i] < required[i]) {
					return false;
				}
			}
			return true;
		}
	}

	public static String shortestCompletingWord(String licensePlate, String[] words) {
		Word license = new Word(licensePlate, 0);
		int n = words.length;
		Word[] sorted = new Word[n];
		for (int i = 0; i < n; i++) {
			sorted[i] = new Word(words[i], i);
		}
		Comparator<Word> bylen = (o, p) -> Integer.compare(o.str.length(), p.str.length());
		Comparator<Word> byPos = (o, p) -> Integer.compare(o.pos, p.pos);
		Arrays.sort(sorted, bylen.thenComparing(byPos));
		for (int i = 0; i < n; i++) {
			Word w = sorted[i];
			if (w.match(license.distr)) {
				return w.str;
			}
		}
		return "";

	}

	public static void main(String[] arg) {

		String[] words = { "step", "steps", "stripe", "stepple" };
		System.out.println(shortestCompletingWord("1s3 PSt", words));

		String[] words1 = { "looks", "pest", "stew", "show"};
		System.out.println(shortestCompletingWord("1s3 456", words1));

	}

}
