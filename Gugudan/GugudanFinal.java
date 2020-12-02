import java.util.Scanner;

public class GugudanFinal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] data = sc.nextLine().split(" ");
		int n = Integer.parseInt(data[0]);
		int m = Integer.parseInt(data[1]);
		
		for (int j = 1; j <= m; j++) {
			System.out.println(n + "단: " + n + "x" + j + "=" + n * j);
		}
		sc.close();
	}
}
