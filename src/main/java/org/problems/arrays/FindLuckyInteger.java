package org.problems.arrays;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array
 * 
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

 

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

 * 
 */
public class FindLuckyInteger {
	
	public static int findLucky(int[] arr) {
		int[] map = new int[502];
		for (int i = 0; i < arr.length; i++) {
			map[arr[i]] ++;
		}
		int biggest = 501;
		for (int i = map.length-1; i > -1; i--) {
			if (map[i] == i && i != 0) {
				return i;
			}
		}
		return -1;
    }

	public static void main(String[] arg) {
		
		int[] arr = {2,2,3,4};
		System.out.println(findLucky(arr));

		int[] arr1 = {1,2,2,3,4,3,3};
		System.out.println(findLucky(arr1));

		int[] arr2 = {2,2,2,3,3};
		System.out.println(findLucky(arr2));

		int[] arr3 = {5};
		System.out.println(findLucky(arr3));

		int[] arr4 = {7,7,7,7,7,7,7};
		System.out.println(findLucky(arr4));
		
		int[] arr5 = {};
		System.out.println(findLucky(arr5));


	}

}
