package org.problems.games;

/**
 * https://leetcode.com/problems/elimination-game/
 * 
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the
 * end of the list.
 * 
 * Repeat the previous step again, but this time from right to left, remove the
 * right most number and every other number from the remaining numbers.
 * 
 * We keep repeating the steps again, alternating left to right and right to
 * left, until a single number remains.
 * 
 * Find the last number that remains starting with a list of length n.
 * 
 * Example:
 * 
 * Input: n = 9, 
 * 1 2 3 4 5 6 7 8 9 
 * 2 4 6 8 
 * 2 6 
 * 6
 * 
 * Output: 6
 * 
 * 
 */
public class EliminationGame {
	
	static int findNext(boolean fromLeft, boolean[] checked) {
		if (fromLeft) {
			int idx = -1;
			while (++idx < checked.length) {
				if (!checked[idx]) {
					break;
				}
			}
			return idx;
		}
		int idx = checked.length;
		while (--idx >= 0) {
			if (!checked[idx]) {
				break;
			}
		}
		return idx;

	}


	public static int lastRemaining2(int n) {
		boolean[] checked = new boolean[n];
		int left = 0;
		int right = n-1;
		int step = 2;
		while (left < right) {
			left = findNext(true,checked);
			for (int i = left; i < checked.length; i+=step) {
				checked[i] = true;
			}
			right = findNext(false,checked);
			step += 2;
			for (int i = right; i >= 0; i-=step) {
				checked[i] = true;
			}
		}
		return right;
	}
	
    static int[] shift = new int[]{2, 1};
    
    public static int lastRemaining(int n) {
        if (n < 1) return -1;
   		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

        return n - 2 * lastRemaining(n / 2) + shift[n % 2];
    }
	public static void main(String[] arg) {

		System.out.println(lastRemaining(1));//4
		System.out.println(lastRemaining(6));//4
		System.out.println(lastRemaining(7));//4
		System.out.println(lastRemaining(8));//6
		System.out.println(lastRemaining(9));//6
		System.out.println(lastRemaining(10));//8
		System.out.println(lastRemaining(11));//8
		System.out.println(lastRemaining(12));//10
		System.out.println(lastRemaining(13));//10
		System.out.println(lastRemaining(14));//12
		System.out.println(lastRemaining(34));//32

	}

}
