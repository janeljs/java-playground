package janeljs.calendar;

import java.util.Scanner;

public class Calendar {

	

	public static void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년 %d월>>\n", year, month);
		System.out.println("SU MO TU WE TH FR SA");
		System.out.println("--------------------");
		
		int temp = 0;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				int result = temp + j;
				if (result<10) {
					System.out.print(" " + result + " ");
				}
				else {
					if (month==2 && result>28) {
						break;
					}
					if (month%2==0 && result>30) {
						break;
					}
					if (result>31) {
						break;
					}
					System.out.print(result + " ");
					}
				if (j == 7) {
					temp = i * j;
				}
			}
			System.out.println();
		}
	}

	public static int getLastDay(int month) {
		int lastday = 0;
		if (month != 2) {
			if (month % 2 == 0)
				lastday = 30;
			else {
				lastday = 31;
			}
		} else {
			lastday = 28;
		}
		return lastday;
	}
}
