package org.problems.favourite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Highest profit
 * 
 * For each of the products, the stock is represented by a list of a number of
 * items for each supplier. As items are purchased, the supplier raises the
 * price by 1 per item purchased. Let's assume profit on any single
 * item is the same as the number of items the supplier has left. For example,
 * if a supplier has 4 items, profit on the first item sold is 4, then
 * 3, then 2 and the profit of the last one is 1.
 * 
 * Given a list where each value in the list is the number of the item at a
 * given supplier and also given the number of items to be ordered, write an
 * algorithm to find the highest profit that can be generated for the given
 * product.
 * 
 * numSuppliers, an integer representing the number of suppliers;
 * inventory, a list of long integers representing the value of the item at a
 * given supplier;
 * order, a long integer representing the number of items to be ordered.
 * 
 * Return a long integer representing the highest profit that can be generated
 * for the given product.
 * 
 * Constraints
 * 
 * 1 <= numSuppliers <= 10^5
 * 1 <= inventory[i] <= 10^5
 * 0 <= i < numSuppliers
 * 1 <= orders <= sum of inventory
 * 
 * Example1
 * Input:
 * numSuppliers = 2
 * inventory = [3,5]
 * order = 6
 * 
 * Output:
 * 19
 * 
 * Explanation: There are two suppliers, one with inventory 3 and the other with
 * inventory 5, and 6 items were ordered The maximum profit is made by selling 1
 * for 5, 1 for 4, and 2 at 3 and 2 at 2 units profit. The two suppliers are
 * left with a unit of product each. The maximum profit generated is 5 + 4 + 2*3
 * + 2*2 = 19.
 * 
 * 5 4 3 2 1 (Price)
 * 
 * Example2
 * Input:
 * numSuppliers = 2
 * inventory = [2,5]
 * order = 4
 * Output: 14
 * 
 * Example3
 * Input:
 * numSuppliers = 5
 * inventory = [2, 8, 4, 10, 6]
 * order = 20
 * Output: 110
 * 
 */
public class HighestProfit {
	
	static class Supplier {
		long inventory;
		int num;

		public Supplier(long inventory) {
			this.inventory = inventory;
		}

		@Override
		public String toString() {
			return "Supplier [inventory=" + inventory + ", num=" + num + "]";
		}
	}
	
	static long sum(long m) {
		if (m < 0) {
			return 0;
		}
		return m * (m + 1) / 2;
	}
	
	public static long profit(int numSuppliers, long[] inventory, int order) {
		Map<Long,Supplier> map = new HashMap<>();
		for (int i = 0; i < numSuppliers; i++) {
			if (!map.containsKey(inventory[i])) {
				map.put(inventory[i], new Supplier(inventory[i]));
			}
			map.get(inventory[i]).num ++;
		}
		List<Supplier> suppliers = new ArrayList<>(map.values());
		Collections.sort(suppliers, (o,p) -> Long.compare(o.inventory, p.inventory));

		
		int len = suppliers.size();
		int[] cumulative = new int[len];
		cumulative[0] = suppliers.get(0).num;
		for (int i = 1; i < len; i++) {
			cumulative[i] = cumulative[i - 1] + suppliers.get(i).num;
		}
		long profit = 0;
		for (int col = len - 1; col > 0; col --) {
			Supplier sup = suppliers.get(col);
			Supplier prev = suppliers.get(col - 1);
			int dx = cumulative[len - 1] - cumulative[col - 1];// at least 1
			long total = (sup.inventory - prev.inventory) * dx;
			if (total <= order) {
				order -= total;
				profit += (sum(sup.inventory) - sum(prev.inventory)) * dx;
			}else {
				
				int fullLines = order / dx;
				profit += (sum(sup.inventory) - sum(sup.inventory - fullLines)) * dx;
				int tail = order % dx;
				profit += (sup.inventory - fullLines - 1) * tail;
				return profit;
			}
		}
		// last column
		int dx = cumulative[len - 1];// at least 1
		long height = suppliers.get(0).inventory;
		long total =  height * dx;

		if (total <= order) {
			order -= total;
			profit += sum(height) * dx;
		}else {
			int lines = order / dx;
			profit += (sum(height) - sum(height - lines)) * dx;// sum all on range[height - lines, height]
			int tail = order % dx;
			profit += (height - lines) * tail;
		}
		return profit;
	}

	public static void main(String[] arg) {
		System.out.println(profit(2, new long[]{3, 5}, 6));//19
		System.out.println(profit(2, new long[]{2, 5}, 4));//14
		System.out.println(profit(5, new long[]{2, 8, 4, 10, 6}, 20));//110
		System.out.println(profit(4, new long[]{1, 3, 3, 6}, 7));//25
	}

}
