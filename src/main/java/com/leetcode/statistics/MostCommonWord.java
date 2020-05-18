package com.leetcode.statistics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/
 * 
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * Example:
 * 
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3 times, but it is
 * a banned word. "ball" occurs twice (and no other word does), so it is the
 * most frequent non-banned word in the paragraph. Note that words in the
 * paragraph are not case sensitive, that punctuation is ignored (even if
 * adjacent to words, such as "ball,"), and that "hit" isn't the answer even
 * though it occurs more because it is banned
 * 
 * Note:
 * 
 * 1 <= paragraph.length <= 1000. 
 * 0 <= banned.length <= 100. 
 * 1 <= banned[i].length <= 10. 
 * The answer is unique, and written in lowercase (even
 * if its occurrences in paragraph may have uppercase symbols, and even if it is
 * a proper noun.) paragraph only consists of letters, spaces, or the
 * punctuation symbols !?',;. There are no hyphens or hyphenated words. Words
 * only consist of letters, never apostrophes or other punctuation symbols.
 * 
 */
public class MostCommonWord {
	
	static class Word {
		public String w;
		public int freq = 0;
		
		public Word(String w) {
			this.w = w.trim().toLowerCase();
		}

		@Override
		public String toString() {
			return "Word [w=" + w + ", freq=" + freq + "]";
		}
		
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.replace("!", " ").replace("?", " ").replace("'", " ").replace(",", " ").replace(";", " ").replace(".", " ");
		String[] words = paragraph.split(" ");
		
		Map<String,Word> wordMap = new HashMap<>();
		Set<String> banSet = new HashSet<>();
		for (String s : banned) {
			banSet.add(s.trim().toLowerCase());
		}
		
		for (String s : words) {
			if (s.isEmpty()) {
				continue;
			}
			Word word = new Word(s);
			if (!banSet.contains(word.w)) {
				if (!wordMap.containsKey(word.w)) {
					wordMap.put(word.w, word);
				}
				wordMap.get(word.w).freq++;
			}
		}	
		Comparator<Word> byFreq = (o,p) -> Integer.compare(p.freq, o.freq);
		List<Word> allWords = new ArrayList<>(wordMap.values());
		allWords.sort(byFreq);
		System.out.println(allWords);
		return allWords.isEmpty() ? "" : allWords.get(0).w;
        
    }

	public static void main(String[] arg) {

		String[] banned = {"hit"};
		System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));

		String[] banned1 = {"bob","hit"};
		System.out.println(mostCommonWord("Bob. hIt, baLl.",banned1));

	}

}
