package org.problems.favourite;

import java.util.Arrays;

/**
 * Classic DP problem
 * 
 * All of the products in the warehouse are in boxes of the same size. Each
 * product is packed in some number of units per box.
 * 
 * Given the number of boxes the truck can hold, write an algorithm to determine
 * the maximum number of units of any mix of products that can be shipped.
 * 
 * Input
 * 
 * The input to the function method consists of five arguments:
 * 
 * num, an integer representing number of products;
 * 
 * boxes, a list of integers representing the number of available boxes for
 * products;
 * 
 * unitSize, an integer representing size of unitsPerBox;
 * 
 * unitsPerBox, a list of integers representing the number of units packed in
 * each box;
 * 
 * truckSize, an integer representing the number of boxes the truck can carry.
 * 
 * Output
 * 
 * Return an integer representing the maximum units that can be carried by the
 * truck.
 * 
 * 
 * Example
 * 
 * Input:
 * num=3
 * boxes=[1,2,3]
 * unitSize=3
 * unitsPerBox= [3,2,1]
 * truckSize = 3
 * 
 * Output
 * 7
 * 
 * Explanation:
 * 
 * Product 0: because boxes[0] = 1, we know there is 1 box in product 0. And
 * because unitsPerBox[0] = 3, we know there is 1 box with 3 units in product 0.
 * Product 1: 2 boxes with 2 units each
 * Product 2: 3 boxes with 1 unit each
 * Finally we have the packed products like a (units) list : [3, 2, 2, 1, 1, 1]
 * 
 * The truckSize is 3, so we pick the top 3 from the above list, which is [3, 2,
 * 2], and return the sum 7
 * 
 */
public class Warehouse {
	
	static class Box {
		int n;
		int units;

		public Box(int n, int units) {
			this.n = n;
			this.units = units;
		}
		
	}
	
	
	public static int  maximumUnits(int num, int[] boxes, int unitSize, int[] unitsPerBox, int truckSize) {
		Box[] units = new Box[num];
		for (int i = 0; i < num; i++) {
			units[i] = new Box(boxes[i], unitsPerBox[i]);
		}
		Arrays.parallelSort(units, (o,p) -> Integer.compare(p.units, o.units));
		int unitsCount = 0;
		for (int i = 0; i < num; i++) {
			if (units[i].n >= truckSize) {
				unitsCount += truckSize * units[i].units;
				return unitsCount;
			}else {
				truckSize -= units[i].n;
				unitsCount += units[i].n * units[i].units;
			}
		}
		return unitsCount;
	}

	public static void main(String[] arg) {
		System.out.println(maximumUnits(3, new int[] {1,2,3}, 3, new int[] {3,2,1}, 3));
		System.out.println(maximumUnits(3, new int[] {1,1,1}, 3, new int[] {1,2,1}, 3));
	}

}
