package janeljs.calendar;

import java.util.HashMap;

public class Calendar {
	public static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] LEAP_YEAR_LAST_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
			
	public static void printCalendar(int year, int month, String firstDay) {
		int count = 0;
		System.out.printf("     <<%4d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		HashMap<String, Integer> day = new HashMap<>();
		day.put("SU", 0);
		day.put("MO", 1);
		day.put("TU", 2);
		day.put("WE", 3);
		day.put("TH", 4);
		day.put("FR", 5);
		day.put("SA", 6);
		
		// 시작하는 요일 계산
		for (int i=0; i< day.get(firstDay); i++) {
			System.out.print("   ");
			count++;
		}
		
		// 마지막 날 계산 
		int lastDay = getLastDay(year, month);
		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%3d", i);
			count++;
			if (count%7==0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	public static int getLastDay(int year, int month) {
		int lastday = 0;
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			lastday = LEAP_YEAR_LAST_DAYS[month - 1];
		} else {
			lastday = LAST_DAYS[month - 1];
		}

		return lastday;
	}
}
