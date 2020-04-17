package com.leetcode.games;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rabbits-in-forest/
 *
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all
 * of them) tell you how many other rabbits have the same color as them. Those
 * answers are placed in an array.
 * 
 * Return the minimum number of rabbits that could be in the forest.
 * 
 * Examples: Input: answers = [1, 1, 2] Output: 5 
 * Explanation: The two rabbits
 * that answered "1" could both be the same color, say red. The rabbit than
 * answered "2" can't be red or the answers would be inconsistent. Say the
 * rabbit that answered "2" was blue. Then there should be 2 other blue rabbits
 * in the forest that didn't answer into the array. The smallest possible number
 * of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 * 
 * Input: answers = [10, 10, 10] Output: 11
 * 
 * Input: answers = [] Output: 0 
 * 
 * Note:
 * answers will have length at most 1000. Each answers[i] will be an integer in
 * the range [0, 999]
 */
public class RabbitsInForest {
	
	static class Rabbit {
		public int color;// unique color, can be used as id
		public int total;
		public int answered = 0;
		
		public Rabbit(int color, int total) {
			this.color = color;
			this.total = total;
		}

		@Override
		public String toString() {
			return "Rabbit [color=" + color + ", total=" + total + "]";
		}
		
	}

	public static int numRabbits(int[] answers) {
		
		Rabbit[] forest = new Rabbit[1001];
		int color = 0;// unique auto-incremental number
		for (int i = 0; i < answers.length; i++) {
			// check possible existent colors;
			int total = answers[i] + 1;
			boolean updated = false;
			for (int col = 0; col < color; col++) {//check history
				Rabbit r = forest[col];
				if (r.answered + 1 <= r.total && r.total == total) {// check consistency
					r.answered ++;
					updated = true;
					break;
				}
			}
			if (!updated) {
				Rabbit r = new Rabbit(color,total);
				r.answered = 1;
				forest[color] = r;
				color ++;
			}
		}
		System.out.println(Arrays.toString(forest));
		int counter = 0;
		for (int i = 0; i < forest.length; i++) {
			Rabbit r = forest[i];
			if (r == null) {
				break;
			}else {
				counter += r.total;
			}
		}
		
		return counter;

	}

	public static void main(String[] arg) {

		int[] answers = {1, 1, 2};
		System.out.println(numRabbits(answers));

		int[] answers1 = {10, 10, 10};
		System.out.println(numRabbits(answers1));

		int[] answers2 = {};
		System.out.println(numRabbits(answers2));

		int[] answers3 = {2,1,2,2,2,2,2,2,1,1};
		System.out.println(numRabbits(answers3));
		
		int[] answers4 = {2, 2, 2};
		System.out.println(numRabbits(answers4));

		int[] answers5 = {1, 1, 1};
		System.out.println(numRabbits(answers5));

		int[] answers6 = {1, 1, 1, 2};
		System.out.println(numRabbits(answers6));


		
	}
}
