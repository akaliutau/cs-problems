package com.leetcode.minmax;

/**
 *	https://www.hackerrank.com/challenges/breaking-best-and-worst-records/
 *
 * 
 */
public class BreakingBestWorstRecords {
	
	static int[] breakingRecords(int[] scores) {
        int sMin = scores[0];
        int sMax = scores[0];
        int cMin = 0;
        int cMax = 0;
        for (int i = 0; i < scores.length; i++) {
        	int score = scores[i];
        	if (score < sMin) {
        		sMin = score;
        		cMin ++;
        	}
           	if (score > sMax) {
           		sMax = score;
           		cMax ++;
        	}
        }
        int[] res = new int[2];
        res[0] = cMax;
        res[1] = cMin;
        return res;
    }

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
