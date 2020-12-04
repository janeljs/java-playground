package janeljs.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class PlanItem {
	HashMap<Date, PlanItem> planSave;
	public PlanItem() {
		 planSave = new HashMap<>();
	}

	
	public Date planDate(Scanner sc) {
		System.out.println("📆 Enter a date (yyyy-MM-dd).");
		System.out.print("DATE>");
		String strDate = sc.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			planSave.put(date, null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	public void planItem(Scanner sc, Date date) {
		System.out.println("✔️ Add Event");
		System.out.print("TASK>");
		String todoItem = sc.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(date);
		System.out.println("📆 " + format + " : " + todoItem + "\n" + "Successfully Registered \n");
	}

	public void planPlace(Scanner sc, String date) {
		System.out.println("🗺️ Add location");
		System.out.println("LOCATION>");
	}

	public void planGuest(Scanner sc, String date) {
		System.out.println("🗺️ Add guests (press q to quit)");
		while (true) {
			System.out.println("GUESTS>");
			String guest = sc.nextLine();
			if (guest.equals("q")) {
				break;
			}
		}

	}
}
