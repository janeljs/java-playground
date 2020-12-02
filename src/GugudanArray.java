import java.util.Arrays;

public class GugudanArray {

	public static void main(String[] args) {
		int[] result = new int[9];
		for (int i=1; i<=result.length; i++) {
			for (int j=1; j<=result.length; j++) {
				result[j-1] = i*j;
			}
			System.out.println(i + "단: " + Arrays.toString(result));
		}	
	}
}
