package com.leetcode.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 *
 * You have a list of words and a pattern, and you want to know which words in
 * words matches the pattern.
 * 
 * A word matches the pattern if there exists a permutation of letters p so that
 * after replacing every letter x in the pattern with p(x), we get the desired
 * word.
 * 
 * (Recall that a permutation of letters is a bijection from letters to letters:
 * every letter maps to another letter, and no two letters map to the same
 * letter.)
 * 
 * Return a list of the words in words that match the given pattern.
 * 
 * You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" 
 * Output: ["mee","aqq"] 
 * Explanation: "mee" matches the pattern because there is a
 * permutation {a -> m, b -> e, ...}. "ccc" does not match the pattern because
 * {a -> c, b -> c, ...} is not a permutation, since a and b map to the same
 * letter.
 * 
 * Note:
 * 
 * 1 <= words.length <= 50 
 * 1 <= pattern.length = words[i].length <= 20
 * 
 * Runtime: 1 ms, faster than 93.73% of Java online submissions for Find and Replace Pattern.
 * Memory Usage: 39.5 MB, less than 7.69% of Java online submissions for Find and Replace Pattern
 */
public class FindAndReplacePattern {
	
	static class Pattern {
		public int[] p;
		
		public Pattern(String s) {
			int[] hist = new int[26];
			for (int i = 0; i < s.length(); i++) {
				hist[s.charAt(i)-'a']++;
			}
			p = new int[s.length()];
			
			int[] processed = new int[26];
			Arrays.fill(processed, -1);
			int code = 0;
			int idx = 0;
			for (int i = 0; i < s.length(); i++) {
				int let = s.charAt(i)-'a';
				if (processed[let] == -1) {
					processed[let] = code;
					p[idx++] = code;
					code++;
				}else {
					p[idx++] = processed[let];
				}
			}			
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(p);
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
			Pattern other = (Pattern) obj;
			if (!Arrays.equals(p, other.p))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Pattern [p=" + Arrays.toString(p) + "]";
		}
		
		
	}
	
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> res = new ArrayList<>();
		Pattern p = new Pattern(pattern);
		System.out.println("Pattern:"+p);
		for (String s : words) {
			Pattern match = new Pattern(s);
			System.out.println(match);
			if (p.equals(match)) {
				res.add(s);
			}
		}
		return res;
        
    }


	public static void main(String[] arg) {
		
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		System.out.println(findAndReplacePattern(words,"abb"));

		String[] words1 = {"badc","abab","dddd","dede","yyxx"};
		System.out.println(findAndReplacePattern(words1,"baba"));

	}
}
