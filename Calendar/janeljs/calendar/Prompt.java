package janeljs.calendar;

import java.util.Scanner;

public class Prompt {


	public void runPrompt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("📆 Please enter the year.");
		System.out.print("YEAR> ");
		int year = sc.nextInt();
		System.out.println("🔢 Please enter the number of calendars you want to print.");
		System.out.print("NUMBER> ");
		int N = sc.nextInt();
		int[] monthArr = new int[N];
		int[] lastdayArr = new int[N];
		System.out.println("🈷 Please enter a month.");
		
		for (int i = 0; i < N; i++) {
			System.out.print("MONTH> ");
			monthArr[i] = sc.nextInt();
			String blank = sc.nextLine();
			System.out.println("💖 Please enter the first day of the month. (SU, MO, WE, TH, FR, SA)");
			System.out.print("DAY> ");
			String firstDay = sc.nextLine();
			
			System.out.println(firstDay);
			
			
			if (monthArr[i] > 12) {
				System.out.println("❗ 유효한 값이 아닙니다.");
				monthArr[i] = sc.nextInt();
			}
			if (monthArr[i] == -1) {
				System.out.println("Bye~");
				break;
			}
			lastdayArr[i] = Calendar.getLastDay(year, monthArr[i]);
			Calendar.printCalendar(year, monthArr[i], firstDay);
			
			
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			if (monthArr[i] == -1) {
				break;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", monthArr[i], lastdayArr[i]);

		}

		sc.close();
	}

	public static void main(String[] args) {

		Prompt prompt = new Prompt();
		prompt.runPrompt();

	}

}
