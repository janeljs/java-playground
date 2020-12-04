package janeljs.calendar;

import java.util.HashMap;

public class Calendar {
	public static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] LEAP_YEAR_LAST_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;

		}
	}

	public static int getFirstDay(int year, int month) {
		final int START_YEAR = 1970;
		final int START_DAY_OF_THE_WEEK = 4;
		int firstDay=0;

		int daySum = 0;
		for (int i = START_YEAR; i < year; i++) {
			if(!isLeapYear(i)) {
				daySum+=365;
			}
			else {
				daySum+=366;
			}
			
		}

		for (int i = 1; i < month; i++) {
			if(!isLeapYear(year)) {
				daySum += LAST_DAYS[i-1];
			}
			else {
				daySum += LEAP_YEAR_LAST_DAYS[i-1];
				
			}
		}

		firstDay = (START_DAY_OF_THE_WEEK+daySum) % 7;
		
		return firstDay;
	}

	public static void printCalendar(int year, int month) {

		System.out.printf("     <<%4d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");

		int count = 0;

		int firstDay = getFirstDay(year, month);
		
		for (int i = 0; i < firstDay; i++) {
			System.out.print("   ");
			count++;
		}

		int lastDay = getLastDay(year, month);
		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%3d", i);
			count++;
			if (count % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	public static int getLastDay(int year, int month) {
		int lastday = 0;
		if (isLeapYear(year)) {
			lastday = LEAP_YEAR_LAST_DAYS[month - 1];
		} else {
			lastday = LAST_DAYS[month - 1];
		}

		return lastday;
	}
}
