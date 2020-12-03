package janeljs.calendar;

public class Calendar {

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
	}

	public static int getLastDay(int year, int month) {
		int lastday = 0;

		if (month % 2 == 0) {
			if (month != 2) {
				lastday = 30;
			} else if (month == 2) {
				if (year % 4 == 0) {
					if (year % 100 == 0) {
						if (year % 400 == 0) {
							lastday = 29;
						} else {
							lastday = 28;
						}
					} else {
						lastday = 29;
					}
				}
			}
		} else {
			lastday = 31;
		}

		return lastday;
	}
}
