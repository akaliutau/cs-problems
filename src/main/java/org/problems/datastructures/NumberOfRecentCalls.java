package org.problems.datastructures;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 * 
 * Write a class RecentCounter to count recent requests.
 * 
 * It has only one method: ping(int t), where t represents some time in
 * milliseconds.
 * 
 * Return the number of pings that have been made from 3000 milliseconds ago
 * until now.
 * 
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * 
 * It is guaranteed that every call to ping uses a strictly larger value of t
 * than before.
 * 
 * Example 1:
 * 
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs =
 * [[],[1],[100],[3001],[3002]] Output: [null,1,2,3,3]
 * 
 * Note:
 * 
 * Each test case will have at most 10000 calls to ping. 
 * Each test case will call ping with strictly increasing values of t. 
 * Each call to ping will have 1 <= t <= 10^9
 */
public class NumberOfRecentCalls {

	static class RecentCounter {
		
		private int[] pings = new int[10001];
		private int start = 0;
		private int end = 0;

		public RecentCounter() {

		}

		public int ping(int t) {
			pings[end ++] = t;
			while (t - pings[start] > 3000) {
				start ++;
			}
			return end - start;

		}
	}

	public static void main(String[] arg) {
		
		RecentCounter rc = new RecentCounter();
		
		System.out.println(rc.ping(1));
		System.out.println(rc.ping(100));
		System.out.println(rc.ping(3001));
		System.out.println(rc.ping(3002));
	}

}