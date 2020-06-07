package org.problems.cellularauto;

import java.util.LinkedList;
import java.util.Queue;

import org.problems.utils.Utils;

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
public class SurroundedRegions {
	
	static final int CHANGED = 3;
	static final int BOUNDARY = 1;
	static final int REGION = 2;
	static final int UNCHANGED = 0;
	
	static int[] directions = {-1,0, 1,0, 0,-1, 0,1};
	
	static class Cell {
		public int status = UNCHANGED;
		public boolean visited = false;
		public int region = 0;
		public int i;
		public int j;

		public Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}

	}
	
	static boolean valid(int i, int j, int rows, int cols) {
		if (i < 0 || j < 0 || i >= rows || j >= cols) {
			return false;
		}
		return true;
	}
	
	public static void solve(char[][] board) {
		int rows = board.length;
		int cols = 0;
		if (rows > 0) {
			cols = board[0].length;
		}
		Cell[][] map = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	map[i][j] = new Cell(i,j);
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
        for (int i = 1; i < cols-1; i++) {
        	if (board[0][i] == 'O') {
        		map[0][i].status = BOUNDARY;
        	}
        	if (board[rows-1][i] == 'O') {
        		map[rows-1][i].status = BOUNDARY;
        	}
        	queue.add(map[0][i]);
        	queue.add(map[rows-1][i]);
        }
        while (!queue.isEmpty()) {
        	Cell c = queue.poll();
        	c.visited = true;
        	if (c.status == REGION) {
       			c.status = CHANGED;
        	}
        	
    		for (int l = 0; l < 8; l+=2) {
    			int di = c.i + directions[l];
    			int dj = c.j + directions[l+1];
    			if (valid(di, dj, rows, cols)) {
    				Cell newCell = map[di][dj];
    				if ((c.status == CHANGED || c.status == REGION) && newCell.status == BOUNDARY) {
    						c.status = BOUNDARY;
    				}
    				if (!newCell.visited) {
    					queue.add(newCell);
    				}
    			}
    		}
        }
        boolean changes = true;
        while (changes) {
        	changes = false;
        	for (int i = 0; i < rows; i++) {
        		for (int j = 0; j < cols; j++) {
        			if (map[i][j].status == CHANGED) {
        				for (int l = 0; l < 8; l+=2) {
        					int di = i + directions[l];
        					int dj = j + directions[l+1];
        					if (valid(di, dj, rows, cols)) {
        						Cell newCell = map[di][dj];
        						if (newCell.status == BOUNDARY) {
        							map[i][j].status = BOUNDARY;
        							changes = true;
        						}
        					}
        				}
        			}
        		}
        	}
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               	if (map[i][j].status == CHANGED) {
               	    		board[i][j] = 'X'; 
               	}
            }
        }
        Utils.print(board);
    }

	public static void main(String[] arg) {
		
		char[][] board = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','X','X','X'},
				{'X','O','X','X'}
		};

		solve(board);

		char[][] board1 = {
				{'O','X','X','X'},
				{'O','O','O','X'},
				{'X','X','O','X'},
				{'X','X','X','O'},
				{'X','O','X','X'}
		};

		solve(board1);
		
		char[][] board2 = {
				{'O','X','X','X'},
				{'O','X','O','X'},
				{'X','X','O','X'},
				{'X','X','X','O'},
				{'X','O','X','X'}
		};

		solve(board2);

		char[][] board3 = {
				{'O','X','X','O','X'},
				{'X','O','O','X','O'},
				{'X','O','X','O','X'},
				{'O','X','O','O','O'},
				{'X','X','O','X','O'}
		};

		solve(board3);
		
		char[][] board4 = {
				{'X','O','X','O','X','O','O','O','X','O'},
				{'X','O','O','X','X','X','O','O','O','X'},
				{'O','O','O','O','O','O','O','O','X','X'},
				{'O','O','O','O','O','O','X','O','O','X'},
				{'O','O','X','X','O','X','X','O','O','O'},
				{'X','O','O','X','X','X','O','X','X','O'},
				{'X','O','X','O','O','X','X','O','X','O'},
				{'X','X','O','X','X','O','X','O','O','X'},
				{'O','O','O','O','X','O','X','O','X','O'},
				{'X','X','O','X','X','X','X','O','O','O'}
			};
		
		solve(board4);



	}

}
