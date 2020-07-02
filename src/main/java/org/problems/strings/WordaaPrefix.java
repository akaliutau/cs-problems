package org.problems.strings;

/**
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 * 
 * Given a sentence that consists of some words separated by a single space, and
 * a searchWord.
 * 
 * You have to check if searchWord is a prefix of any word in sentence.
 * 
 * Return the index of the word in sentence where searchWord is a prefix of this
 * word (1-indexed).
 * 
 * If searchWord is a prefix of more than one word, return the index of the
 * first word (minimum index). If there is no such word return -1.
 * 
 * A prefix of a string S is any leading contiguous substring of S.
 * 
 * 
 * 
 */
public class WordaaPrefix {

	public static int isPrefixOfWord(String sentence, String searchWord) {
		String[] words = sentence.split(" ");
		int idx = 1;
		for (String word : words) {
			if (word.indexOf(searchWord) == 0) {
				return idx;
			}
			idx++;
		}
		return -1;
	}

	public static void main(String[] arg) {

		System.out.println(isPrefixOfWord("i love eating burger", "burg"));
		System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
		System.out.println(isPrefixOfWord("i am tired", "you"));
		System.out.println(isPrefixOfWord("hello from the other side", "they"));

	}

}
