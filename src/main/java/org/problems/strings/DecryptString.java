package org.problems.strings;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * 
 * Given a string s formed by digits ('0' - '9') and '#' . We want to nodes s to
 * English lowercase characters as follows:
 * 
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 * 
 * It's guaranteed that a unique mapping will always exist.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "10#11#12" Output: "jkab" Explanation: "j" -> "10#" , "k" -> "11#"
 * , "a" -> "1" , "b" -> "2". 
 * 
 * Example 2:
 * 
 * Input: s = "1326#" Output: "acz"
 * 
 *  Example 3:
 * 
 * Input: s = "25#" Output: "y" 
 * 
 * Example 4:
 * 
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 * 
 * 
 * 
 */
public class DecryptString {

	public static String freqAlphabets(String s) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while(idx < n) {
			if (idx + 2 < n) {
				if (s.charAt(idx+2) == '#') {
					int val = Integer.valueOf(s.charAt(idx) + "" + s.charAt(idx+1));
					sb.append((char)((val - 10) + 'j'));
					idx += 3;
				}else {
					int val = Integer.valueOf(""+s.charAt(idx));
					sb.append((char)((val - 1) + 'a'));
					idx += 1;
				}
			} else {
				int val = Integer.valueOf(""+s.charAt(idx));
				sb.append((char)((val - 1) + 'a'));
				idx += 1;
			}
		}
		
		return sb.toString();

	}

	public static void main(String[] arg) {

		System.out.println(freqAlphabets("10#11#12"));
		System.out.println(freqAlphabets("1326#"));
		System.out.println(freqAlphabets("25#"));
		System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));

	}

}
