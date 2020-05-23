package org.problems.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-subsets/
 * 
 * We are given two arrays A and B of words. Each word is a string of lowercase
 * letters.
 * 
 * Now, say that word b is a subset of word a if every letter in b occurs in a,
 * including multiplicity. For example, "wrr" is a subset of "warrior", but is
 * not a subset of "world".
 * 
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * 
 * Return a list of all universal words in A. You can return the words in any
 * order.
 * 
 * Example 1:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"] 
 * 
 * Example 2:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"] 
 * 
 * Example 3:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"] 
 * 
 * Example 4:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"] 
 * 
 * Example 5:
 * 
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B =
 * ["ec","oc","ceo"] Output: ["facebook","leetcode"]
 * 
 */
public class WordSubsets {
	
	static class FootPrint {
		public int id;
		public int[] fp = new int[26];
		public String word;
	
		public FootPrint(int id, String word) {
			this.id = id;
			this.word = word;
			for (int i = 0; i < word.length(); i++) {
				fp[word.charAt(i)-'a']++;
			}
		}
		
		public boolean isSubset(FootPrint fp) {
			for (int i = 0; i < 26; i++) {
				if (this.fp[i] <= fp.fp[i]) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}
		
		public void merge(FootPrint fp) {
			for (int i = 0; i < 26; i++) {
				this.fp[i] =  this.fp[i] < fp.fp[i] ? fp.fp[i] : this.fp[i];
			}			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((word == null) ? 0 : word.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FootPrint other = (FootPrint) obj;
			if (word == null) {
				if (other.word != null)
					return false;
			} else if (!word.equals(other.word))
				return false;
			return true;
		}		
	}
	
	
	public static List<String> wordSubsets(String[] a, String[] b) {
		List<String> res = new ArrayList<>();
		Set<FootPrint> aSet = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			aSet.add(new FootPrint(i,a[i]));
		}
		FootPrint maxWord = new FootPrint(0,b[0]);
		for (int i = 1; i < b.length; i++) {
			maxWord.merge(new FootPrint(i,b[i]));
		}
		
		for (FootPrint afp : aSet) {
			if (maxWord.isSubset(afp)) {
				res.add(afp.word);
			}
		}
		return res;
    }

	public static void main(String[] arg) {

		String[] a = {"amazon","apple","facebook","google","leetcode"};
		String[] b = {"e","o"};
		System.out.println(wordSubsets(a, b));

		String[] a1 = {"amazon","apple","facebook","google","leetcode"};
		String[] b1 = {"l","e"};
		System.out.println(wordSubsets(a1, b1));

		String[] a2 = {"amazon","apple","facebook","google","leetcode"};
		String[] b2 = {"e","oo"};
		System.out.println(wordSubsets(a2, b2));

		String[] a3 = {"amazon","apple","facebook","google","leetcode"};
		String[] b3 = {"eo","lo"};
		System.out.println(wordSubsets(a3, b3));

	}
}
