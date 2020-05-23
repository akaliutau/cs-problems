package org.problems.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.problems.utils.Utils;



/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 * 
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 * 
 * If there is no answer, return the empty string. 
 * 
 * Example 1: Input: words =
 * ["w","wo","wor","worl", "world"] 
 * 
 * "w"
 * "wo"
 * "wor"
 * "wos"
 * ...
 * 
 * Output: "world" 
 * 
 * Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * 
 * 
 * 
 */
public class LongestWordInDict {

	public static String longestWord(String[] words) {

		int previousLen = 1;
		Arrays.parallelSort(words);
		Utils.print(words);
		int bestLen = 0;
		String bestWord = "";
		Set<String> preficies = new HashSet<>();
		for (String s : words) {
			preficies.add(s);
		}
		for (String word : words) {
			boolean found = true;
			for (int i = 1; i < word.length(); i++) {
				if (!preficies.contains(word.substring(0,i))){
					found = false;
					break;
				}
			}
			if (found) {
				bestWord = word.length() > bestLen ? word : bestWord;
				bestLen = word.length() > bestLen ? word.length() : bestLen;
			}
		}		
		System.out.println(bestWord);
		return bestWord;
		
        
    }

	public static void main(String[] arg) {

		String[] words = {"w","wo","wor","worl", "world"};
		System.out.println(longestWord(words));

		String[] words1 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(longestWord(words1));

		String[] words2 = {"w", "a", "wo"};
		System.out.println(longestWord(words2));

		String[] words3 = {"w"};
		System.out.println(longestWord(words3));

		String[] words4 = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
		System.out.println(longestWord(words4));

		String[] words5 = {"wsa"};
		System.out.println(longestWord(words5));

		String[] words6 = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
		System.out.println(longestWord(words6));

		String[] words7 = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
		System.out.println(longestWord(words7));
		
		String[] words8 = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
		System.out.println(longestWord(words8));
	}
}
