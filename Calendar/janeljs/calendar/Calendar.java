package janeljs.calendar;

public class Calendar {
	public static final int[] LAST_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static final int[] LEAP_YEAR_LAST_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void printCalendar(int year, int month) {
		System.out.printf("     <<%4d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");

		int lastDay = getLastDay(year, month);
		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) {
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
