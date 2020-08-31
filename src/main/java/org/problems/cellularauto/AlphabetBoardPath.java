package org.problems.cellularauto;

/**
 * https://leetcode.com/problems/alphabet-board-path/
 * 
 * On an alphabet board, we start at position (0, 0), corresponding to character
 * board[0][0].
 * 
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in
 * the diagram below.
 * 
 * abcde 
 * fghij 
 * klmno 
 * pqrst 
 * uvwxy 
 * z
 * 
 * We may make the following moves:
 * 
 * 'U' moves our position up one row, if the position exists on the board; 
 * 'D' moves our position down one row, if the position exists on the board; 
 * 'L' moves our position left one column, if the position exists on the board; 
 * 'R' moves our position right one column, if the position exists on the board; 
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * 
 * (Here, the only positions that exist on the board are positions with letters
 * on them.)
 * 
 * Return a sequence of moves that makes our answer equal to target in the
 * minimum number of moves. You may return any path that does so.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: target = "leet" Output: "DDR!UURRR!!DDD!" 
 * 
 * Example 2:
 * 
 * Input: target = "code" Output: "RR!DDRR!UUL!R!"
 * 
 * 
 * Constraints:
 * 
 * 1 <= target.length <= 100 
 * target consists only of English lowercase letters.
 * 
 */
public class AlphabetBoardPath {
	
	static String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
	
	static int[] find(char c) {
		int[] ret = new int[2];
		for (String line : board) {
			if (line.contains(c + "")) {
				ret[1] = line.indexOf(c);
				return ret;
			}
			ret[0] ++;
		}
		return ret;
	}
	
	static void addSeq(char c, int times, StringBuilder sb) {
		for (int i = 0; i < times; i++) {
			sb.append(c);
		}
	}
	
	static void addXSeq(int srcX, int destX, StringBuilder sb) {
		int dx = destX - srcX;
		if (dx < 0) {
			addSeq('U', Math.abs(dx), sb);
		} else if (dx > 0) {
			addSeq('D', Math.abs(dx), sb);
		}
	}

	static void addYSeq(int srcY, int destY, StringBuilder sb) {
		int dy = destY - srcY;
		if (dy < 0) {
			addSeq('L', Math.abs(dy), sb);
		} else if (dy > 0) {
			addSeq('R', Math.abs(dy), sb);
		}
	}

	
	static void add(int[] src, char c, StringBuilder sb) {
		int[] dest = find(c);
		if (dest[0] == src[0] && dest[1] == src[1]) {
			addSeq('!', 1, sb);
			return;
		}
		if (src[0] != 5 && dest[0] != 5) {
			addXSeq(src[0], dest[0], sb);
			addYSeq(src[1], dest[1], sb);
			addSeq('!', 1, sb);
		}else if (src[0] == 5) {
			addXSeq(src[0], dest[0], sb);
			addYSeq(src[1], dest[1], sb);
			addSeq('!', 1, sb);
		}else if (dest[0] == 5) {
			addYSeq(src[1], dest[1], sb);
			addXSeq(src[0], dest[0], sb);
			addSeq('!', 1, sb);
		}
		src[0] = dest[0];
		src[1] = dest[1];
	}
	
	public static String alphabetBoardPath(String target) {
		StringBuilder sb = new StringBuilder();
		int[] src = new int[2];
		for (char c : target.toCharArray()) {
			add(src, c, sb);
		}
		return sb.toString();
    }

	public static void main(String[] arg) {
		System.out.println(alphabetBoardPath("leet"));
		System.out.println(alphabetBoardPath("code"));
		System.out.println(alphabetBoardPath("cdzvz"));
	}

}
