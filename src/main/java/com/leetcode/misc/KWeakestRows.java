package com.leetcode.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 *
 */
public class KWeakestRows {

	public static final int n = 12;

	public static class Row implements Comparable<Row> {
		public int index;
		public int force;

		Row(int index, int[] line) {
			this.index = index;
			force = 0;
			for (int i = 0; i < line.length; i++) {
				force += line[i];
			}
		}

		@Override
		public int compareTo(Row r) {
			if (this.force > r.force) {
				return 1;
			} else if (this.force == r.force && this.index > r.index) {
				return 1;
			} else if (this.force == r.force && this.index == r.index) {
				return 0;
			}
			return -1;
		}
	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		List<Row> rows = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			rows.add(new Row(i, mat[i]));
		}
		Collections.sort(rows);
		int[] results = new int[k];
		for (int i = 0; i < k; i++) {
			results[i] = rows.get(i).index;
		}

		return results;

	}

	public static void main(String[] arg) {

		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };

		int k = 3;

		int[] res = kWeakestRows(mat, k);

		Utils.print(res);

	}

}
