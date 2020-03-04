package com.leetcode.numbers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class DaysBetweenDates {


	public static int daysBetweenDates(String date1, String date2) {
		DateFormat f = DateFormat.getDateInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = simpleDateFormat.parse(date1);
		    Date end = simpleDateFormat.parse(date2);
		    long dist = Math.round((end.getTime() - start.getTime()) / (double) 86400000);
	 		return (int) dist;
		} catch (ParseException e) {
			return 0;
		}

        
    }

	public static void main(String[] arg) {

		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		int[] arr = {}; 

		 System.out.println(daysBetweenDates("2019-06-29","2019-06-30"));
	}

}
