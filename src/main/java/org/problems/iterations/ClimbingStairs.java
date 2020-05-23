package org.problems.iterations;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 2 
 * Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps Example 2:
 * 
 * Input: 3 Output: 3 
 * Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 * step(4) = step(3) + step(2)
 * 4
 * 3 - k
 * 2 - m
 * 1 
 * 4 = 1+1+1+1
 *   = 1+1+2
 * 	   1+2+1
 *     2+1+1
 *     2+2	
 */	
public class ClimbingStairs {

	public static int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n==2) {
			return 2;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i-2] + dp[i-1]; 
		}
		return dp[n-1];
    }

	public static void main(String[] arg) {

		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(6));

	}
}
