package org.problems.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/rearrange-words-in-a-sentence/
 * 
 * Given a sentence text (A sentence is a string of space-separated words) in
 * the following format:
 * 
 * First letter is in upper case. Each word in text are separated by a single
 * space. Your task is to rearrange the words in text such that all words are
 * rearranged in an increasing order of their lengths. If two words have the
 * same length, arrange them in their original order.
 * 
 * Return the new text following the format shown above
 * 
 */
public class RearrangeWords {

	static class Word {
		public String w;
		public int len;

		public Word(String w) {
			this.w = w;
			len = w.length();
		}

	}

	public static String arrangeWords(String text) {

		String[] words = text.split(" ");
		if (words.length == 0) {
			return "";
		}
		if (text.equals(" ")) {
			return " ";
		}
		Comparator<String> byLen = (o, p) -> Integer.compare(o.length(), p.length());
		Arrays.sort(words, byLen);
		String result = String.join(" ", words).toLowerCase();
		if (result.length() == 0) {
			return "";
		}
		char first = result.charAt(0);
		int code = first - 'a';
		char conv = (char) (code + 'A');
		return conv + result.substring(1);
	}

	public static void main(String[] arg) {

		System.out.println(arrangeWords("Leetcode is cool"));
		System.out.println(arrangeWords("Keep calm and code on"));
		System.out.println(arrangeWords("To be or not to be"));
		System.out.println(arrangeWords(""));
		System.out.println(arrangeWords(" "));

	}

}
