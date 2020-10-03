package org.problems.favourite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given the string s find all substrings of size K with all distinct chars
 * 
 */
public class DistinctSubstrings {
	
	public static List<String> countAllDistinctSubstrings(String s, int k){
        int[] index = new int[26];
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<String> res = new HashSet<>();
        
        int left = 0;
        for (int right = 0; right < n; right++){
            char cur = chars[right];
            // index['a'] contains the most left position when 'a' has been seen
        	left = Math.max(index[cur - 'a'], left);
            String substr = s.substring(left, right + 1);
            if (right - left + 1 == k && !res.contains(substr)) {
                res.add(substr);
                left ++;
            }
            index[cur - 'a'] = right + 1;
        }
        
        return new ArrayList<>(res);
    }

	public static void main(String[] arg) {
	    //     a b c a b c
	    
	    //     |     |
	    //
		System.out.println(countAllDistinctSubstrings("abcabc", 3));
		
		
		System.out.println(countAllDistinctSubstrings("abacab", 3));
		System.out.println(countAllDistinctSubstrings("awaglknagawunagwkwagl", 4));

	}

}
