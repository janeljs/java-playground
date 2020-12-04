package janeljs.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Command {
	HashMap<Date, PlanItem> planSave;

	public Command() {
		planSave = new HashMap<>();
		File f = new File("plan.dat");
		if (!f.exists()) {
			return;
		}
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] words = line.split(",");
				Date date = fromStringtoDate(words[0]);
				String plan = words[1];
				String location = words[2];
				String[] strGuests = Arrays.copyOfRange(words, 3, words.length);
				ArrayList<String> alGuests = fromStringtoArrayList(strGuests);
				PlanItem p = new PlanItem(plan, location, alGuests);
				planSave.put(date, p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> fromStringtoArrayList(String[] strGuests) {
		ArrayList<String> alGuests = new ArrayList<>();
		for (String x : strGuests) {
			String temp = x.replace("[", "").replace("]", "").replace(" ", "");
			alGuests.add(temp);
			
		}
		return alGuests;
	}

	public void cmdRegister(Scanner sc) {

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

		try {
			FileWriter fw = new FileWriter("plan.dat");
			fw.write(newplan.format + "," + newplan.plan + "," + newplan.location + "," + newplan.guests);
			fw.close();
		} catch (IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}

	}

	public Date fromStringtoDate(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void cmdSearch(Scanner sc) {
		System.out.println("[SEARCH] Enter a date (yyyy-MM-dd).");
		System.out.print("DATE> ");
		String searchDate = sc.nextLine();
		Date sdate = fromStringtoDate(searchDate);
		PlanItem result = planSave.get(sdate);
		System.out.println("💖 Event: " + result.plan);
		System.out.println("🗺️ Location: " + result.location);
		int i = 1;
		System.out.println("👨‍👩‍👦‍👦 Guest List");
		for (String x : result.guests) {
			System.out.println("- Guest" + i + ": " + x);
			i++;
		}
		
		System.out.println();

	}

	public void cmdPrintCalendar(Scanner sc) {

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
