package com.leetcode.numbers;

/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: 
 * a = "11", 
 * b = " 1" 
 * 1)    1+1=0
 * 2)    1+{}+excess
 *             
 * 
 * Output: "100"
 * 
 */
public class AddBinary {

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int posA = a.length()-1;
		int posB = b.length()-1;
		int excess = 0;
		while (posA > -1 || posB > -1) {
			int c1 = posA > -1 ? a.charAt(posA) - '0' : 0; 
			int c2 = posB > -1 ? b.charAt(posB) - '0' : 0;
			int sum = c1 + c2 + excess;
			if (sum > 1) {
				excess = 1;
				sum = sum % 2;
			}else {
				excess = 0;
			}
			sb.append(sum); 
			posA--;
			posB--;
		}
		if (excess != 0) {
			sb.append('1');
		}
		return sb.reverse().toString();
        
    }


	public static void main(String[] arg) {

		System.out.println(addBinary("11","1"));
		System.out.println(addBinary("1","1"));
		System.out.println(addBinary("1000","1"));

	}
}
