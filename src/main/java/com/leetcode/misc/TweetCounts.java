package com.leetcode.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/tweet-counts-per-frequency/
 *
 * Implement the class TweetCounts that supports two methods:
 * 
 * 1. recordTweet(string tweetName, int time)
 * 
 * Stores the tweetName at the recorded time (in seconds). 2.
 * getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int
 * endTime)
 * 
 * Returns the total number of occurrences for the given tweetName per minute,
 * hour, or day (depending on freq) starting from the startTime (in seconds) and
 * ending at the endTime (in seconds). freq is always minute, hour or day,
 * representing the time interval to get the total number of occurrences for the
 * given tweetName. The first time interval always starts from the startTime, so
 * the time intervals are [startTime, startTime + delta*1>, [startTime +
 * delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>,
 * ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)> for
 * some non-negative number i and delta (which depends on freq).
 * 
 * Runtime: 151 ms, faster than 33.33% of Java online submissions for Tweet
 * Counts Per Frequency. Memory Usage: 51.8 MB, less than 100.00% of Java online
 * submissions for Tweet Counts Per Frequency.
 */
public class TweetCounts {
	Map<String, List<Integer>> fMap = new HashMap<>();

	public TweetCounts() {

	}

	public void recordTweet(String tweetName, int time) {
		if (!fMap.containsKey(tweetName)) {
			fMap.put(tweetName, new ArrayList<>());
		}
		fMap.get(tweetName).add(time);
	}

	public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

		List<Integer> hist = new LinkedList<>();
		int step = 0;
		if (freq.equals("minute")) {
			step = 60;
		} else if (freq.equals("hour")) {
			step = 3600;
		} else if (freq.equals("day")) {
			step = 24 * 3600;
		}

		if (fMap.containsKey(tweetName)) {
			List<Integer> intrv = fMap.get(tweetName);
			Collections.sort(intrv);

			int size = (endTime - startTime) / step + 1;

			int[] intervals = new int[size];

			for (int time : intrv) {
				if (time >= startTime && time < endTime + 1) {
					int index = (time - startTime) / step;
					intervals[index] += 1;
				}
			}
			for (int num : intervals) {
				hist.add(num);
			}

		}
		return hist;

	}

	public static void main(String[] arg) {

		TweetCounts tc = new TweetCounts();
		tc.recordTweet("tweet3", 0);
		tc.recordTweet("tweet3", 60);
		tc.recordTweet("tweet3", 10);
		tc.recordTweet("tweet1", 34);

		tc.recordTweet("tweet0", 33);

		List<Integer> res = tc.getTweetCountsPerFrequency("minute", "tweet3", 0, 59);
		System.out.println(res);
		List<Integer> res1 = tc.getTweetCountsPerFrequency("minute", "tweet3", 0, 60);
		System.out.println(res1);

		// tc.recordTweet("tweet3", 120);

		List<Integer> res2 = tc.getTweetCountsPerFrequency("minute", "tweet3", 43, 1838);
		System.out.println(res2);

		List<Integer> res3 = tc.getTweetCountsPerFrequency("hour", "tweet0", 89, 3045);
		System.out.println(res3);

		List<Integer> res4 = tc.getTweetCountsPerFrequency("minute", "tweet1", 59, 9302);
		System.out.println(res4);

	}

}
