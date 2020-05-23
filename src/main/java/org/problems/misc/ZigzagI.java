package org.problems.misc;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows
 * 
 * 
 * Runtime: 3 ms, faster than 91.43% of Java online submissions for ZigZag
 * Conversion. Memory Usage: 40.9 MB, less than 26.60% of Java online
 * submissions for ZigZag Conversion.
 */
public class ZigzagI {

	public static String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {// all except last line
			int cycle = 0;
			int index = numRows > 1 ? cycle * (2 * numRows - 2) + i : cycle;
			while (index < s.length()) {
				sb.append(s.charAt(index));
				if (i != 0 && i != numRows - 1) {
					int indexTwo = 2 * numRows - 2 - 2 * i + index;
					if (indexTwo < s.length()) {
						sb.append(s.charAt(indexTwo));
					}
				}
				cycle++;
				index = numRows > 1 ? cycle * (2 * numRows - 2) + i : cycle;
			}
		}

		return sb.toString();

	}

	public static void main(String[] arg) {
		// 0 1 2 3

		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
		System.out.println(convert("A", 1));

	}
}
