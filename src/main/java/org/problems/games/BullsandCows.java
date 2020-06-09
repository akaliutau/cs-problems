package org.problems.games;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 * 
 * Write a function to return a hint according to the secret number and friend's
 * guess, use A to indicate the bulls and B to indicate the cows.
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits.
 * 
 * Example 1:
 * 
 * Input: secret = "1807", guess = "7810"
 * 
 * Output: "1A3B"
 * 
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * 
 * Input: secret = "1123", guess = "0111"
 * 
 * Output: "1A1B"
 * 
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a
 * cow.
 * 
 * 
 */
public class BullsandCows {
	
	public static String getHint(String secret, String guess) {
			int[] provided = new int[10];
	        String temp = "%dA%dB";
	        int nCows = 0;
	        int nBulls = 0;
	        for (int i = 0; i < secret.length(); i++) {
	        	provided[secret.charAt(i)-'0'] ++;
	        }
	        for (int i = 0; i < guess.length(); i++) {
	        	int num = guess.charAt(i)-'0';
	        	if (num == secret.charAt(i)-'0') {
	        		nBulls ++;
	    			provided[num] --;
	        	}
	        }
	        for (int i = 0; i < guess.length(); i++) {
	        	int num = guess.charAt(i)-'0';
	        	if (num != secret.charAt(i)-'0') {
	        		if (provided[num] > 0) {
	        			nCows ++;
	        			provided[num] --;
	        		}
	        	}
	        }
	        
	        return String.format(temp, nBulls, nCows);
	}

	public static void main(String[] arg) {

		System.out.println(getHint("1807","7810"));// 1A3B
		System.out.println(getHint("1123","0111"));// 1A1B
		System.out.println(getHint("1122","2211"));// 0A4B
		System.out.println(getHint("1122","1222"));// 3A0B

	}
}
