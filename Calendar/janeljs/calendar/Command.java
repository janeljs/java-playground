package janeljs.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Command {
	static HashMap<Date, PlanItem> planSave = new HashMap<>();
	public static void cmdRegister(Scanner sc) {
		
		System.out.println("\n[CREATE] Enter a date (yyyy-MM-dd).");
		System.out.print("DATE> ");
		String strDate = sc.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		PlanItem newplan = new PlanItem();
		System.out.println();
		newplan.planItem(sc, date);
		newplan.planPlace(sc);
		System.out.println();
		newplan.planGuest(sc);

		planSave.put(date, newplan);
		

	}

	public static void cmdSearch(Scanner sc) {
		System.out.println("[SEARCH] Enter a date (yyyy-MM-dd).");
		String searchDate = sc.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(searchDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		PlanItem result = planSave.get(date);
		System.out.println("💖 Event: " + result.plan);
		System.out.println("🗺️ Location: " + result.location);
		int i = 1;
		System.out.println("👨‍👩‍👦‍👦 Guest List");
		for (String x:result.guests) {
			System.out.println("- Guest" + i + ": "+ x);
			i ++;
		}
		System.out.println();
		
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
