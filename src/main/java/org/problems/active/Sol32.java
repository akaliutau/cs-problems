package org.problems.active;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 */
public class Sol32 {
	
	static class Stacked {
		public Stack<Integer> stack = new Stack<>();
		public int count = 0;
		
		public Stacked() {
			stack.add(0);
		}
	}
	
	public static int findTheLongestSubstring(String s) {
		int total = 0;
		// arrays of best positions
		Stacked[] stacks = new Stacked[5];
		stacks[0] = new Stacked();
		stacks[1] = new Stacked();
		stacks[2] = new Stacked();
		stacks[3] = new Stacked();
		stacks[4] = new Stacked();
		
		Map<Character,Integer> map = new HashMap<>();
		map.put('a', 0);
		map.put('e', 1);
		map.put('i', 2);
		map.put('o', 3);
		map.put('u', 4);
		
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				Stacked letter = stacks[map.get(c)];
				letter.count++;
				letter.stack.add(j);
			}
		}
		boolean found = false;
		// search
		while(!found ) {
			int index = s.length()-1;
			for (int i = 0; i < 5; i++) {
				Stacked letter = stacks[i];
			}
		}
		// find the best [left,right] for each Vowel, if not present - [0,len-1]
		// the best interval must:
		// 1) include ALL
		// 2) exclude SOME
		
		return 0;
        
    }


	public static void main(String[] arg) {

		System.out.println(findTheLongestSubstring("eleetminicoworoep"));//13
		System.out.println(findTheLongestSubstring("leetcodeisgreat"));//5
		System.out.println(findTheLongestSubstring("bcbcbc"));//6
		

	}

}
