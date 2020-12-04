package janeljs.calendar;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PlanItem {

	String plan;
	String location;
	String guest;
	
	public PlanItem() {}

	public PlanItem(String plan, String location, String guest) {
		this.plan = plan;
		this.location = location;
		this.guest = guest;
	}

	public void planItem(Scanner sc, Date date) {
		System.out.println("✔️ Add Event");
		System.out.print("TASK>");
		plan = sc.nextLine();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(date);
		System.out.println("📆 " + format + " : " + plan + "\n" + "Successfully Registered \n");
	}

	public void planPlace(Scanner sc, Date date) {
		System.out.println("🗺️ Add location");
		System.out.print("LOCATION>");
		location = sc.nextLine();

	}

	public void planGuest(Scanner sc, Date date) {
		ArrayList<String> guests = new ArrayList<>();
		System.out.println("🗺️ Add guests (press q to quit)");
		String guest;
		
		while (true) {
			System.out.print("GUEST>");
			guest = sc.nextLine();
			
			if (guest.equals("q")) {
				System.out.println("GUESTS: " + guests);
				System.out.println();
				break;
			}
			guests.add(guest);
		}

	}
}
