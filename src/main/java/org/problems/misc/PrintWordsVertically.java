package org.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/print-words-vertically/
 * 
 * Given a string s. Return all the words vertically in the same order in which
 * they appear in s. Words are returned as a list of strings, complete with
 * spaces when is necessary. (Trailing spaces are not allowed). Each word would
 * be put on only one column and that in one column there will be only one word.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "HOW ARE YOU" Output: ["HAY","ORO","WEU"] Explanation: Each word
 * is printed vertically. "HAY" "ORO" "WEU"
 * 
 * Example 2:
 * 
 * Input: s = "TO BE OR NOT TO BE" Output: ["TBONTB","OEROOE"," T"] Explanation:
 * Trailing spaces is not allowed. "TBONTB" "OEROOE" " T"
 * 
 * Example 3:
 * 
 * Input: s = "CONTEST IS COMING" Output: ["CIC","OSO","N M","T I","E N","S
 * G","T"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 200 s contains only upper case English letters. It's
 * guaranteed that there is only one space between 2 words.
 * 
 */
public class PrintWordsVertically {

	public static List<String> printVertically(String s) {
		String[] words = s.split(" ");
		int n = words.length;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			words[i] = words[i].trim();
			maxLen = Math.max(maxLen, words[i].length());
		}
		int[] pos = new int[n];

		List<String> res = new ArrayList<>();
		for (int j = 0; j < maxLen; j++) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				String word = words[i];
				if (word.length() > pos[i]) {
					sb.append(word.charAt(pos[i]));
					pos[i] ++;
				} else {
					if (i != n - 1)
					sb.append(" ");
				}
			}
			int lastSpace = sb.length();
			while (--lastSpace > -1) {
				if (sb.charAt(lastSpace) == ' ') {
					sb.setLength(lastSpace);
				}else {
					break;
				}
			}
			res.add(sb.toString());
		}
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(printVertically("HOW ARE YOU"));
		System.out.println(printVertically("TO BE OR NOT TO BE"));
		System.out.println(printVertically("CONTEST IS COMING"));

	}

}
