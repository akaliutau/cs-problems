package org.problems.favourite;

/**
 * Roll Dice
 * 
 * Given N dices each face ranging from 1 to 6, return the minimum number of
 * rotations necessary for each dice show the same face. Notice in one rotation
 * you can rotate the dice to the adjacent face. For example you can rotate the
 * dice shows 1 to show 2, 3, 4, or 5. But to make it show 6, you need two
 * rotations.
 * 
 * Example: 
 * Input: [6, 5, 4] Output: 2 
 * Rotate 6 to 4, then rotate 5 to 4.
 * 
 * Input: [6, 6, 1] Output: 2 
 * Rotate 1 to 6, which needs two rotations.
 * 
 * Input: [6, 1, 5, 4] Output: 3 
 * Rotate 6 to 5, rotate 1 to 5, then rotate 4 to 5
 * 
 */
public class RollDice {
	
	static int[][] rotations = {
			{0, 1, 1, 1, 1, 2},
			{1, 0, 1, 1, 2, 1},
			{1, 1, 0, 2, 1, 1},
			{1, 1, 2, 0, 1, 1},
			{1, 2, 1, 1, 0, 1},
			{2, 1, 1, 1, 1, 0}
	};
	
	public static int getRotations(int[] dices) {
		int minCounter = Integer.MAX_VALUE;
		for (int num = 1; num <= 6; num++) {
			int counter = 0;
			for (int i = 0; i < dices.length; i++) {
				counter += rotations[num - 1][dices[i] - 1];
			}
			minCounter = Math.min(minCounter, counter);
		}
		
		return minCounter;
	}

	public static void main(String[] arg) {
		int[] dices = {6, 5, 4};
		System.out.println(getRotations(dices));

		int[] dices1 = {6, 6, 1};
		System.out.println(getRotations(dices1));

		int[] dices2 = {6, 1, 5, 4};
		System.out.println(getRotations(dices2));

		int[] dices3 = {1, 1};
		System.out.println(getRotations(dices3));
	}

}
