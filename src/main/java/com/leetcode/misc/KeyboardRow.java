package com.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/keyboard-row/
 * 
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below
 * 
 * Example:
 * 
 * Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska", "Dad"]
 * 
 * 
 * Note:
 * 
 * You may use one character in the keyboard more than once. You may assume the
 * input string will only contain letters of alphabet
 * 
 * 
 */
public class KeyboardRow {
	
	static char[][] board = {
		{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
		{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'},
		{'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'}
	};
	
	static boolean isValid(boolean[][] lines, String word) {
		int line = -1;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			for (int l = 0; l < 3; l++) {
				if (lines[l][c]) {
					if (line == -1) {
						line = l;
					}else {
						if (line != l) {
							return false;
						}
					}
					break;
				}
			}
		}
		return true;
	}

	public static String[] findWords(String[] words) {
		boolean[][] lines = new boolean[3][256];
		for (int line = 0; line < board.length; line ++) {
			char[] l = board[line];
			for (int i = 0; i < l.length; i++) {
				lines[line][l[i]] = true;
			}
		}
		List<String> res = new ArrayList<>();
		for (String word : words) {
			if (isValid(lines, word.toLowerCase())) {
				res.add(word);
			}
		}
		
		return res.toArray(new String[res.size()]);

	}

	public static void main(String[] arg) {
		
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};

		System.out.println(Arrays.toString(findWords(words)));

	}

}
