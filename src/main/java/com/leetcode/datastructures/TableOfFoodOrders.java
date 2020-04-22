package com.leetcode.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
 * 
 * Given the array orders, which represents the orders that customers have done
 * in a restaurant. More specifically
 * orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the
 * name of the customer, tableNumberi is the table customer sit at, and
 * foodItemi is the item customer orders.
 * 
 * Return the restaurant's “display table”. The “display table” is a table whose
 * row entries denote how many of each food item each table ordered. The first
 * column is the table number and the remaining columns correspond to each food
 * item in alphabetical order. The first row should be a header whose first
 * column is “Table”, followed by the names of the food items. Note that the
 * customer names are not part of the table. Additionally, the rows should be
 * sorted in numerically increasing order.
 * 
 * 
 */
public class TableOfFoodOrders {

	static class Food {
		public String name;
		public int amount;

		public Food(String name) {
			this.name = name;
		}
	}

	static class Table {
		public int num;
		public Map<String, Food> orders = new HashMap<>();

		public Table(int num) {
			this.num = num;
		}

		public void add(String food) {
			if (!orders.containsKey(food)) {
				orders.put(food, new Food(food));
			}
			orders.get(food).amount++;
		}
	}

	public List<List<String>> displayTable(List<List<String>> orders) {
		List<List<String>> res = new ArrayList<>();

		Map<Integer, Table> tables = new HashMap<>();
		Set<String> allfood = new HashSet<>();
		for (List<String> order : orders) {
			int tNum = Integer.valueOf(order.get(1));
			String food = order.get(2);
			allfood.add(food);
			if (!tables.containsKey(tNum)) {
				tables.put(tNum, new Table(tNum));
			}
			tables.get(tNum).add(food);
		}
		// render
		System.out.println(tables);
		List<String> header = new ArrayList<>();
		List<String> tabsFoodName = new ArrayList<>(allfood);
		Collections.sort(tabsFoodName);
		header.add("Table");
		for (String food : tabsFoodName) {
			header.add(food);
		}
		res.add(header);
		List<Integer> tabs = new ArrayList<>(tables.keySet());
		Collections.sort(tabs);
		for (Integer tnumber : tabs) {
			Table table = tables.get(tnumber);
			List<String> line = new ArrayList<>();
			line.add("" + tnumber);
			for (String food : tabsFoodName) {
				if (table.orders.containsKey(food)) {
					line.add("" + table.orders.get(food).amount);
				} else {
					line.add("0");
				}
			}
			res.add(line);
		}
		return res;

	}

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
