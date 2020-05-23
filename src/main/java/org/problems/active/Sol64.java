package org.problems.active;

/**
 *
 * 
 */
public class Sol64 {

	static boolean getLetter(int[] amount, int idx, int[] letter) {
		idx = idx % 3;
		if (amount[idx] > 0) {
			amount[idx]--;
			letter[0] = idx;
			letter[1]++;
			return true;
		}
		return false;
	}

	public static String longestDiverseString(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		int maxLen = 2 * (a + b + c);
		// 0 - code of letter, 1 - amount
		int[][] hist = new int[maxLen][2];
		int[] amount = new int[3];
		amount[0] = a;
		amount[1] = b;
		amount[2] = c;

		int major = 0;
		if (c >= a && c >= b) {
			major = 2;
		} else if (a >= b && a >= c) {
			major = 0;
		} else {
			major = 1;
		}

		int idx = 0;
		boolean contunuie = amount[major] > 0;
		while (contunuie) {
			boolean isNext = getLetter(amount, major, hist[idx]);
			if (isNext) {
				idx++;
			}
			boolean isNext1 = getLetter(amount, major + 1, hist[idx]);
			if (isNext1) {
				idx++;
			}
			boolean isNext3 = getLetter(amount, major, hist[idx]);
			if (isNext3) {
				idx++;
			}
			boolean isNext2 = getLetter(amount, major + 2, hist[idx]);
			if (isNext2) {
				idx++;
			}
			contunuie = amount[major] > 0 && (isNext1 || isNext2);
		}
		// check last
		if (idx > 0 && hist[idx - 1][0] != major && amount[major] > 0) {
			hist[idx][0] = major;
			hist[idx][1]++;
			amount[major]--;
			idx++;
		}

		// optimize
		int i = 0;
		boolean empty = amount[0] == 0 && amount[1] == 0 && amount[2] == 0;
		while (i < idx && !empty) {
			int let = hist[i][0];
			if (amount[let] > 0) {
				hist[i][1]++;
				amount[let]--;
			}
			i++;
			empty = amount[0] == 0 && amount[1] == 0 && amount[2] == 0;
		}
		// render
		for (int j = 0; j < idx; j++) {
			int let = hist[j][0];
			if (hist[j][1] == 2) {
				sb.append((char) (let + 'a'));
				sb.append((char) (let + 'a'));
			} else if (hist[j][1] == 1) {
				sb.append((char) (let + 'a'));
			}
		}

		return sb.toString().replace("aaaa", "aa").replace("cccc", "cc").replace("bbbb", "bb").replace("aaa", "aa")
				.replace("ccc", "cc").replace("bbb", "bb").replace("aaa", "aa").replace("ccc", "cc")
				.replace("bbb", "bb");
	}

	public static void main(String[] arg) {

		System.out.println(longestDiverseString(1, 1, 7));
		System.out.println(longestDiverseString(2, 2, 1));
		System.out.println(longestDiverseString(7, 1, 0));

	}

}
