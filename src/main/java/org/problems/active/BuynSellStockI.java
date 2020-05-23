package org.problems.active;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	static class Price implements Comparable<Price> {
		public int date;
		public int price;
		
		public Price(int date, int price) {
			this.date = date;
			this.price = price;
		}

		@Override
		public int compareTo(Price p) {
			return Integer.compare(this.price, p.price);
		}

		@Override
		public String toString() {
			return "[date=" + date + ", price=" + price + "]";
		}
		
	}

	public static int maxProfit(int[] prices) {
		int profit = 0;

		int n = prices.length;
		if (n <= 1) {
			return 0;
		}
		List<Price> price = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Price pObject = new Price(i,prices[i]);
			price.add(pObject );
		}
		Collections.sort(price);
		System.out.println(price);
		int buyDay = 0;
		int sellDay = n-1;
		while (buyDay <= sellDay) {
			System.out.println(price.get(buyDay) + "vs" + price.get(sellDay));
			if (price.get(buyDay).date < price.get(sellDay).date) {
				return price.get(sellDay).price - price.get(buyDay).price;
			}
			// try to change right end first
			int sellAt = sellDay;
			int buyAt = buyDay;
			Price buy = price.get(buyAt);
			Price sell = price.get(sellAt);
			int profit1 = 0;
			while (buy.date >= sell.date && sellAt > buyAt) {
				sell = price.get(sellAt);
				sellAt--;
			}
			int profit11 = 0;
			profit11 = sellAt >= buyAt ? sell.price - buy.price : 0;
			if (buy.date >= sell.date) {
				profit11 = 0;
			}
			sell = price.get(sellAt+1);
			profit1 = sellAt >= buyAt ? sell.price - buy.price : 0;
			if (buy.date >= sell.date) {
				profit1 = 0;
			}
			System.out.print(buy + "vs" + sell);
			System.out.println(profit1);
			sell = price.get(sellAt);
			profit11 = sellAt >= buyAt ? sell.price - buy.price : 0;
			if (buy.date >= sell.date) {
				profit11 = 0;
			}
			System.out.print(buy + "vs" + sell);
			System.out.println(profit11);
			
			// try to change left end secondly
			sellAt = sellDay;
			buyAt = buyDay;
			buy = price.get(buyAt);
			sell = price.get(sellAt);
			int profit2 = 0;
			while (buy.date >= sell.date && sellAt > buyAt) {
				buy = price.get(buyAt);
				buyAt++;
			}
			int profit22 = 0;
			profit22 = sellAt >= buyAt ? sell.price - buy.price : 0;
			if (buy.date >= sell.date) {
				profit22 = 0;
			}
			buy = price.get(buyAt-1);
			profit2 = sellAt >= buyAt ? sell.price - buy.price : 0;
			if (buy.date >= sell.date) {
				profit2 = 0;
			}
			System.out.print(buy + "vs" + sell);
			System.out.println(profit2);
			System.out.print(buy + "vs" + sell);
			System.out.println(profit22);

			profit = Math.max(Math.max(profit1, profit2), Math.max(profit11, profit22));
			if (profit != 0) {
				break;
			}
			buyDay ++;
			sellDay --;
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
