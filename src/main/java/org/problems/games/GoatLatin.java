package org.problems.games;

/**
 * https://leetcode.com/problems/goat-latin/
 *
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * The rules of Goat Latin are as follows:
 * 
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word. For example, the word 'apple' becomes 'applema'.
 * 
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter
 * and append it to the end, then add "ma". For example, the word "goat" becomes
 * "oatgma".
 * 
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1. For example, the first word gets "a" added to the
 * end, the second word gets "aa" added to the end and so on. Return the final
 * sentence representing the conversion from S to Goat Latin.
 * 
 * Example 1:
 * 
 * Input: "I speak Goat Latin" Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 
 * Example 2:
 * 
 * Input: "The quick brown fox jumped over the lazy dog" Output: "heTmaa
 * uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa
 * azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 * 
 */
public class GoatLatin {
	
	static String convert(String word, boolean[] vowels) {
		if (word.length() == 0) {
			return "";
		}
		if (vowels[word.charAt(0)]) {
			return word + "ma";
		}else {
			return word.substring(1) + word.charAt(0) + "ma";
		}
	}
	
	static String getSuffix(int counter) {
		StringBuilder sb = new StringBuilder();
		while (counter-- > 0) {
			sb.append('a');
		}
		return sb.toString();
	}

	public static String toGoatLatin(String s) {
		boolean[] vowels = new boolean[256];
		vowels['a'] = true;
		vowels['e'] = true;
		vowels['u'] = true;
		vowels['i'] = true;
		vowels['o'] = true;
		vowels['A'] = true;
		vowels['E'] = true;
		vowels['U'] = true;
		vowels['I'] = true;
		vowels['O'] = true;
		
		String[] words = s.split(" ");
		String[] updatedWords = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			updatedWords[i] = convert(words[i], vowels) + getSuffix(i+1);
		}
		return String.join(" ", updatedWords);
	}

	public static void main(String[] arg) {

		System.out.println(toGoatLatin("I speak Goat Latin"));
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));

	}
}
