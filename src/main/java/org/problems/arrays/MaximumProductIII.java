package org.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * Input: [2,3,-2,4] Output: 6 
 * Explanation: [2,3] has the largest product 6.
 * 
 * Example 2:
 * 
 * Input: [-2,0,-1] Output: 0 
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray
 */
public class MaximumProductIII {
	
	static class Block {
		public int[] nums;
		
		public Block(int i, int j, int[] nums) {
			this.nums = new int[j-i];
			int idx = 0;
			for (int k = i; k < j; k++) {
				this.nums[idx++] = nums[k];
			}
		}
		
		public List<Integer> getNegative(){
			List<Integer> negLi = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] < 0) {
					negLi.add(i);
				}
			}
			return negLi;
		}
		
		public int process(int left, int right) {
			if (left > right) {
				return 0;
			}
			int p = 1;
			for (int i = left; i <= right; i++) {
				p *= this.nums[i];
			}
			return p;
		}

		@Override
		public String toString() {
			return Arrays.toString(nums);
		}
	}
	
	static int product(Block block) {
		int prod = 1;
		// choose the best array containing negative numbers
		List<Integer> negatives = block.getNegative();
		int len = negatives.size();
		if (len == 0 || len % 2 == 0) {// process all array
			prod = block.process(0, block.nums.length-1);
		} else {//=3,5,7 choose the widest range and compare it with positive one; return the biggest 
			int point1 = negatives.get(len-1);
			int left1 =  block.process(0, point1-1);
			int right1 =  block.process(point1+1, block.nums.length-1);
			int prod1 = Math.max(left1, right1);
			int point2 = negatives.get(0);
			int left2 =  block.process(0, point2-1);
			int right2 =  block.process(point2+1, block.nums.length-1);
			int prod2 = Math.max(left2, right2);
			prod = Math.max(prod1, prod2);
			if (block.nums.length == 1) {
				prod = block.nums[0];
			}
		}
		return prod;
	}
	
	public static int maxProduct(int[] nums) {

        int left = 0; 
        int right = 0;
        int n = nums.length;
        List<Block> blocks = new ArrayList<>();
        boolean isZeroPresent = false;
        while (right < n) {
        	if (nums[right] == 0) {
        		isZeroPresent = true;
        		if (left != right) {
        			if (nums[left] != 0) {
        				blocks.add(new Block(left,right,nums));
        			}else {
        				blocks.add(new Block(left+1,right,nums));
        			}
        			left = right;
        		}
       			left ++;
       		}
        	right ++;
        }
   		if (left != right) {
			blocks.add(new Block(left,right,nums));
		}

        int minProduct = Integer.MIN_VALUE;
        for (Block block : blocks) {
        	int prod = product(block);
        	if (prod > minProduct) {
        		minProduct = prod;
        	}
        }
        if (blocks.size() > 1 && minProduct < 0) {
        	return 0;
        }
        if (isZeroPresent && minProduct < 0) {
        	return 0;
        }
		return minProduct;
    }

	public static void main(String[] arg) {

		int[] nums = {2,3,-2,4};
		System.out.println(maxProduct(nums));

		int[] nums1 = {-2,0,-1};
		System.out.println(maxProduct(nums1));

		int[] nums2 = {-2};
		System.out.println(maxProduct(nums2));

		int[] nums3 = {-2,-1};
		System.out.println(maxProduct(nums3));

		int[] nums4 = {-2,1};
		System.out.println(maxProduct(nums4));

		int[] nums5 = {-2,0};
		System.out.println(maxProduct(nums5));

		int[] nums6 = {2};
		System.out.println(maxProduct(nums6));

		int[] nums7 = {2,0};
		System.out.println(maxProduct(nums7));

		int[] nums8 = {0,2};
		System.out.println(maxProduct(nums8));

		int[] nums9 = {0,0,2};
		System.out.println(maxProduct(nums9));

		int[] nums10 = {2,-5,-2,-4,3};
		System.out.println(maxProduct(nums10));//24

		int[] nums11 = {-4,-3,-2};
		System.out.println(maxProduct(nums11));//12

	}
}
