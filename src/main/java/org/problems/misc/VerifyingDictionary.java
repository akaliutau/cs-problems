package org.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 * 
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some
 * permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted
 * lexicographicaly in this alien language.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true Explanation: As 'h' comes before 'l' in this language, then the
 * sequence is sorted. 
 * 
 * Example 2:
 * 
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false Explanation: As 'd' comes after 'l' in this language, the sequence is unsorted. 
 * 
 * Example 3:
 * 
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz" Output:
 * false Explanation: The first three characters "app" match, and the second
 * string is shorter (in size.) According to lexicographical rules "apple" >
 * "app", because 'l' > '∅', where '∅' is defined as the blank character which
 * is less than any other character (More info).
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100 
 * 1 <= words[i].length <= 20 
 * order.length == 26
 * 
 */
public class VerifyingDictionary {
	
	static class Word {
		public String str;
		public int order;

		public Word(int idx, String word) {
			this.str = word;
			this.order = idx;
		}


		@Override
		public String toString() {
			return "Word [str=" + str + "]";
		}
		
	}
	
	static int compare(Word o, Word p, int[] alphabet) {
		int n1 = o.str.length();
		int n2 = p.str.length();
		for (int i = 0; i < n1; i++) {
			if (i >= n2) {
				return 1;
			}
			int c1 = alphabet[o.str.charAt(i)-'a'];
			int c2 = alphabet[p.str.charAt(i)-'a'];
			if (c1 > c2) {
				return 1;
			}else if (c1 < c2) {
				return -1;
			}
		}
		if (n1 < n2) {
			return -1;
		}
		return 0;
		
	}

	public static boolean isAlienSorted(String[] words, String order) {
		
		List<Word> dict = new ArrayList<>();
		int idx = 0;
		for (String word : words) {
			dict.add(new Word(idx++,word));
		}
		int[] alphabet = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabet[order.charAt(i)-'a'] = i;
		}
		Comparator<Word> byOrder = (o,p) -> compare(o, p, alphabet);
		Collections.sort(dict, byOrder);

		for (int i = 0; i < dict.size(); i++) {
			if (dict.get(i).order != i) {
				return false;
			}
		}
		return true;
        
    }

	public static void main(String[] arg) {
		
		String[] d = {"apple","app"};
		System.out.println(isAlienSorted(d, "abcdefghijklmnopqrstuvwxyz"));

		String[] d1 = {"word","world","row"};
		System.out.println(isAlienSorted(d1, "worldabcefghijkmnpqstuvxyz"));

		String[] d2 = {"hello","leetcode"};
		System.out.println(isAlienSorted(d2, "hlabcdefgijkmnopqrstuvwxyz"));

	}

}
