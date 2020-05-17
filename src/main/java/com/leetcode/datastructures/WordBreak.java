package com.leetcode.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". 
 * 
 * Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. 
 * 
 * Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
public class WordBreak {
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		
		
		Queue<Integer> queue = new LinkedList<>();
		int n = s.length();
        boolean visited[] = new boolean[n];
        int pos = 0;
        queue.add(pos);
        visited[0] = true;
        while(!queue.isEmpty()){
            pos = queue.poll();
            for(String word : wordDict){
                if(s.startsWith(word, pos)) {
                    int next = pos + word.length();
                    if(n == next) {
                    	return true;
                    }
                    if(!visited[next]){
                    	queue.add(next);  
                        visited[next] = true;
                    }
                }
            }
        }
        return pos == n;
        
    }

	public static void main(String[] arg) {
		
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(wordBreak("catsandog", wordDict));

		List<String> wordDict0 = Arrays.asList("go","goal","goals","special");
		System.out.println(wordBreak("goalspecial", wordDict0));

		List<String> wordDict1 = Arrays.asList("apple", "pen");
		System.out.println(wordBreak("applepenapple", wordDict1));

		List<String> wordDict2 = Arrays.asList("leet", "code");
		System.out.println(wordBreak("leetcode", wordDict2));

		List<String> wordDict3 = Arrays.asList("a", "aa", "aaa", "aaaa");
		System.out.println(wordBreak("aaaaaaaaaaaaaaaa", wordDict3));

		List<String> wordDict4 = Arrays.asList("leet", "code");
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaa", wordDict4));

		List<String> wordDict5 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict5));

		List<String> wordDict6 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict6));

	}

}
