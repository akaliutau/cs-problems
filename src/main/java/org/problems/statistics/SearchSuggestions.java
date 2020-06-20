package org.problems.statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 * 
 * Given an array of strings products and a string searchWord. We want to design
 * a system that suggests at most three product names from products after each
 * character of searchWord is typed. Suggested products should have common
 * prefix with the searchWord. If there are more than three products with a
 * common prefix return the three lexicographically minimums products.
 * 
 * Return list of lists of the suggested products after each character of
 * searchWord is typed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse" Output: [ ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"], ["mouse","mousepad"], ["mouse","mousepad"],
 * ["mouse","mousepad"] ] Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"] After typing m and mo all
 * products match and we show user ["mobile","moneypot","monitor"] After typing
 * mou, mous and mouse the system suggests ["mouse","mousepad"] 
 * 
 * Example 2:
 * 
 * Input: products = ["havana"], searchWord = "havana" Output:
 * [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]] 
 * 
 * Example
 * 3:
 * 
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord =
 * "bags" Output:
 * [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 * 
 * Input: products = ["havana"], searchWord = "tatiana" Output:
 * [[],[],[],[],[],[],[]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= products.length <= 1000 
 * There are no repeated elements in products. 
 * 1 <= sumof products[i].length <= 2 * 10^4 
 * All characters of products[i] are lower-case English letters. 
 * 1 <= searchWord.length <= 1000 
 * All characters of searchWord are lower-case English letters.
 * 
 * 
 * Runtime: 21 ms, faster than 68.67% of Java online submissions for Search Suggestions System.
 * Memory Usage: 58.9 MB, less than 11.75% of Java online submissions for Search Suggestions System.
 */
public class SearchSuggestions {

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		
		List<List<String>> res = new ArrayList<>();
		int n = products.length;
		int len = searchWord.length();
		String word = searchWord.substring(0, 1);
		List<String> found = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			found.add(products[i]);
		}
		Collections.sort(found);
		for (int i = 0; i < len; i++) {
			word = searchWord.substring(0, i + 1);
			List<String> subList = new ArrayList<>();
			for (String foundWord : found) {
				if (foundWord.startsWith(word)) {
					subList.add(foundWord);
				}
			}
			if (subList.isEmpty()) {
				res.add(subList);
				continue;
			}
			int counter = Math.min(3, subList.size());
			res.add(subList.subList(0, counter));
			found = subList;
		}
		
		return res;

	}

	public static void main(String[] arg) {
		
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};

		System.out.println(suggestedProducts(products, "mouse"));

		String[] products1 = {"havana"};

		System.out.println(suggestedProducts(products1, "havana"));

		String[] products2 = {"bags","baggage","banner","box","cloths"};

		System.out.println(suggestedProducts(products2, "bags"));

		String[] products3 = {"havana"};

		System.out.println(suggestedProducts(products3, "alisa"));

		String[] products4 = {"a"};

		System.out.println(suggestedProducts(products4, "a"));

	}

}
