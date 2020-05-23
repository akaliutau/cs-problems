package org.problems.topology;

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
public class TrappingRainWater {
	
	public static class Extr {
		public boolean type;// true - max, false - min
		public int h;
		public int pos;
		
		public Extr(int h, int pos, boolean type) {
			this.h = h;
			this.type = type;
			this.pos = pos;
		}
		
		@Override
		public String toString() {
			return "[h="+h+",pos="+pos+"]";
		}
	}

	public static int trap(int[] height) {
		int vol = 0;
		int lastMaxHeight = 0;
		if (height.length < 3) {
			return 0;
		}

		boolean up = false;
		int absMax = 0;
		List<Extr> maxs = new ArrayList<>();
		
		maxs.add(new Extr(height[0],0,true));

		for (int i = 1; i < height.length; i++) {
			int h = height[i];
			int diff = h - height[i - 1];


			if ((diff < 0) && up) {// max
				up = false;
				maxs.add(new Extr(height[i - 1],i,true));
				lastMaxHeight = height[i - 1];
				absMax = absMax < lastMaxHeight ? lastMaxHeight : absMax;
			}
			if ((diff > 0) && !up) {// min
				up = true;
				lastMaxHeight = lastMaxHeight < height[i - 1] ? height[i - 1] : lastMaxHeight;
			}

		}
		maxs.add(new Extr(height[height.length-1],height.length-1,true));
		// check first and last elem
		if (Math.min(height[0], height[height.length-1]) >= absMax) {
			maxs = new ArrayList<>();
			maxs.add(new Extr(height[0],0,true));
			maxs.add(new Extr(height[height.length-1],height.length-1,true));
		}
		
		Comparator<Extr> sortByHeight = (o, p) -> Integer.compare(p.h, o.h);// asc

		maxs.sort(sortByHeight);
		System.out.println(maxs);

		// render height map

		Extr lastMax = maxs.get(0);
		int leftPos = lastMax.pos;
		int rightPos = lastMax.pos;
		for (int i = 1; i < maxs.size(); i++) {
			Extr extr = maxs.get(i);
			if (leftPos <= extr.pos  && extr.pos <= rightPos) {
				continue;
			}
			int level = Math.min(lastMax.h, extr.h);
			int l = 0;
			int r = 0;
			if (lastMax.pos > extr.pos) {
				r = lastMax.pos;
				l = extr.pos;
			}else {
				l = lastMax.pos;
				r = extr.pos;
			}

			for (int j = l; j < r; j++) {
				if (leftPos <= j  && j < rightPos) {
					continue;
				}
				int diff = level-height[j];
				vol += (diff > 0 ? diff : 0);
			}
			leftPos = leftPos > l ? l : leftPos;
			rightPos = rightPos < r ? r : rightPos;

			if (leftPos == 0 && rightPos == height.length-1) {
				break;
			}
		}		
		
		return vol;

	}

	public static void main(String[] arg) {

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(arr));//6
		
		int[] arr1 = { 3, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(arr1));//14
		
		int[] arr2 = { 3, 1, 0, 0, 1, 0, 1 };
		System.out.println(trap(arr2));

		int[] arr3 = { 3, 1, 0, 2, 1, 0 };
		System.out.println(trap(arr3));

		int[] arr4 = { 1,1,1};
		System.out.println(trap(arr4));

		int[] arr5 = { 1,0,1};
		System.out.println(trap(arr5));

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
