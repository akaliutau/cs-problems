package com.leetcode.topology;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining. 
 * 
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 
 * Output: 6
 * 
 * 
 */
public class TrappingRainWaterII {
	
	public static class Peak {
		public int pos;// play the role of unique id

		public int h;
		public Peak left;
		public Peak right;
		
		public Peak(int h, int pos) {
			this.h = h;
			this.pos = pos;
		}

		@Override
		public String toString() {
			return "Peak [h=" + h + ", pos=" + pos + ", left=" + left.pos + ", right=" + right.pos + "]";
		}
		
	}

	public static int trap(int[] height) {
		int vol = 0;
		int lastMaxHeight = 0;
		if (height.length < 3) {
			return 0;
		}

		
		return vol;

	}

	public static void main(String[] arg) {

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(arr));//6
		
		int[] arr1 = { 3, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(arr1));//14
		
		int[] arr2 = { 3, 1, 0, 0, 1, 0, 1 };//3
		System.out.println(trap(arr2));

		int[] arr3 = { 3, 1, 0, 2, 1, 0 };
		System.out.println(trap(arr3));//3

		int[] arr4 = { 1,1,1};
		System.out.println(trap(arr4));//0

		int[] arr5 = { 1,0,1};
		System.out.println(trap(arr5));//1

		int[] arr6 = { 6, 5, 0, 4, 0, 1 };
		System.out.println(trap(arr6));//5

		int[] arr7 = {5,2,1,2,1,5 };
		System.out.println(trap(arr7));//14

		int[] arr8 = {5,5,1,7,1,1,5,2,7,6 };
		System.out.println(trap(arr8));//23

		int[] arr9 = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
		System.out.println(trap(arr9));//83

	}

}
