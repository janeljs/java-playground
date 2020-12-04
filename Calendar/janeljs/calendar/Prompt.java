package janeljs.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}

	public void runPrompt(Scanner sc) {
		final String COMMAND_KEYS = "🔮 command (1, 2, 3, h, q)";

		printMenu();

		boolean isLoop = true;
		while (true) {
			
			String cmd = sc.nextLine();
			switch (cmd) {
			case "1":
				Command.cmdRegister(sc);
				System.out.println(COMMAND_KEYS);
				break;
			case "2":
				Command.cmdSearch(sc);
				System.out.println(COMMAND_KEYS);
				break;
			case "3":
				Command.cmdPrintCalendar(sc);
				System.out.println(COMMAND_KEYS);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				System.out.println("Have a nice day!");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Prompt prompt = new Prompt();
		prompt.runPrompt(sc);
		sc.close();

	}

}