package org.problems.favourite;

import java.util.ArrayList;
import java.util.List;

/**
 * Partitioning String
 * 
 * Given a string S of lowercase letters, partition S into as many as parts so
 * that one letter only appear in one part. Return the partitions as a list.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * S = “bbeadcxede”
 * 
 * Output:
 * 
 * [“bb”, “eadcxede”]
 * 
 * Example 2:
 * 
 * Input:
 * 
 * S = “baddacx”
 * 
 * Output:
 * 
 * [“b”, “adda", “c”, “x”]
 * 
 */
public class PartitioningString {
	
	public static List<String> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int start = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(s.substring(start, i + 1));
                start = i + 1;
            }
        }
        return ans;
    }

	public static void main(String[] arg) {
		System.out.println(partitionLabels("bbeadcxede"));
		System.out.println(partitionLabels("baddacx"));
	}

}
