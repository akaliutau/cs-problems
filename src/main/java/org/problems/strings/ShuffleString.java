package org.problems.strings;

/**
 * https://leetcode.com/problems/shuffle-string/
 * 
 * Given a string s and an integer array indices of the same length.
 * 
 * The string s will be shuffled such that the character at the ith position
 * moves to indices[i] in the shuffled string.
 * 
 * Return the shuffled string.
 * 
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3] Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 * 
 */
public class ShuffleString {

	public static String restoreString(String s, int[] indices) {
		int n = indices.length;
		StringBuilder sb = new StringBuilder();
		char[] c = new char[n];
		for (int i = 0; i < n; i++) {
			c[indices[i]] = s.charAt(i);
		}
		for (int i = 0; i < n; i++) {
			sb.append(c[i]);
		}
		return sb.toString();
	}

	public static void main(String[] arg) {
		
		int[] ind = {4,5,6,7,0,2,1,3};
		System.out.println(restoreString("codeleet",ind));
	}

}
