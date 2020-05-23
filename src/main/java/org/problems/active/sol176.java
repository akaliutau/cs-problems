package org.problems.active;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * X X X X
 * X O O X 
 * X X O X 
 * X O X X 
 * 
 * After running your function, the board should
 * be:
 * 
 * X X X X 
 * X X X X 
 * X X X X 
 * X O X X 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
public class sol176 {
	
	static final int BOUNDARY = 1;
	static final int REGION = 2;
	static final int UNCHANGED = 0;
	
	static int[] directions = {-1,0, 1,0, 0,-1, 0,1};
	
	static class Cell {
		public int status = UNCHANGED;
		public boolean visited = false;
		public int region = 0;
	}
	
	static boolean valid(int i, int j, int rows, int cols) {
		if (i < 0 || j > 0 || i >= rows || j >= cols) {
			return false;
		}
		return true;
	}
	
	static int getRegion(Cell[][] map, int i, int j, int rows, int cols) {
		for (int l = 0; l < 8; l+=2) {
			int di = directions[l];
			int dj = directions[l+1];
			if (valid(i+di, j + dj, rows, cols) && map[i][j].status == REGION && map[i][j].region != 0) {
				return map[i][j].region;
			}
		}
		return 0;
	}
	
	static boolean isBoundary(Cell[][] map, int i, int j, int rows, int cols) {
		if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
			return true;
		}
		for (int l = 0; l < 8; l+=2) {
			int di = directions[l];
			int dj = directions[l+1];
			if (valid(i+di, j + dj, rows, cols)) {
				return map[i][j].status == BOUNDARY;
			}
		}
		return false;
	}

	public void solve(char[][] board) {
		int rows = board.length;
		int cols = 0;
		if (rows > 0) {
			cols = board[0].length;
		}
		Cell[][] map = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	map[i][j] = new Cell();
            	if (board[i][j] == 'O') {
            		map[i][j].status = REGION;
            	}
            }
        }
        
        Queue<Cell> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
        	if (board[i][0] == 'O') {
        		map[i][0].status = BOUNDARY;
        	}
        	if (board[i][cols-1] == 'O') {
        		map[i][cols-1].status = BOUNDARY;
        	}
        	queue.add(map[i][0]);
        	queue.add(map[i][cols-1]);
        }
        for (int i = 0; i < cols; i++) {
        	if (board[0][cols] == 'O') {
        		map[0][cols].status = BOUNDARY;
        	}
        	if (board[rows-1][cols] == 'O') {
        		map[rows-1][cols].status = BOUNDARY;
        	}
        	queue.add(map[0][cols]);
        	queue.add(map[rows-1][cols]);
        }
        while (!queue.isEmpty()) {
        	
        }
        
    }

	public static void main(String[] arg) {

		System.out.println(true);

	}

}
