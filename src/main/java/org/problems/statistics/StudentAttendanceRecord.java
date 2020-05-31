package org.problems.statistics;

/**
 * https://leetcode.com/problems/student-attendance-record-i/
 * 
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters: 
 * 'A' : Absent. 
 * 'L' : Late. 
 * 'P' : Present. 
 * 
 * A student could be rewarded if his attendance record
 * doesn't contain more than one 'A' (absent) or more than two continuous 'L'
 * (late).
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL" Output:
 * False
 * 
 * 
 */
public class StudentAttendanceRecord {

	public static boolean checkRecord(String s) {
		int aCounter = 0;
		int lCounter = 0;
		if (s.length() == 0) {
			return true;
		}
		char prev = 'E';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				aCounter ++;
				lCounter = 0;
			} else if (c == 'L') {
				if (prev == 'L') {
					lCounter ++;
				}else {
					lCounter = 1;
				}
				if (lCounter > 2) {
					return false;
				}
			} else if (c == 'P') {
				lCounter = 0;
			}
			prev = c;
		}
		return aCounter <= 1 && lCounter <= 2;

	}

	public static void main(String[] arg) {

		System.out.println(checkRecord("PPALLP"));
		System.out.println(checkRecord("PPALLALPPLLLP"));
		System.out.println(checkRecord("PPALLL"));
		System.out.println(checkRecord("LLLALL"));

	}

}
