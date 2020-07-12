package org.problems.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Example 1:
 * 
 * Input: str1 = "ABCCABCE", str2 = "ABC" Output: "3" 
 * 
 * Example 3:
 * 
 * Input: str1 = "LEET", str2 = "CODE" Output: "0"
 * 
 * 
 * Note:
 * 
 * 1 <= str1.length <= 1000 
 * 1 <= str2.length <= 1000 
 * str1[i] and str2[i] are English uppercase letters.
 */
public class GreatestCommonSubString {
	
	static class Suffix {
		public final int id;
		public int left;
		public int right;
		public String orig;

		public Suffix(int left, int right, String orig) {
			this.left = left;
			this.right = right;
			this.id = left * 10000 + right;
			this.orig = orig;
		}
		
		public String getString() {
			return orig.substring(left, right + 1);
		}
		
		public Suffix left() {
			if (left > 0) {
				return new Suffix(left - 1, right, orig);
			}
			return null;
		}
		
		public Suffix right() {
			if (right < orig.length() - 1) {
				return new Suffix(left, right + 1, orig);
			}
			return null;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			Suffix other = (Suffix) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Suffix [left=" + left + ", right=" + right + ", orig=" + orig + "]";
		}

	}
	
	static void calcStr(String str, Suffix suffix, Map<Suffix, Integer> lengths) {
		if (suffix == null || lengths.containsKey(suffix)) {
			return;
		}
		String s = suffix.getString();
		if (!str.contains(s)) {
			return;
		}
		lengths.put(suffix, s.length());
		calcStr(str, suffix.left(), lengths);
		calcStr(str, suffix.right(), lengths);
	}
	

	public static int gcs(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		
		if (len1 < len2) {
			String t = str2;
			str2 = str1;
			str1 = t;
		}
		len1 = str1.length();
		len2 = str2.length();
		Map<Suffix, Integer> lengths = new HashMap<>();
		for (int i = 0; i < len2; i++) {
			calcStr(str1, new Suffix(i, i, str2), lengths);
		}
//		System.out.println(lengths);
		int max = 0;
		for (int size : lengths.values()) {
			max = Math.max(max, size);
		}
		return max;

	}

	public static void main(String[] arg) {

		System.out.println(gcs("ABCABAEB","ABAB"));

	}

}
