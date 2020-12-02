package janeljs.calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		
		Calendar cal = new Calendar();
		
		cal.getLastDay(3);
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
		System.out.println("달을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		int lastday = 0;
		if (month !=2) {
			if (month%2 == 0)
				lastday = 30;
			else {
				lastday = 31;
			}
		}
		else {
			lastday = 28;
		}
		sampleCalendar();
		System.out.printf("%d월은 %d일까지 있습니다.\n", month, lastday);
		
		sc.close();
	}

}
