package janeljs.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PlanItem {
	String format;
	String plan;
	String location;
	ArrayList<String> guests;

	public PlanItem() {
		guests = new ArrayList<>();
	}
	
	
	
	public PlanItem(String plan, String location, ArrayList<String> guests) {
		this.plan = plan;
		this.location = location;
		this.guests = guests;
	}

	public void planItem(Scanner sc, Date date) {
		System.out.println("✔️ Add Event");
		System.out.print("EVENT> ");
		plan = sc.nextLine();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		format = formatter.format(date);
		System.out.println("📆 " + format + " : " + plan + "\n" + "Successfully Registered \n");
	}

	public void planPlace(Scanner sc) {
		System.out.println("🗺️ Add location");
		System.out.print("LOCATION> ");
		location = sc.nextLine();

	}

	public void planGuest(Scanner sc) {

		System.out.println("🗺️ Add guests (press q to quit)");

		while (true) {
			System.out.print("GUEST> ");
			String guest = sc.nextLine();

			if (guest.equals("q")) {
				System.out.println("GUESTS: " + guests);
				System.out.println();
				break;
			}
			guests.add(guest);
		}

	}
}
