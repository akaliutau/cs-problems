package org.problems.strings;

/**
 * https://leetcode.com/problems/buddy-strings/
 * 
 * Given two strings A and B of lowercase letters, return true if and only if we
 * can swap two letters in A so that the result equals B.
 * 
 * Example 1:
 * Input: A = "ab", B = "ba" Output: true 
 * 
 * Example 2:
 * Input: A = "ab", B = "ab" Output: false 
 * 
 * Example 3:
 * Input: A = "aa", B = "aa" Output: true 
 * 
 * Example 4:
 * Input: A = "aaaaaaabc", B = "aaaaaaacb" Output: true 
 * 
 * Example 5:
 * Input: A = "", B = "aa" Output: false
 * 
 * 
 * Note:
 * 
 * 0 <= A.length <= 20000 
 * 0 <= B.length <= 20000 
 * A and B consist only of
 * lowercase letters
 * 
 */
public class BuddyStrings {

	public static boolean buddyStrings(String a, String b) {
		int n = a.length();
		if (n != b.length()) {
			return false;
		}
		int diff = 0;
		char[] set1 = new char[26];
		char[] set2 = new char[26];
		char[] dist = new char[26];
		for (int i = 0; i < n; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff ++;
				set1[a.charAt(i) - 'a'] ++;
				set2[b.charAt(i) - 'a'] ++;
			}
			dist[a.charAt(i) - 'a'] ++;
			if (diff > 2) {
				return false;
			}
		}
		if (diff == 2) {
			for (int i = 0; i < 26; i++) {
				if (set1[i] != set2[i]) {
					return false;
				}
			}
			return true;
		}else if (diff == 0) {
			for (int i = 0; i < 26; i++) {
				if (dist[i] > 1) {
					return true;
				}
			}
			return false;
			
		}
		return false;

	}

	public static void main(String[] arg) {

		System.out.println(buddyStrings("ab","ba"));
		System.out.println(buddyStrings("ab","ab"));
		System.out.println(buddyStrings("aa","aa"));
		System.out.println(buddyStrings("aaaaaaabc","aaaaaaacb"));
		System.out.println(buddyStrings("a","aa"));

	}

}
