package org.problems.favourite;

import org.problems.utils.Utils;

/**
 * CELL STATE AFTER N DAYS
 * 
 * Eight houses, represented as cells, are arranged in a straight line. Each day
 * every cell competes with its adjacent cells (neighbors). An integer value 1
 * represents an active cell and a value of 0 represents an inactive cell. If
 * the neighbors on both the sides of a cell are either active or inactive, the
 * cell becomes inactive on the next day; otherwise the cell becomes active. 
 * 
 * The two cells on each end have a single adjacent cell, so assume that the
 * unoccupied space on the opposite side is an inactive cell. 
 * Write an algorithm to output the state of the cells after the
 * given number of days.
 * 
 * Examples 1 Input: [1, 0, 0, 0, 0, 1, 0, 0], 1
 * 
 * Output: 0 1 0 0 1 0 1 0
 * 
 * Examples 2 Input: [1, 1, 1, 0, 1, 1, 1, 1], 2
 * 
 * 1, 1, 1, 0, 1, 1, 1, 1 - 0
 * 1, 0, 1, 0, 1, 0, 0, 1 - 1
 * 0, 0, 0, 0, 0, 1, 1, 0 - 2
 * 
 * 
 */
public class CellStateAfterNDays {

	public static int[] prisonAfterNDays(int[] cells, int day) {
		int n = cells.length;
		int[] res = new int[n];
		int prison = 0;
		for (int i = 0; i < 8; i++) {
			if (cells[i] == 1) {
				prison += 1;
			}
			prison = prison << 1;
		}
		prison = prison >> 1;
		prison = prison & 255;

		int mask = 255;
		boolean[] states = new boolean[256];
		boolean found = false;
		boolean cycle = false;
		int cycleLen = 0;
		int[] clc = new int[256];
		clc[cycleLen] = prison;
		while (day > 0) {
			int left = prison >> 1;
			int right = prison << 1;
			int newPrison = (left ^ right) & mask;
			if (states[newPrison]) {
				cycle = true;
				prison = newPrison;
				break;
			}
			states[newPrison] = true;
			if (newPrison == prison) {
				found = true;
				break;
			}
			prison = newPrison;
			clc[++cycleLen] = prison;
			day--;

		}
		if (!found && cycle) {
			int offset = day % cycleLen;
			if (cycleLen != 1) {
				if (offset == 0) {
					offset = cycleLen;
				}
				prison = clc[offset];
			}
		}
		for (int i = 7; i > -1; i--) {
			if ((prison & 1) == 1) {
				res[i] = 1;
			}
			prison = prison >> 1;
		}
		return res;
	}

	public static void main(String[] arg) {

		Utils.print(prisonAfterNDays(new int[] {1, 0, 0, 0, 0, 1, 0, 0}, 1));
		Utils.print(prisonAfterNDays(new int[] {1, 1, 1, 0, 1, 1, 1, 1}, 2));

	}

}
