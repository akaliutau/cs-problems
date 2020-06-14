package org.problems.misc;

import java.util.List;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * 
 * Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
 * 
 * 
 * 
 * 
 */
public class FinalPricesWithDiscount {

	public static int[] finalPrices(int[] prices) {
        	int n = prices.length;
        	int[] res = new int[n];
        	for (int i = 0; i < n; i++) {
        		int discount = 0;
            	for (int j = i+1; j < n; j++) {
            		if (prices[j] <= prices[i]) {
            			discount = prices[j];
            			break;
            		}
            	}
        		res[i] = prices[i] - discount;
        	}
        	return res;
    }

	public static void main(String[] arg) {

		int[] prices = {8,4,6,2,3};
		Utils.print(finalPrices(prices));

		int[] prices1 = {1,2,3,4,5};
		Utils.print(finalPrices(prices1));

		int[] prices2 = {10,1,1,6};
		Utils.print(finalPrices(prices2));

	}

}
