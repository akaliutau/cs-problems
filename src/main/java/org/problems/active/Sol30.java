package org.problems.active;

/**
 * 
 */
public class Sol30 {

	static boolean checkVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	static int KDistinctVowel(String s, int k) {
		int n = s.length();

		int[] c = new int[26];
		int result = -1;

		for (int i = 0, j = -1; i < n; ++i) {

			char x = s.charAt(i);

			if (checkVowel(x)) {
				if (++c[x-'a'] == 1) {
					--k;
				}
			}

			while (k < 0) {

				x = s.charAt(++j);
				if (checkVowel(x)) {

					if (--c[x-'a'] == 0) {

						++k;
					}
				}
			}
			if (k == 0) {
				result = Math.max(result, i - j);
			}
		}
		return result;
	}

	// Driver code
	public static void main(String[] args) {
		String s = "eleetminicoworoep";
		int k = 1;
		System.out.println(KDistinctVowel(s, k));
	}

}
