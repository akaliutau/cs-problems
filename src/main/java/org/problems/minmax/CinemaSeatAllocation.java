package org.problems.minmax;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/cinema-seat-allocation/
 * 
 * A cinema has n rows of seats, numbered from 1 to n and there are ten seats in
 * each row, labelled from 1 to 10 as shown in the figure above.
 * 
 * Given the array reservedSeats containing the numbers of seats already
 * reserved, for example, reservedSeats[i]=[3,8] means the seat located in row 3
 * and labelled with 8 is already reserved.
 * 
 * Return the maximum number of four-person families you can allocate on the
 * cinema seats. A four-person family occupies fours seats in one row, that are
 * next to each other. Seats across an aisle (such as [3,3] and [3,4]) are not
 * considered to be next to each other, however, It is permissible for the
 * four-person family to be separated by an aisle, but in that case, exactly two
 * people have to sit on each side of the aisle.
 * 
 */
public class CinemaSeatAllocation {

	public static int v2 = Integer.parseInt("001111111100", 2);
	public static int v1a = Integer.parseInt("001111000000", 2);
	public static int v1b = Integer.parseInt("000000111100", 2);
	public static int v1c = Integer.parseInt("000011110000", 2);

	public static int getVariantsInt(int in) {
		if (in == 0) {
			return 2;
		}
		if ((in & v2) == 0) {
			return 2;
		}
		if ((in & v1a) == 0) {
			return 1;
		}
		if ((in & v1b) == 0) {
			return 1;
		}
		if ((in & v1c) == 0) {
			return 1;
		}
		return 0;
	}

	public static int boolToInt(boolean[] r) {
		int num = 0;
		if (r == null) {
			return 0;
		}
		for (int i = 9; i > -1; i--) {
			if (r[i]) {
				num++;
			}
			num = num << 1;
		}
		return num;
	}

	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int nSeats = 0;
		Map<Integer, boolean[]> rows = new HashMap<>();
		for (int[] res : reservedSeats) {
			int row = res[0] - 1;
			if (!rows.containsKey(row)) {
				rows.put(row, new boolean[10]);
			}
			boolean[] r = rows.get(row);
			r[res[1] - 1] = true;
		}

		for (Integer i : rows.keySet()) {
			nSeats += getVariantsInt(boolToInt(rows.get(i)));
		}
		nSeats += 2 * (n - rows.size());
		return nSeats;
	}

	public static void main(String[] arg) {

		int[][] reservedSeats = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };// 4
		System.out.println(maxNumberOfFamilies(3, reservedSeats));

		int[][] reservedSeats1 = { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		System.out.println(maxNumberOfFamilies(2, reservedSeats1));// 2

		int[][] reservedSeats2 = { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		System.out.println(maxNumberOfFamilies(4, reservedSeats2));// 4

		int[][] reservedSeats3 = {};
		System.out.println(maxNumberOfFamilies(3, reservedSeats3));// 6

	}

}
