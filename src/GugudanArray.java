
public class GugudanArray {

	public static int[] calculate(int num) {
		int[] result = new int[9];
		for (int j = 1; j <= result.length; j++) {
			result[j - 1] = num * j;
		}
		return result;
	}

}
