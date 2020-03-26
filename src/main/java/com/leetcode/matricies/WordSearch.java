package com.leetcode.matricies;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = 
 * [ 
 * ['A','B','C','E'], 
 * ['S','F','C','S'], 
 * ['A','D','E','E'] 
 * ]
 * 
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
 * word = "ABCB", return false.
 * 
 * 
 * Constraints:
 * 
 * board and word consists only of lowercase and uppercase English letters. 
 * 1 <= board.length <= 200 
 * 1 <= board[i].length <= 200 
 * 1 <= word.length <= 10^3
 * 
 * 
 */
public class WordSearch {
	
	static class Cell {
		public char letter;
		public int row;
		public int col;
		public int id;

		public Cell(char letter, int row, int col, int id) {
			this.letter = letter;
			this.row = row;
			this.col = col;
			this.id = id;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (id != other.id)
				return false;
			return true;
		}

	}
	
	public static boolean exist(int row, int col, int rows, int cols, int pos, Cell[][] board, String word, Set<Cell> visited) {
		
		if (row >= 0 && row < rows && col >=0 && col < cols) {
			Cell cell = board[row][col];
			if (visited.contains(cell)) {
				return false;
			}
			visited.add(cell);
        	boolean isLast = pos == word.length()-1;
			if (isLast) {
				visited.remove(cell);
				return cell.letter == word.charAt(word.length()-1);
			}else {
				if (cell.letter != word.charAt(pos)) {
					visited.remove(cell);
					return false;
				}
				Queue<Integer> queue = new LinkedList<>();
		        queue.add(cell.row-1);
				queue.add(cell.col);
		        queue.add(cell.row+1);
				queue.add(cell.col);
		        queue.add(cell.row);
				queue.add(cell.col-1);
		        queue.add(cell.row);
				queue.add(cell.col+1);
		        while (!queue.isEmpty()) {
		        	int i = queue.poll();
		        	int j = queue.poll();
		        	if (exist(i, j, rows, cols, pos+1, board, word, visited) ){
		        		return true;
		        	}
		        }
				visited.remove(cell);
			}
		}
		return false;
	}
	

	public static boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        
        int n = board.length;
        int m = 0;
        if (n > 0) {
        	m = board[0].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        Cell[][] cells = new Cell[n][m];
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	if (board[i][j] == first) {
              		queue.add(i);
            		queue.add(j);
            	}
            	cells[i][j] = new Cell(board[i][j], i, j, id++);
            }
        }
        while (!queue.isEmpty()) {
        	int row = queue.poll();
        	int col = queue.poll();
        	Set<Cell> visited = new HashSet<>();
        	if (exist(row, col, n, m, 0, cells, word, visited)) {
        		return true;
        	}
        }
        
		return false;
    }

	public static void main(String[] arg) {
		
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};

		System.out.println(exist(board,"ABCCED"));//true
		System.out.println(exist(board,"SEE"));//true
		System.out.println(exist(board,"ABCB"));//false
		
		char[][] board1 = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
		};

		System.out.println(exist(board1,"ABCESEEEFS"));//true


	}
}
