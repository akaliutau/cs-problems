package org.problems.time;

/**
 * https://leetcode.com/problems/reformat-date/
 * 
 * Given a date string in the form Day Month Year, where:
 * 
 * Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}. Month is
 * in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
 * "Oct", "Nov", "Dec"}. Year is in the range [1900, 2100]. Convert the date
 * string to the format YYYY-MM-DD, where:
 * 
 * YYYY denotes the 4 digit year. MM denotes the 2 digit month. DD denotes the 2
 * digit day.
 * 
 * 
 * Example 1:
 * 
 * Input: date = "20th Oct 2052" Output: "2052-10-20"
 * 
 */
public class ReformatDate {

	public String reformatDate(String date) {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String[] parts = date.split(" ");
		char c = parts[0].charAt(1);
		int day = 0;
		if (c >= '0' && c <= '9') {
			day = Integer.valueOf(parts[0].substring(0, 2));
		} else {
			day = Integer.valueOf(parts[0].substring(0, 1));
		}
		int month = 0;
		for (int i = 0; i < 12; i++) {
			if (months[i].equals(parts[1])) {
				month = i;
				break;
			}
		}
		return String.format("%s-%s-%s", parts[2], month <= 9 ? ("0" + month) : month, day <= 9 ? ("0" + day) : day);
	}

	public static void main(String[] arg) {
		System.out.println(true);
	}

}
