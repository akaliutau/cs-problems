package com.leetcode.matricies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * Input: board = 
 * [ 
 * ['o','a','a','n'], 
 * ['e','t','a','e'], 
 * ['i','h','k','r'],
 * ['i','f','l','v'] 
 * ] 
 * 
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * Note:
 * 
 * All inputs are consist of lowercase letters a-z. The values of words are
 * distinct.
 * 
 */
public class WordSearchII {

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

	public static boolean exist(int row, int col, int rows, int cols, int pos, Cell[][] board, String word,
			Set<Cell> visited) {

		if (row >= 0 && row < rows && col >= 0 && col < cols) {
			Cell cell = board[row][col];
			if (visited.contains(cell)) {
				return false;
			}
			visited.add(cell);
			boolean isLast = pos == word.length() - 1;
			if (isLast) {
				visited.remove(cell);
				return cell.letter == word.charAt(word.length() - 1);
			} else {
				if (cell.letter != word.charAt(pos)) {
					visited.remove(cell);
					return false;
				}
				if (exist(cell.row - 1, cell.col, rows, cols, pos + 1, board, word, visited)) {
					return true;
				}else if (exist(cell.row + 1, cell.col, rows, cols, pos + 1, board, word, visited)) {
					return true;
				}else if (exist(cell.row, cell.col - 1, rows, cols, pos + 1, board, word, visited)) {
					return true;
				}else if (exist(cell.row, cell.col + 1, rows, cols, pos + 1, board, word, visited)) {
					return true;
				}
				visited.remove(cell);
			}
		}
		return false;
	}

	public static boolean exist(char[][] board, String word, int n, int m, Cell[][] cells, Queue<Cell> queue) {
		while (!queue.isEmpty()) {
			Cell c = queue.poll();
			Set<Cell> visited = new HashSet<>();
			if (exist(c.row, c.col, n, m, 0, cells, word, visited)) {
				return true;
			}
		}

		return false;
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> found = new ArrayList<>();
		int n = board.length;
		int m = 0;
		if (n > 0) {
			m = board[0].length;
		}
		
		int id = 0;
		Cell[][] cells = new Cell[n][m];
		Map<String,Queue<Cell>> queued = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cells[i][j] = new Cell(board[i][j], i, j, id++);
				for (String word : words) {
					char first = word.charAt(0);
					if (board[i][j] == first) {
						if (!queued.containsKey(word)) {
							queued.put(word, new LinkedList<>());
						}
						Queue<Cell> queue = queued.get(word);
						queue.add(cells[i][j]);
					}
				}
			}
		}


		if (words.length > 0) {
			for (String word : words) {
				if (!queued.containsKey(word)) {
					continue;
				}
				if (exist(board,word, n, m, cells,queued.get(word))) {
					found.add(word);
				}
			}
		}
		return found;
        
    }

	public static void main(String[] arg) {

		char[][] board = { { 'o','a','a','n' }, { 'e','t','a','e' }, { 'i','h','k','r' }, {'i','f','l','v'} };
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(findWords(board, words));

	}
}
