package com.leetcode.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 * 
 * Given an array target and an integer n. In each iteration, you will read a
 * number from list = {1,2,3..., n}.
 * 
 * Build the target array using the following operations:
 * 
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array. If the target array is already
 * built, stop reading more elements. You are guaranteed that the target array
 * is strictly increasing, only containing numbers between 1 to n inclusive.
 * 
 * Return the operations to build the target array.
 * 
 * You are guaranteed that the answer is unique
 * 
 * 
 */
public class BuildArrayWithStack {

	public static List<String> buildArray(int[] target, int n) {
		List<String> res = new ArrayList<>();
		int currentNum = 1;
		for (int i = 0; i < target.length; i++) {
			if (target[i] > currentNum) {
				int times = target[i] - currentNum;
				for (int j = 0; j < times; j++) {
					res.add("Push");
					res.add("Pop");
					currentNum++;
				}
			}
			res.add("Push");
			currentNum++;
		}
		return res;
	}

	public static void main(String[] arg) {

		int[] target = { 1, 3 };
		System.out.println(buildArray(target, 3));

		int[] target1 = { 1, 2 };
		System.out.println(buildArray(target1, 4));

		int[] target2 = { 2, 3, 4, 7 };
		System.out.println(buildArray(target2, 4));

	}

}
