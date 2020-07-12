package org.problems.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T (T
 * concatenated with itself 1 or more times)
 * 
 * Return the largest string X such that X divides str1 and X divides str2.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: str1 = "ABCABC", str2 = "ABC" Output: "ABC" 
 * 
 * Example 2:
 * 
 * Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB" 
 * 
 * Example 3:
 * 
 * Input: str1 = "LEET", str2 = "CODE" Output: ""
 * 
 * 
 * Note:
 * 
 * 1 <= str1.length <= 1000 
 * 1 <= str2.length <= 1000 
 * str1[i] and str2[i] are English uppercase letters.
 */
public class GreatestCommonDivisorString {
	
	static class Prefix {
		public int right;
		public int len;
		public String orig;

		public Prefix(int right, String orig) {
			this.right = right;
			this.orig = orig;
			this.len = orig.length();
		}
		
		public Set<Integer> getDivisors(){
			Set<Integer> s = new HashSet<>();
			for (int i = 1; i <= len; i++) {
				if (len % i == 0) {
					s.add(i);
				}
			}
			return s;
		}
		
		public boolean isDivisor(String s) {
			return orig.replaceAll(s, "").isEmpty();
		}
		
		public String getString(int right) {
			return orig.substring(0, right);
		}

		@Override
		public String toString() {
			return "Prefix [right=" + right + ", orig=" + orig + "]";
		}

	}
	
	static Set<Integer> getOverlap(Set<Integer> s1, Set<Integer> s2){
		Set<Integer> res = new HashSet<>();
		for (int i1 : s1) {
			if (s2.contains(i1)) {
				res.add(i1);
			}
		}
		return res;
	}
	

	public static String gcdOfStrings(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		if (len1 < len2) {
			String t = str2;
			str2 = str1;
			str1 = t;
		}
		len1 = str1.length();
		len2 = str2.length();
		Prefix p1 = new Prefix(0, str1);
		Prefix p2 = new Prefix(0, str2);
		List<Integer> div = new ArrayList<>(getOverlap(p1.getDivisors(), p2.getDivisors()));
		Collections.sort(div);

		for (int i = div.size() - 1; i > -1; i--) {
			if (p1.isDivisor(p1.getString(div.get(i))) && p2.isDivisor(p1.getString(div.get(i)))) {
				return p1.getString(div.get(i));
			}
		}

		return "";

	}

	public static void main(String[] arg) {

		System.out.println(gcdOfStrings("ABABAB","ABAB"));
		System.out.println(gcdOfStrings("ABCABC","ABC"));
		System.out.println(gcdOfStrings("LEET","AB"));
		System.out.println(gcdOfStrings("LEET","CODE"));

	}

}
