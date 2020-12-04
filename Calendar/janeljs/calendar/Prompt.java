package janeljs.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		

		while(true) {
			
			System.out.println("📆 Please enter the year.");
			System.out.print("YEAR> ");
			int year = sc.nextInt();
			
			System.out.println("🈷 Please enter a month.");
			System.out.print("MONTH> ");
			int month = sc.nextInt();
			
			String blank = sc.nextLine();
			System.out.println("💖 Please enter the first day of the month. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print("DAY> ");
			String firstDay = sc.nextLine();

			System.out.println(firstDay);

			if (month > 12) {
				System.out.println("❗ 유효한 값이 아닙니다.");
				month = sc.nextInt();
			}
			if (month == -1) {
				System.out.println("Bye~");
				break;
			}
			
			Calendar.printCalendar(year, month, firstDay);

		}
		System.out.println();

		sc.close();
	}

	public static void main(String[] args) {

		Prompt prompt = new Prompt();
		prompt.runPrompt();

	}

}