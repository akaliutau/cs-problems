package org.problems.games;

import java.util.Arrays;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/bag-of-tokens/
 * 
 * You have an initial power P, an initial score of 0 points, and a bag of
 * tokens.
 * 
 * Each token can be used at most once, has a value token[i], and has
 * potentially two ways to use it.
 * 
 * If we have at least token[i] power, we may play the token face up, losing
 * token[i] power, and gaining 1 point. 
 * 
 * If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point. 
 * 
 * Return the largest number of points we can have after playing any number of tokens.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tokens = [100], P = 50 Output: 0 
 * 
 * Example 2:
 * 
 * Input: tokens = [100,200], P = 150 Output: 1 
 * U(100)
 * 
 * Example 3:
 * 
 * Input: tokens = [100,200,300,400], P = 200 Output: 2 
 * U(100)D(400)  U(200)U(300)
 * +1    -1      +1    +1
 * increase      gain phase
 * phase
 * 
 * 
 * 
 * Note:
 * 
 * tokens.length <= 1000 
 * 
 * 0 <= tokens[i] < 10000
 *  
 * 0 <= P < 10000
 * 
 * 
 */
public class BagOfTokens {
	
	static class Bag {
		public int[] tokens;
		public int left;
		public int right;
		public int p;
		public int points;
		
		public Bag(int[] tokens, int p) {
			this.tokens = tokens;
			this.left = 0;
			this.right = tokens.length-1;
			this.p = p;
			this.points = 0;
		}
		
		public boolean isEmpty() {
			return left >= right;
		}
		
		public boolean isFaceUpAvail() {
			return left <= right && p >= tokens[left];
		}
		
		public boolean isFaceDownAvail() {
			return points > 0;
		}
		
		public void faceUp() {
			p -= tokens[left];
			left++;
			points++;
		}
		
		public void faceDown() {
			p += tokens[right];
			right--;
			points--;
		}
		
		public int size() {
			return right-left+1;
		}
		
		@Override
		public Object clone() {
			int[] tokensCopy = new int[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				tokensCopy[i] = tokens[i];
			}
			Bag bag = new Bag(tokensCopy, p);
			return bag;
		}
		
		@Override
		public String toString() {
			return String.format("p=%d, points=%d, left=%d, right=%d", p, points, left, right);
		}


	}
	
	static void increasePowerPhase(Bag bag, int iter) {
		while (iter-- > 0 && !bag.isEmpty()) {
			if (bag.isFaceUpAvail()) {
				bag.faceUp();
				if (!bag.isEmpty()) {
					bag.faceDown();
				}
			}else {
				return;
			}
		}
	}
	
	static void gainPointsPhase(Bag bag) {
		while (bag.isFaceUpAvail()) {
			bag.faceUp();
		}
	}	
	
	public static int bagOfTokensScore(int[] tokens, int p) {
		Bag initBag = new Bag(tokens, p);
		int iterations = initBag.size()/2;
		int maxPoints = 0;
		
		Arrays.sort(tokens);
		if (tokens.length == 0) {
			return 0;
		}
		
		for (int i = 0; i < iterations+1; i++) {
			Bag copyOfBag = (Bag) initBag.clone();
			increasePowerPhase(copyOfBag, i);
			System.out.println(copyOfBag);
			Utils.print(copyOfBag.tokens);
			gainPointsPhase(copyOfBag);
			maxPoints = maxPoints < copyOfBag.points ? copyOfBag.points : maxPoints;
		}
		
		return maxPoints;
        
    }


	public static void main(String[] arg) {
		
		int[] t = {};
		System.out.println(bagOfTokensScore(t, 50));


		int[] t0 = {100};
		System.out.println(bagOfTokensScore(t0, 50));

		int[] t1 = {100, 200};
		System.out.println(bagOfTokensScore(t1, 150));

		int[] t2 = {100, 200, 300, 400};
		System.out.println(bagOfTokensScore(t2, 200));
		
		int[] t3 = {100, 200};
		System.out.println(bagOfTokensScore(t3, 400));

		int[] t4 = {4903,8812,6101,4671,6323,3378,1243,6825,6220,7885,1271,9117,7993,9168,8725};
		System.out.println(bagOfTokensScore(t4, 6810));


	}

}
