package org.problems.minmax;

import java.util.Arrays;
import java.util.Comparator;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/relative-ranks/
 * 
 * Given scores of N athletes, find their relative ranks and the people with the
 * top three highest scores, who will be awarded medals: "Gold Medal", "Silver
 * Medal" and "Bronze Medal".
 * 
 * Example 1: Input: [5, 4, 3, 2, 1] 
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"] 
 * 
 * Explanation: The first three athletes got the top
 * three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze
 * Medal". For the left two athletes, you just need to output their relative
 * ranks according to their scores. 
 * 
 * Note: N is a positive integer and won't
 * exceed 10,000. All the scores of athletes are guaranteed to be unique
 * 
 * 
 */
public class RelativeRanks {
	
	static class Athlete {
		public int pos;
		public int score;


		public Athlete(int pos, int score) {
			this.pos = pos;
			this.score = score;
		}
	}

	static Comparator<Athlete> byScore = (o,p) -> Integer.compare(p.score, o.score);
	static String[] ranks = {"Gold Medal", "Silver Medal" , "Bronze Medal"};

	public static String[] findRelativeRanks(int[] nums) {
		
		int n = nums.length;
		String[] res = new String[n];
		Athlete[] athletes = new Athlete[n];
		for (int i = 0; i < n; i++) {
			athletes[i] = new Athlete(i, nums[i]);
		}
		Arrays.sort(athletes, byScore);
		for (int i = 0; i < n && i < 3; i++) {
			res[athletes[i].pos] = ranks[i];
		}
		
		for (int i = 3; i < n; i++) {
			res[athletes[i].pos] = String.valueOf(i + 1);
		}		

		return res;

	}

	public static void main(String[] arg) {
		
		int[] nums = {5, 4, 3, 2, 1};
		Utils.print(findRelativeRanks(nums));

		int[] nums1 = {2, 3};
		Utils.print(findRelativeRanks(nums1));

	}

}
