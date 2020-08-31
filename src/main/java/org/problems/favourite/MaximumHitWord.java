package org.problems.favourite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hit list
 * 
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * 
 */
public class MaximumHitWord {

	static class Word {
		public String w;
		public int freq = 0;

		public Word(String w) {
			this.w = w.trim().toLowerCase();
		}

	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		paragraph = paragraph.replace("!", " ").replace("?", " ").replace("'", " ").replace(",", " ").replace(";", " ")
				.replace(".", " ");
		String[] words = paragraph.split(" ");

		Map<String, Word> wordMap = new HashMap<>();
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
		Comparator<Word> byFreq = (o, p) -> Integer.compare(p.freq, o.freq);
		List<Word> allWords = new ArrayList<>(wordMap.values());
		allWords.sort(byFreq);
		return allWords.isEmpty() ? "" : allWords.get(0).w;

	}

	public static void main(String[] arg) {
		
		String[] banned = {"hit"};

		System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", banned));

	}

}
