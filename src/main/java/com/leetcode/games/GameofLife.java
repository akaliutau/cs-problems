package com.leetcode.games;

import com.leetcode.utils.Utils;

/**
 * https://leetcode.com/problems/game-of-life/
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population. 
 * 
 * Any live cell with two or three live neighbors lives on to
 * the next generation. 
 * 
 * Any live cell with more than three live neighbors dies,
 * as if by over-population.. 
 * 
 * Any dead cell with exactly three live neighbors
 * becomes a live cell, as if by reproduction. 
 * 
 * Write a function to compute the
 * next state (after one update) of the board given its current state. The next
 * state is created by applying the above rules simultaneously to every cell in
 * the current state, where births and deaths occur simultaneously.
 * 
 * Example:
 * 
 * Input: 
 * [ 
 * [0,1,0], 
 * [0,0,1], 
 * [1,1,1], 
 * [0,0,0] 
 * ] 
 * 
 * Output: 
 * [ 
 * [0,0,0], 
 * [1,0,1],
 * [0,1,1], 
 * [0,1,0] 
 * ]
 */
public class GameofLife {
	
	static int DEAD = 4;
	static int BORN = 2;
	
	static int getStatus(int i, int j, int n, int m, int[][] board) {
		if (i >= 0 && i < n && j >= 0 && j < m) {
			return board[i][j] & 1;
		}
		return 0;
	}
	
	static int getNeighbors(int i, int j, int n, int m, int[][] board) {
		int counter = 0;
		counter += getStatus(i-1, j, n, m, board);
		counter += getStatus(i-1, j-1, n, m, board);
		counter += getStatus(i-1, j+1, n, m, board);
		counter += getStatus(i, j-1, n, m, board);
		counter += getStatus(i, j+1, n, m, board);
		counter += getStatus(i+1, j, n, m, board);
		counter += getStatus(i+1, j-1, n, m, board);
		counter += getStatus(i+1, j+1, n, m, board);
		return counter;
		
	}

    public static void gameOfLife(int[][] board) {
    	int n = board.length;
    	int m = 0;
    	if (n > 0) {
    		m = board[0].length;
    	}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	int total = getNeighbors(i, j, n, m, board);
            	if (total < 2) {
            		board[i][j] = DEAD | board[i][j];
            	}else if (total > 3){
               		board[i][j] = DEAD | board[i][j];
            	}else if (total == 3){
            		board[i][j] = BORN | board[i][j];
            	}
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	if ((board[i][j] & DEAD) != 0) {
            		board[i][j] = 0;
            	}else if ((board[i][j] & BORN) != 0) {
            		board[i][j] = 1;
            	}else {
            		board[i][j] = board[i][j] & 1;
            	}
            }
        }
    }

	public static void main(String[] arg) {

		int[][] board = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0},
		};
		gameOfLife(board);
		Utils.print(board);
	}
}
