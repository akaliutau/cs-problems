package org.problems.datastructures;

/**
 * https://leetcode.com/problems/design-browser-history/
 * 
 * You have a browser of one tab where you start on the homepage and you can
 * visit another url, get back in the history number of steps or move forward in
 * the history number of steps.
 * 
 * Implement the BrowserHistory class
 * 
 * Runtime: 46 ms, faster than 100.00% of Java online submissions for Design Browser History.
 * Memory Usage: 48 MB, less than 100.00% of Java online submissions for Design Browser History.
 */
public class BrowserHistoryImpl {

	public static class BrowserHistory {

		int cur = 0;
		int size = 0;
		String[] history = new String[101];

		public BrowserHistory(String homepage) {
			history[0] = homepage;
			cur++;
			size++;
		}

		public void visit(String url) {
			if (cur == 101) {
				cur = 100;
				for (int i = 0; i < 100; i++) {
					history[i] = history[i + 1];
				}
			}
			history[cur++] = url;
			size = cur;
		}

		public String back(int steps) {
			int diff = cur - steps - 1 < 0 ? 0 : cur - steps - 1;
			cur = diff + 1;
			return history[cur - 1];
		}

		public String forward(int steps) {
			int diff = cur + steps > size ? size : cur + steps;
			cur = diff;
			return history[cur - 1];
		}
	}

	/**
	 * Your BrowserHistory object will be instantiated and called as such:
	 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
	 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
	 */

	public static void main(String[] arg) {

		BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

		browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
		System.out.println(browserHistory.back(1)); // You are in "youtube.com", move back to "facebook.com" return
													// "facebook.com"
		System.out.println(browserHistory.back(1)); // You are in "facebook.com", move back to "google.com" return
													// "google.com"
		System.out.println(browserHistory.forward(1)); // You are in "google.com", move forward to "facebook.com" return
														// "facebook.com"
		browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
		System.out.println(browserHistory.forward(2)); // You are in "linkedin.com", you cannot move forward any steps.
		System.out.println(browserHistory.back(2)); // You are in "linkedin.com", move back two steps to "facebook.com"
													// then to "google.com". return "google.com"
		System.out.println(browserHistory.back(7)); // You are in "google.com", you can move back only one step to
													// "leetcode.com". return "leetcode.com"

	}

}
