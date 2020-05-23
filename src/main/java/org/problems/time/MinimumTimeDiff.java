package org.problems.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-difference/
 * 
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list.
 * 
 * Example 1: Input: ["23:59","00:00"] Output: 1
 * 
 * Note: The number of time points in the given list is at least 2 and won't
 * exceed 20000. The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 
 */
public class MinimumTimeDiff {

	static int getTime(String time) {
		String[] parts = time.split(":");
		int t = 60 * Integer.valueOf(parts[0]) + Integer.valueOf(parts[1]);
		return t;
	}

	public static int findMinDifference(List<String> timePoints) {

        List<Integer> moments = new ArrayList<>();
        
        for(String time : timePoints) {
            moments.add(getTime(time));
        }
        
        Collections.sort(moments);
        moments.add(moments.get(0)); 
        
        int diff = 1441;
        for(int i = 1; i < moments.size(); i++) {
            diff = Math.min(diff, Math.abs(moments.get(i - 1) - moments.get(i))); 
            //complementary times
            diff = Math.min(diff, 1440 - Math.abs(moments.get(i - 1) - moments.get(i)));
        }
        
        return diff;
	}

	public static void main(String[] arg) {

		List<String> lst = Arrays.asList("00:00", "23:59");
		System.out.println(findMinDifference(lst));// 1

		List<String> lst0 = Arrays.asList("23:59", "00:00");
		System.out.println(findMinDifference(lst0));// 1

		List<String> lst1 = Arrays.asList("12:12", "00:13");
		System.out.println(findMinDifference(lst1));// 719

		List<String> lst3 = Arrays.asList("05:31", "22:08", "00:35");
		System.out.println(findMinDifference(lst3));// 147

	}
}
