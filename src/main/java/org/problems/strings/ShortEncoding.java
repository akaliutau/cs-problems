package org.problems.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 * 
 * Given a list of words, we may encode it by writing a reference string S and a
 * list of indexes A.
 * 
 * For example, if the list of words is ["time", "me", "bell"], we can write it
 * as S = "time#bell#" and indexes = [0, 2, 5].
 * 
 * Then for each index, we will recover the word by reading from the reference
 * string from that index until we reach a "#" character.
 * 
 * What is the length of the shortest reference string S possible that encodes
 * the given words?
 * 
 * Example:
 * 
 * Input: words = ["time", "me", "bell"] Output: 10
 * 
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * 
 * 
 * Note:
 * 
 * 1 <= words.length <= 2000. 1 <= words[i].length <= 7. Each word has only
 * lowercase letters.
 * 
 * 
 */
public class ShortEncoding {

	public static int minimumLengthEncoding(String[] words) {
		int n = words.length;
		Set<String> suffix = new HashSet<>(Arrays.asList(words));
		for (String word : words) {
            int len = word.length();
			for (int k = 1; k < len; ++k) {
				suffix.remove(word.substring(k));
			}
		}

		int res = 0;
		for (String word : suffix) {
			res += word.length() + 1;
		}
		return res;
	}

	public static void main(String[] arg) {

		String[] words = { "time", "me", "bell" };
		System.out.println(minimumLengthEncoding(words));

	}

}
