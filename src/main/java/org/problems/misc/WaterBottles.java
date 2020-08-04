package org.problems.misc;

/**
 * https://leetcode.com/problems/water-bottles/
 * 
 * Given numBottles full water bottles, you can exchange numExchange empty water
 * bottles for one full water bottle.
 * 
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * 
 * Return the maximum number of water bottles you can drink.
 * 
 * 
 */
public class WaterBottles {

	public int numWaterBottles(int numBottles, int numExchange) {
		int count = numBottles;
		while (numBottles >= numExchange && numBottles > 0) {
			int left = numBottles / numExchange;
			int d = numBottles % numExchange;
			numBottles = left + d;
			count += left;
		}
		return count;
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
