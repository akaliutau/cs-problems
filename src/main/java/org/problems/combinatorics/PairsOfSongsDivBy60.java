package org.problems.combinatorics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * 
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * 
 * Return the number of pairs of songs for which their total duration in seconds
 * is divisible by 60. Formally, we want the number of indices i, j such that i
 * < j with (time[i] + time[j]) % 60 == 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [30,20,150,100,40] Output: 3 
 * Explanation: Three pairs have a total duration divisible by 60: 
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120 
 * (time[1] = 20, time[4] = 40): total duration 60 
 * 
 * Example 2:
 * 
 * Input: [60,60,60] Output: 3 
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * 
 * 
 * Note:
 * 
 * 1 <= time.length <= 60000 
 * 1 <= time[i] <= 500
 */
public class PairsOfSongsDivBy60 {
	
	static class Stat {
		public int counter = 0;

		@Override
		public String toString() {
			return "Stat [counter=" + counter + "]";
		}
	}

	public static int numPairsDivisibleBy60(int[] time) {
		int n = time.length;
		Map<Integer, Stat> freq = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int duration = time[i] % 60;
			duration = duration == 0 ? 60 : duration;
			if (!freq.containsKey(duration)) {
				freq.put(duration, new Stat());
			}
			freq.get(duration).counter ++;
			System.out.println(time[i] + "->" + duration);
		}
		Set<Integer> all = freq.keySet();
		System.out.println(freq);
		int counter = 0;
		Set<Integer> processed = new HashSet<>();
		for (int d : all) {
			if (processed.contains(d)) {
				continue;
			}
			if (d == 30) {
				int k = freq.get(d).counter;
				counter += k * (k - 1) / 2;
			} else if (d == 60) {
				int k = freq.get(d).counter;
				counter += k * (k - 1) / 2;
			} else {
				int k1 = freq.get(d).counter;
				int d2 = 60 - d;
				if (freq.containsKey(d2)) {
					int k2 = freq.get(d2).counter;
					counter += k1 * k2;
					processed.add(d2);
				}
			}
			processed.add(d);
		}
		return counter;
	}

	public static void main(String[] arg) {
		
		int[] time = {30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(time));

		int[] time1 = {60, 60, 60};
		System.out.println(numPairsDivisibleBy60(time1));
		
		int[] time2 = {418,204,77,278,239,457,284,263,372,279,476,416,360,18};
		System.out.println(numPairsDivisibleBy60(time2));
	}

}
