package org.problems.minmax;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on date i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4] 
 * Output: 5 
 * 
 * Explanation: Buy on date 2 (price = 1) and sell
 * on date 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs
 * to be larger than buying price.
 * 
 * 
 */
public class BuynSellStockI {
	

	public static int maxProfit(int[] prices) {
		int profit = 0;

		int n = prices.length;
		if (n <= 1) {
			return 0;
		}
		int min = prices[0];
		int max = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] > max) {
				max = prices[i];
				profit = Math.max(profit, max - min);
			}
			if (prices[i] < min) {
				min = prices[i];
				max = prices[i];
			}
		}
		
		return profit;

	}

	public static void main(String[] arg) {

		int[] arr = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));

		int[] arr1 = {7,4,8,2,9,1};
		System.out.println(maxProfit(arr1));
		
		int[] arr2 = {1,4,8,9,1};
		System.out.println(maxProfit(arr2));
		
		int[] arr3 = {11,10,9,1};
		System.out.println(maxProfit(arr3));

		int[] arr4 = {1};
		System.out.println(maxProfit(arr4));
		
		int[] arr5 = {2,4,1};
		System.out.println(maxProfit(arr5));
		
		int[] arr6 = {11, 2, 7, 1, 4};
		System.out.println(maxProfit(arr6));


}

}
