package org.problems.sets;

import java.util.HashSet;
import java.util.Set;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * 
 * We are given two sentences A and B. (A sentence is a string of space
 * separated words. Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words.
 * 
 * You may return the list in any order.
 * 
 * Example 1:
 * 
 * Input: A = "this apple is sweet", B = "this apple is sour" Output:
 * ["sweet","sour"] 
 * 
 * Example 2:
 * 
 * Input: A = "apple apple", B = "banana" Output: ["banana"]
 * 
 * 
 * Note:
 * 
 * 0 <= A.length <= 200 
 * 0 <= B.length <= 200 
 * A and B both contain only spaces and lowercase letters.
 * 
 */
public class UncommonWords {

	public static String[] uncommonFromSentences(String a, String b) {
		Set<String> setA = new HashSet<>();
		Set<String> setDup = new HashSet<>();
		String[] allinA = a.split(" ");
		for (String word : allinA) {
			if (word.length() > 0) {
				if (setA.contains(word)) {
					setDup.add(word);
				}
				setA.add(word);
			}
		}
		Set<String> setB = new HashSet<>();
		String[] allinB = b.split(" ");
		for (String word : allinB) {
			if (word.length() > 0) {
				if (setB.contains(word)) {
					setDup.add(word);
				}
				setB.add(word);
			}
		}
		System.out.println("res="+setA);
		System.out.println("res="+setB);
		Set<String> result = new HashSet<>();
		for (String word : setB) {
			if (!setA.contains(word)) {
				result.add(word);
			}else {
				setA.remove(word);
			}
		}	
		System.out.println("res="+result);
		System.out.println("dup="+setDup);
		result.addAll(setA);
		result.removeAll(setDup);
		return result.toArray(new String[result.size()]);

	}

	public static void main(String[] arg) {

		Utils.print(uncommonFromSentences("this apple is sweet","this apple is sour"));
		Utils.print(uncommonFromSentences("apple apple","banana"));

	}

}
