package org.problems.strings;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/long-pressed-name/
 *
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" Output: true 
 * Explanation: 'a' and 'e' in 'alex' were long pressed. 
 * 
 * Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false 
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output. 
 * 
 * Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true
 * 
 */
public class LongPressedName {
	
	public static void getFingerPrint(String name, int[][] nameFP) {
		int j = -1;
		int sym = 0;
		for (int i = 0; i < name.length(); i++) {
			int c = name.charAt(i);
			if (sym != c) {
				j++;
				sym = c;
				nameFP[j][0] = c;
			}
			nameFP[j][1] ++;
		}
	}

	public static boolean isLongPressedName(String name, String typed) {
		boolean res = false;
		int[][] nameFP = new int[name.length()][2];
		getFingerPrint(name, nameFP);
		int[][] typedFP = new int[typed.length()][2];
		getFingerPrint(typed, typedFP);

		if (typedFP.length < nameFP.length) {
			return false;
		}
		int idx = 0;
		for (int i = 0; i < nameFP.length; i++) {
			if (typedFP[i][0] != nameFP[i][0] || typedFP[i][1] < nameFP[i][1]) {
				return false;
			}
			if (nameFP[i][0] == 0) {
				break;
			}
			idx++;
		}
		if (idx < typedFP.length && typedFP[idx][0] != 0) {
			return false;
		}
		return true;
		
	}
	
	
	public static void main(String[] arg) {

		
		System.out.println(isLongPressedName("alex","aaleex"));
		System.out.println(isLongPressedName("saeed","ssaaedd"));
		System.out.println(isLongPressedName("leelee","lleeelee"));
		System.out.println(isLongPressedName("laiden","laiden"));
		System.out.println(isLongPressedName("","ssaaedd"));
		System.out.println(isLongPressedName("saeed",""));

	}
}
