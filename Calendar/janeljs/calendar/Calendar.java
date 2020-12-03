package janeljs.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {

		Calendar cal = new Calendar();
		cal.getLastDay(3);
		cal.sampleCalendar(3);
	}

	public void sampleCalendar(int month) {
		System.out.println(" 일 월 화 수 목 금 토");
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

	public void getLastDay(int month) {
		String PROMPT = "cal> ";
		System.out.println("반복 횟수를 입력하세요.");
		System.out.print(PROMPT);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] monthArr = new int[N];
		int[] lastdayArr = new int[N];
		System.out.println("달을 입력하세요.");
		for (int i = 0; i < N; i++) {
			System.out.print(PROMPT);
			monthArr[i] = sc.nextInt();

			if (monthArr[i] > 12) {
				System.out.println("유효한 값이 아닙니다.");
				monthArr[i] = sc.nextInt();
			}
			if (monthArr[i] == -1) {
				System.out.println("Bye~");
				break;
			}

			if (monthArr[i] != 2) {
				if (monthArr[i] % 2 == 0)
					lastdayArr[i] = 30;
				else {
					lastdayArr[i] = 31;
				}
			} else {
				lastdayArr[i] = 28;
			}

		}

		for (int i = 0; i < N; i++) {
			if (monthArr[i] == -1) {
				break;
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", monthArr[i], lastdayArr[i]);
		}

		sc.close();
	}

}
