package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... 
 * 
 * Example 1:
 * 
 * Input: "A" Output: 1 
 * 
 * Example 2:
 * 
 * Input: "AB" Output: 28 
 * 
 * Example 3:
 * 
 * Input: "ZY" Output: 701
 * 
 * 
 * 
 */
public class ExcelColumnNumber {

	public static int titleToNumber(String s) {
		int n = s.length();
		int base = (int) Math.pow(26, n-1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += (s.charAt(i)-'A'+1)*base;
			base /= 26;
		}
		return res;
        
    }

	public static void main(String[] arg) {

		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("Z"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("ZY"));

	}
}
