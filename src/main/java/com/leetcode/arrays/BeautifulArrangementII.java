package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 * 
 * Given two integers n and k, you need to construct a list which contains n
 * different positive integers ranging from 1 to n and obeys the following
 * requirement: Suppose this list is [a1, a2, a3, ... , an], then the list [|a1
 * - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct
 * integers.
 * 
 * If there are multiple answers, print any of them.
 * 
 * Example 1: Input: n = 3, k = 1 
 * Output: [1, 2, 3] 
 * 
 * Explanation: The [1, 2, 3]
 * has three different positive integers ranging from 1 to 3, and the [1, 1] has
 * exactly 1 distinct integer: 1. 
 * 
 * Example 2: Input: n = 3, k = 2 
 * Output: [1, 3, 2] 
 * 
 * Explanation: The [1, 3, 2] has three different positive integers ranging
 * from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2. Note:
 * The n and k are in the range 1 <= k < n <= 104.
 * 
 * 
 */
public class BeautifulArrangementII {
	
	public static int[] constructArray(int n, int k) {
		int[] res = new int[n];
		int lower = 1;
		int higher = n;
		int idx = 0;
		boolean inc = true;
		while (idx < k) {
			res[idx++] = lower++;
			inc = true;
			if (idx < k) {
				res[idx++] = higher--;
				inc = false;
			}
		}
		while (idx < n) {
			if (inc) {
				res[idx++] = lower++;
			} else {
				res[idx++] = higher--;
			}
		}		
		
		return res;
        
    }


	public static void main(String[] arg) {
		
		Utils.print(constructArray(3,2));
		Utils.print(constructArray(3,2));
		
		Utils.print(constructArray(8,1));
		Utils.print(constructArray(8,6));
		Utils.print(constructArray(8,7));

		Utils.print(constructArray(1,1));

	}

}
