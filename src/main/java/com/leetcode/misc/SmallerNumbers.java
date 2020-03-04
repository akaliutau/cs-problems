package com.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array
 * are smaller than it. That is, for each nums[i] you have to count the number
 * of valid j's such that j != i and nums[j] < nums[i].
 * 
 * Return the answer in an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [8,1,2,2,3] Output: [4,0,1,1,3]
 * 
 */
public class SmallerNumbers {

	public static class Elem {
		int val;
		int pos;

		public Elem(int val, int pos) {
			this.val = val;
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "[" + val + "," + pos + "]";
		}
	}

	public static int[] smallerNumbersThanCurrent2(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

		if (nums.length == 1) {
			return new int[] { 0 };
		}

		List<Elem> lst = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			lst.add(new Elem(nums[i], i));
		}

		Comparator<Elem> sortByVal = (o, p) -> Integer.compare(o.val, p.val);// desc
		List<Elem> collected = lst.stream().sorted(sortByVal).collect(Collectors.toList());
		// System.out.println(collected);

		int curPos = 0;
		int[] res = new int[nums.length];
		int last = nums[0];
		Elem lastElem = collected.get(0);

		int pos = 0;
		Elem elem = null;
		while (pos < nums.length) {
			elem = collected.get(pos);
			// System.out.println("elem:"+elem+"last elem:"+lastElem);
			// System.out.println("curPos:"+curPos);
			if (lastElem.val != elem.val) {
				res[lastElem.pos] = curPos;
				lastElem = elem;
				curPos = pos;
			} else {
				res[elem.pos] = curPos;
			}
			pos++;
		}
		if (elem != null) {
			res[lastElem.pos] = curPos;
		}

		return res;

	}

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] copy = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		Arrays.sort(copy);
		return copy;

	}

	public static void main(String[] arg) {

		int[] arr = { 8, 1, 2, 2, 3 };
		Utils.print(smallerNumbersThanCurrent2(arr));

		int[] arr1 = { 7, 7, 7 };
		Utils.print(smallerNumbersThanCurrent2(arr1));

		int[] arr2 = { 6, 5, 4, 8 };
		Utils.print(smallerNumbersThanCurrent2(arr2));

		int[] arr3 = { 6 };
		Utils.print(smallerNumbersThanCurrent2(arr3));

		int[] arr4 = { 5, 0, 10, 0, 10, 6 };
		Utils.print(smallerNumbersThanCurrent2(arr4));

	}

}
