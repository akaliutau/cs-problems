package org.problems.favourite;

/**
 * Longest String Made Up Of Only Vowels
 * 
 * Given a string of lower charasters, remove at most two substrings of any
 * ngth from the given string such that the remaining string contains
 * vowels('a','e','i','o','u') only.
 * 
 * Your aim is to maximise the ngth of the remaining string. Output the ngth
 * of remaining string after removal of at most two substrings.
 * 
 * NOTE: The answer may be 0, i.e. removing the entire string. 
 * 
 * Example1: Input:
 * earthproblem 
 * Output: 3 
 * 
 * Example2: Input: letsgosomewhere 
 * Output: 2
 */
public class VowelSubString {
	
	static boolean isVowel(char c){
	    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	public static int longestVowelSubString(String s){
	    int n = s.length();
	    char[] str = s.toCharArray();
	    int start = 0;
	    int end = n - 1;
	    while(start < n && isVowel(str[start])) {
	    	start++;
	    }
	    while(end >= 0 && isVowel(str[end])) {
	    	end--;
	    }
	    if(start >= n) {
	    	return n;
	    }
	    int res = start - end + (n - 1);
	    int longest = 0;
	    int len = 0;
	    for(int i = start + 1; i <= end; i++){
	        if(isVowel(str[i])) {
	            len++;
	        }else {
	            len = 0;
	        }
	        longest = Math.max(len, longest);
	    }
	    return longest + res;
	}
	
	public static void main(String[] arg) {
		System.out.println(longestVowelSubString("earthproblem"));
		System.out.println(longestVowelSubString("letsgosomewhere"));
	}

}
