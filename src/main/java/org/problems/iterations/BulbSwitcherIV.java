package org.problems.iterations;

/**
 * https://leetcode.com/problems/bulb-switcher-iv/
 * 
 * There is a room with n bulbs, numbered from 0 to n-1, arranged in a row from
 * left to right. Initially all the bulbs are turned off.
 * 
 * Your task is to obtain the configuration represented by target where
 * target[i] is '1' if the i-th bulb is turned on and is '0' if it is turned
 * off.
 * 
 * You have a switch to flip the state of the bulb, a flip operation is defined
 * as follows:
 * 
 * Choose any bulb (index i) of your current configuration. Flip each bulb from
 * index i to n-1. When any bulb is flipped it means that if it is 0 it changes
 * to 1 and if it is 1 it changes to 0.
 * 
 * Return the minimum number of flips required to form target.
 * 
 * Example 1:
 * 
 * Input: target = "10111" Output: 3 
 * Explanation: Initial configuration "00000".
 * flip from the third bulb: "00000" -> "00111" flip from the first bulb:
 * "00111" -> "11000" flip from the second bulb: "11000" -> "10111" We need at
 * least 3 flip operations to form target.
 * 
 */
public class BulbSwitcherIV {

	public static int minFlips(String target) {
		int n = target.length();
		int counter = 0;
		char c = target.charAt(0);
		int start = 1;
		if (target.charAt(0) == '1') {
			counter = 1;
		} else {
			for (int i = 1; i < n; i++) {
				if (target.charAt(i) == '1') {
					counter = 1;
					start = i + 1;
					c = target.charAt(i);
					break;
				}
			}
		}
		for (int i = start; i < n; i++) {
			if (target.charAt(i) != c) {
				counter++;
			}
			c = target.charAt(i);
		}
		return counter;
	}

	public static void main(String[] arg) {
		System.out.println(minFlips("10111"));
	}

}
