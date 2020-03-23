package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters. You may
 * assume no duplicates in the word list. You may assume beginWord and endWord
 * are non-empty and are not the same. Example 1:
 * 
 * Input: beginWord = "hit", endWord = "cog",
 * 
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is 
 * 
 * "hit" -> "hot" -> "dot" ->"dog" -> "cog"
 * 
 *  return its length 5.
 * 
 * 
 */
public class WordLadder {

	static int getShortestLen(String startWord, String finalWord, Set<String> dict) {

		if (!dict.contains(finalWord))
			return -1;

		int level = 1;

		Queue<String> queue = new LinkedList<>();
		queue.add(startWord);
		// queue: hit
		while (!queue.isEmpty()) {

			List<String> block = new ArrayList<>();
			while (!queue.isEmpty()) {
				char[] word = queue.remove().toCharArray();
				// queue: word ="hit"
				
				// this block used to generate a new set of words which are:
				// 1) differ by 1 letter
				// 2) in dictionary
				for (int pos = 0; pos < startWord.length(); pos++) {
					char cur = word[pos];

					// check 26 variants except those which are not in dictionary
					// f.e. 
					for (char c = 'a'; c <= 'z'; c++) {
						word[pos] = c;

						if (String.valueOf(word).equals(finalWord)) {
							return level+1;
						}

						if (!dict.contains(String.valueOf(word))) {
							continue;
						}
						
						dict.remove(String.valueOf(word));
						block.add(String.valueOf(word));
					}
					// restore word
					word[pos] = cur;
				}
				// process all words on current level
			}
			queue.addAll(block);
			level++;
		}

		return -1;
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		

		int len = getShortestLen(beginWord, endWord, new HashSet<String>(wordList));
		if (len == -1) {
			return 0;
		}
		return len;

	}

	public static void main(String[] arg) {
		
		List<String> dict = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(ladderLength("hit", "cog", dict));

		List<String> dict1 = Arrays.asList("hot","hat","hit");
		System.out.println(ladderLength("hat", "hit", dict1));

		List<String> dict2 = Arrays.asList("hot","dot","dog","lot","log");
		System.out.println(ladderLength("hit", "cog", dict2));

		List<String> dict3 = Arrays.asList("a","b","c");
		System.out.println(ladderLength("a", "c", dict3));

		List<String> dict4 = Arrays.asList("hot","dot","dog");
		System.out.println(ladderLength("hot", "dog", dict4));


	}
}
