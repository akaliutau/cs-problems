package org.problems.games;

import org.problems.utils.Utils;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 * 
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
 * 
 * Here are the rules of Tic-Tac-Toe:
 * 
 * Players take turns placing characters into empty squares (" "). The first
 * player A always places "X" characters, while the second player B always
 * places "O" characters. "X" and "O" characters are always placed into empty
 * squares, never on filled ones. The game ends when there are 3 of the same
 * (non-empty) character filling any row, column, or diagonal. The game also
 * ends if all squares are non-empty. No more moves can be played if the game is
 * over. Given an array moves where each element is another array of size 2
 * corresponding to the row and column of the grid where they mark their
 * respective character in the order in which A and B play.
 * 
 * Return the winner of the game if it exists (A or B), in case the game ends in
 * a draw return "Draw", if there are still movements to play return "Pending".
 * 
 * You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the
 * grid is initially empty and A will play first
 * 
 */
public class TicTacToe {
	
	static boolean checkComplete(int[][] brd) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (brd[i][j] == 0) {
					return false;
				}
			}			
		}
		return true;
	}
	
	static boolean check(int[][] brd, int player) {
		for (int i = 0; i < 3; i++) {
			boolean line = true;
			for (int j = 0; j < 3; j++) {
				if (brd[i][j] != player || brd[i][j] == 0) {
					line = false;
					break;
				}
			}
			if (line) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			boolean line = true;
			for (int j = 0; j < 3; j++) {
				if (brd[j][i] != player || brd[j][i] == 0) {
					line = false;
					break;
				}
			}
			if (line) {
				return true;
			}
		}
		boolean line = true;
		for (int i = 0; i < 3; i++) {
			if (brd[i][i] != player || brd[i][i] == 0) {
				line = false;
				break;
			}
		}
		if (line) {
			return true;
		}
		line = true;
		for (int i = 0; i < 3; i++) {
			if (brd[i][2 - i] != player || brd[i][2 - i] == 0) {
				line = false;
				break;
			}
		}
		if (line) {
			return true;
		}
		return false;
	}
	
	public static String tictactoe(int[][] moves) {
        int n = moves.length;
        int[][] brd = new int[3][3];
        int player = 1;
        for (int[] move : moves) {
        	brd[move[0]][move[1]] = player;
        	player = player == 1 ? 2 : 1;
        }
        Utils.print(brd);
        if (check(brd,1)) {
        	return "A";
        }
        if (check(brd,2)) {
        	return "B";
        }
        if (!checkComplete(brd)) {
        	return "Pending";
        }
        return "Draw";
    }

	public static void main(String[] arg) {
		int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
		System.out.println(tictactoe(moves));

		int[][] moves1 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
		System.out.println(tictactoe(moves1));

		int[][] moves2 = {{0,0},{1,1}};
		System.out.println(tictactoe(moves2));

}

}
