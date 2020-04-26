package com.leetcode.strings;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/expressive-words/
 * 
 * Sometimes people repeat letters to represent extra feeling, such as "hello"
 * -> "heeellooo", "hi" -> "hiiii". In these strings like "heeellooo", we have
 * groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
 * 
 * For some given string S, a query word is stretchy if it can be made to be
 * equal to S by any number of applications of the following extension
 * operation: choose a group consisting of characters c, and add some number of
 * characters c to the group so that the size of the group is 3 or more.
 * 
 * For example, starting with "hello", we could do an extension on the group "o"
 * to get "hellooo", but we cannot get "helloo" since the group "oo" has size
 * less than 3. Also, we could do another extension like "ll" -> "lllll" to get
 * "helllllooo". If S = "helllllooo", then the query word "hello" would be
 * stretchy because of these two extension operations: query = "hello" ->
 * "hellooo" -> "helllllooo" = S.
 * 
 * Given a list of query words, return the number of words that are stretchy.
 * 
 * 
 * 
 * Example: Input: S = "heeellooo" words = ["hello", "hi", "helo"] Output: 1
 * Explanation: We can extend "e" and "o" in the word "hello" to get
 * "heeellooo". We can't extend "helo" to get "heeellooo" because the group "ll"
 * is not size 3 or more.
 * 
 * 
 * Notes:
 * 
 * 0 <= len(S) <= 100. 
 * 0 <= len(words) <= 100. 
 * 0 <= len(words[i]) <= 100. S and all words in words consist only of lowercase letters
 * 
 * 
 */
public class ExpressiveWords {
	
	static class Pattern {
		public int[][] str;
		public int idx;
		
		public Pattern(String s) {
			int l = s.length();
			str = new int[l][2];
			idx = -1;
			int prev = -1;
			if (l != 0) {
				for (int i = 0; i < l; i++) {
					int cur = s.charAt(i);
					if (cur != prev) {
						idx ++;
						str[idx][0] = cur; 
					}
					str[idx][1] ++;
					prev = cur;
				}
			}
		}
		
	}
	

	public static int expressiveWords(String s, String[] words) {
		int l = s.length();
		Pattern str = new Pattern(s);
		int counter = 0;
//		System.out.println("========");
//		Utils.print(str.str);
		for (String word : words) {
//			System.out.println("========");
			Pattern p = new Pattern(word);
//			Utils.print(p.str);
			if (p.idx != str.idx) {
				continue;
			}
			boolean  valid = true;
			for (int i = 0; i <= str.idx; i++) {
				if (str.str[i][0] != p.str[i][0]) {
					valid = false;
					break;
				}
				// comparable symbols are equal
				if (str.str[i][1] == p.str[i][1] || (str.str[i][1] > p.str[i][1] && str.str[i][1] >= 3)) {
					continue;
				}else {
					valid = false;
					break;
				}
			}
			if (valid) {
//				System.out.println("--"+word);
				counter++;
			}
		}
		
		
		return counter;

	}

	public static void main(String[] arg) {

		String[] words = {"hello", "hi", "helo"};
		System.out.println(expressiveWords("heeellooo",words));

		String[] words1 = {"", "hi", "helo"};
		System.out.println(expressiveWords("heeellooo",words1));

		String[] words2 = {"hello", "", "helo"};
		System.out.println(expressiveWords("",words2));

		String[] words3 = {"aaaaa"};
		System.out.println(expressiveWords("aaa",words3));

	}

}
