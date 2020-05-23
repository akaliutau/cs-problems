package org.problems.strings;

import java.util.List;

/**
 * https://leetcode.com/problems/consecutive-characters/
 * 
 * Given a string s, the power of the string is the maximum length of a
 * non-empty substring that contains only one unique character.
 * 
 * Return the power of the string.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode" Output: 2 Explanation: The substring "ee" is of length
 * 2 with the character 'e' only
 */
public class ConsecutiveCharacters {
	
	public static int maxPower(String s) {
        int[] dist = new int[256];
        int[] peak = new int[256];
        if (s.length() == 0) {
        	return 0;
        }
        if (s.length() == 1) {
        	return 1;
        }
        char prev = s.charAt(0);
        dist[prev] = 1;
        for (int i = 1; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	if (prev != cur) {
        		peak[prev] = Math.max(peak[prev], dist[prev]);
        		dist[prev] = 0;
        		dist[cur] ++;
        	}else {
        		dist[prev] ++;
        	}
       	 	prev = cur;
        }
        //dist[prev] ++;
   		peak[prev] = Math.max(peak[prev], dist[prev]);
   	         
        int max = 0;
        for (int i = 0; i < 256; i++) {
        	max = Math.max(max,peak[i]);
        }
        return max;
	}

	public static void main(String[] arg) {

		System.out.println(maxPower("leetcode"));
		System.out.println(maxPower("abbcccddddeeeeedcba"));
		System.out.println(maxPower("triplepillooooow"));
		System.out.println(maxPower("hooraaaaaaaaaaay"));
		System.out.println(maxPower("tourist"));
		System.out.println(maxPower("w"));
		System.out.println(maxPower("ww"));
		System.out.println(maxPower("corona"));

	}

}

