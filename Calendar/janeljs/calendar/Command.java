package janeljs.calendar;

import java.util.Date;
import java.util.Scanner;

public class Command {
	public static void cmdRegister(Scanner sc) {
		PlanItem planItem = new PlanItem();
		Date date = planItem.planDate(sc);
		planItem.planItem(sc, date);
		
	}

	public static void cmdSearch(Scanner sc) {

	}

	public static void cmdPrintCalendar(Scanner sc) {

		System.out.println("📆 Enter a year.");
		System.out.print("YEAR> ");
		int year = sc.nextInt();

		System.out.println("🈷 Enter a month.");
		System.out.print("MONTH> ");
		int month = sc.nextInt();

		if (year < 0 || month > 12 || month < 1) {
			System.out.println("❗ 유효한 값이 아닙니다.");
			year = sc.nextInt();
			month = sc.nextInt();
		}

		Calendar.printCalendar(year, month);

	}

}
