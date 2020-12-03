package janeljs.calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {

		Calendar cal = new Calendar();
		cal.getLastDay(3);
		cal.sampleCalendar();
	}

	public void sampleCalendar() {
		System.out.println(" 일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
		System.out.println();
	}

	public void getLastDay(int month) {
		System.out.println("반복 횟수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] monthArr = new int[N];
		int[] lastdayArr = new int[N];
		System.out.println("달을 입력하세요.");
		for (int i = 0; i < N; i++) {
			
			monthArr[i] = sc.nextInt();

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
			System.out.printf("%d월은 %d일까지 있습니다.\n", monthArr[i], lastdayArr[i]);
		}

		sc.close();
	}

}
