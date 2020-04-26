package com.leetcode.matricies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 * 
 * Given a list of lists of integers, nums, return all elements of nums in
 * diagonal order
 * 
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,4,2,7,5,3,8,6,9]
 */
public class DiagonalTraverseII {

	static class Result {
		public List<Integer> arr;

		public Result() {
			this.arr = new ArrayList<>();
		}

		public void add(int n) {
			arr.add(n);
		}
	}

	static class Line {
		public List<Integer> line;
		public int pos = 0;
		public int rowNumb;

		public Line(int rowNumb, List<Integer> line) {
			this.rowNumb = rowNumb;
			this.line = line;
		}


		@Override
		public String toString() {
			return "Line [line=" + line + ", pos=" + pos + ", rowNumb=" + rowNumb + "]";
		}

	}


	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		Result r = new Result();
		int idx = 0;
		List<Line> rows = new ArrayList<>();
		for (List<Integer> line : nums) {
			rows.add(new Line(idx++, line));
		}
		Map<Integer, List<Integer>> buckets = new HashMap<>();
		int maxKey = 0; 

		for (int i = 0; i < rows.size(); i++) {
			Line l = rows.get(i);
			for (int j = 0; j < l.line.size(); j++) {
				int key = i + j;

				if (!buckets.containsKey(key)) {
					buckets.put(key, new ArrayList<>());
				}
				buckets.get(key).add(l.line.get(j)); 
				maxKey = Math.max(maxKey, key); 
			}
		}
		for (int i = 0; i <= maxKey; i++) {
			List<Integer> diag = buckets.get(i);
			for (int j = diag.size() - 1; j > -1; j--) {
				r.add(diag.get(j));
			}
		}

		int[] result = new int[r.arr.size()];
		for (int i = 0; i < r.arr.size(); i++) {
			result[i] = r.arr.get(i);
		}

		return result;
	}

	public static void main(String[] arg) {

		List<List<Integer>> nums = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));
		Utils.print(findDiagonalOrder(nums));// [1,4,2,7,5,3,8,6,9]

		List<List<Integer>> nums1 = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7), Arrays.asList(8),
				Arrays.asList(9, 10, 11), Arrays.asList(12, 13, 14, 15, 16));
		Utils.print(findDiagonalOrder(nums1));// [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

		List<List<Integer>> nums2 = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5));
		Utils.print(findDiagonalOrder(nums2));// [1,2,3,4,5]

		List<List<Integer>> nums3 = Arrays.asList(Arrays.asList(5), Arrays.asList(1, 2, 3, 4, 5));
		Utils.print(findDiagonalOrder(nums3));// [5,1,2,3,4,5]

	}

}
