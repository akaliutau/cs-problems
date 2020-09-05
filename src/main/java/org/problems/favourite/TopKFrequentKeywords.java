package org.problems.favourite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Top K Frequent Keywords
 * 
 * 
 */
public class TopKFrequentKeywords {

	static class Word {
		public String word;
		public int freq;

		public Word(String word, int freq) {
			this.word = word;
			this.freq = freq;
		}
	}

	public static List<String> getFrequent(int k, String[] keywords, String[] revs) {
		Map<String, Word> stat = new HashMap<>();
		Set<String> keywordsList = new HashSet<>(Arrays.asList(keywords).stream().map(s -> s.trim().toLowerCase()).collect(Collectors.toList()));
		for (String line : revs) {
		    Set<String> processed = new HashSet<>();
			for (String s : line.toLowerCase().split("\\s+")) {
				if (!processed.contains(s) && keywordsList.contains(s)) {
					if (!stat.containsKey(s)) {
						stat.put(s, new Word(s, 0));
					}
					stat.get(s).freq++;
					processed.add(s);
				}
			}
		}

		Comparator<Word> byFreq = (o,p) -> Integer.compare(o.freq, p.freq);
		Comparator<Word> byName = (o,p) -> o.word.compareTo(p.word);
		List<Word> all = new ArrayList<>(stat.values());
		Collections.sort(all, byFreq.thenComparing(byName));

		return all.subList(0, k).stream().map(w -> w.word).collect(Collectors.toList());
	}

	public static void main(String[] arg) {
		
		String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};

		String[] revs = {"I love anacell Best services; Best services provided by anacell",
				  "betacellular has great services",
				  "deltacellular provides much better services than betacellular",
				  "cetracular is worse than anacell",
				  "Betacellular is better than deltacellular."};
		System.out.println(getFrequent(2, keywords, revs));

	}

}
