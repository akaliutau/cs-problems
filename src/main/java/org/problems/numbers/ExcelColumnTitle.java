package org.problems.numbers;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 
 * 1 -> A 
 * 2 -> B 
 * 3 -> C 
 * ... 
 * 26 -> Z 
 * 
 * 27 -> AA 
 * 28 -> AB 
 * ...
 * 
 *  1-digit block - [1,26^1+(1-1)]
 *  2-digit block - [27,26^2+(27-1)]
 * 
 * Example 1:
 * 
 * Input: 1 Output: "A" 
 * 
 * Example 2:
 * 
 * Input: 28 Output: "AB"
 * 
 * 
 */
public class ExcelColumnTitle {

	public static String convertToTitle(int n) {

       StringBuilder sb = new StringBuilder();

        while (n>0) {
            n--;
            int t = n % 26;
            sb.append((char) (t+65));
            n = n/26;
        }
        return sb.reverse().toString();	        
	}
	 
	public static void main(String[] arg) {

		System.out.println(convertToTitle(1));//A
		System.out.println(convertToTitle(2));//B
		System.out.println(convertToTitle(26));//Z
		System.out.println(convertToTitle(27));//AA
		System.out.println(convertToTitle(28));//AB
		System.out.println(convertToTitle(52));//AZ
		System.out.println(convertToTitle(701));//ZY
		System.out.println(convertToTitle(27313));//ANJM

	}
}
