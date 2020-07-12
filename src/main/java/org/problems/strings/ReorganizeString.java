package org.problems.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 * 
 * If possible, output any possible result. If not possible, return the empty
 * string.
 * 
 * Example 1:
 * 
 * Input: S = "aab" Output: "aba" 
 * Example 2:
 * 
 * Input: S = "aaab" Output: "" Note:
 * 
 * S will consist of lowercase letters and have length in range [1, 500]
 * 
 *  1) count number of blocks [xx]
 *  2) counter number of seeds
 */
public class ReorganizeString {
	
	
	static boolean valid(char[] str, int n) {
		for (int i = 1; i < n; i++) {
			if (str[i - 1] == str[i]) {
				return false;
			}
		}
		return true;
	}
	
	static String update(char[] str, int n) {
		for (int i = 2; i < n; i++) {
			if (str[i - 1] == str[i] && str[i - 2] != str[i]) {
				char c = str[i - 1];
				str[i - 1] = str[i - 2];
				str[i - 2] = c;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str[i]);
		}

		return sb.toString();
	}

	
	static class Letter {
		public int counter;
		public char c;
		
		public Letter(int counter, char c) {
			this.counter = counter;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Letter [counter=" + counter + ", c=" + c + "]";
		}
		
	}
	
	static String processString(String s) {
		int n = s.length();
		char[] str1 = s.toCharArray();
		
		int[] distr = new int[26];
		
		
		for (int i = 0; i < n; i++) {
			distr[str1[i] - 'a'] ++;
		}
		
		int index = 0;
		int counter = 0;
		for (int i = 0; i < 26; i++) {
			if (distr[i] > 0) {
				counter ++;
			}
		}	
		Letter[] let = new Letter[counter];
		for (int i = 0; i < 26; i++) {
			if (distr[i] > 0) {
				let[index ++] = new Letter(distr[i], (char)('a' + i));
			}
		}
		Arrays.parallelSort(let, (o,p) -> Integer.compare(p.counter, o.counter));
		int idx1 = 0;
		int idx2 = 1;
		StringBuilder sb = new StringBuilder();
//		System.out.println(Arrays.toString(let));
		char last = ' ';
		while (idx1 < counter && idx2 < counter) {
			Letter l1 = let[idx1];
			Letter l2 = let[idx2];
			if (l1.c == last) {
				Letter t = l1;
				l1 = l2;
				l2 = t;
			}
			if (l1.counter > 1) {
				if (l2.counter > 0) {
					sb.append(l1.c);
					sb.append(l2.c);
					l1.counter --;
					l2.counter --;
					last = l2.c;
				}else {
					idx2 ++;
				}
			}else {
				idx1 ++;
				idx2 ++;
			}
			
		}
		
		for (Letter l : let) {
			while (l.counter -- > 0) {
				sb.append(l.c);
			}
		}
		s = sb.toString();
		int down = n / 2;
		while (down -- > 0) {
			String next = update(s.toCharArray(), n);
			if (next.equals(s)) {
				break;
			}
			s = next;
		}
		System.out.println(s);
		return valid (s.toCharArray(), n) ? s : "";

	}
	

	public static String reorganizeString(String s) {
		String res = processString(s);
		return res;
	}

	public static void main(String[] arg) {

		System.out.println(reorganizeString("a"));
		System.out.println(reorganizeString("aa"));//n
		System.out.println(reorganizeString("ab"));
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));//n
		System.out.println(reorganizeString("aaabb"));
		System.out.println(reorganizeString("aaadaaabcdb"));
		System.out.println(reorganizeString("aaaaabcdb"));
		System.out.println(reorganizeString("aaaabcdb"));

		System.out.println(reorganizeString("baaba"));
		System.out.println(reorganizeString("baabaab"));
		System.out.println(reorganizeString("babdaaaaba"));
		System.out.println(reorganizeString("zqugrfbsznyiwbokwkpvpmeyvaosdkedbgjogzdpwawwl"));
		System.out.println(reorganizeString("zrhmhyevkojpsegvwolkpystdnkyhcjrdvqtyhucxdcwm"));
		System.out.println(reorganizeString("nlmxhnpifuaxinxpxlcttjnlggmkjioewbecnofqpvcikiazmn"));
	}

}
