import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		System.out.println("구구단 중 출력할 단은? : ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		for (int j = 1; j < 10; j++) {
			System.out.println(i + "단:" + i + "x" + j + "=" + i * j);
		}
	}
}
