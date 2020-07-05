package org.problems.numbers;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/counting-bits/
 * 
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * Example 1:
 * 
 * Input: 2 Output: [0,1,1] 
 * 
 * Example 2:
 * 					 0 1 2 3 4 5
 * Input: 5 Output: [0,1,1,2,1,2]
 * 
 * 
 * 
 */
public class CountingBits {
	

	public static int[] countBits(int num) {
        if (num == 0){
            return new int[]{0};
        }
        if (num == 1){
            return new int[]{0, 1};
        }
        if (num == 2){
            return new int[]{0, 1, 1};
        }
		int[] dp = new int[num + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= num; i++) {
		    int n = (int) (Math.log(i) / Math.log(2));
			int nearestSq =  (int) Math.pow(2, n);
			if (nearestSq == i) {
				dp[i] = 1;
				continue;
			}
			int offset = i - nearestSq;
			dp[i] = dp[nearestSq] + dp[offset];
		}
		return dp;

	}

	public static void main(String[] arg) {

		Utils.print(countBits(9));

	}

}
