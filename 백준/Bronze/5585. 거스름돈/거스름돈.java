import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1000 - Integer.parseInt(br.readLine());
		int[] coins = {500, 100, 50, 10, 5, 1};
		int result = 0;

		for (int coin : coins) {
			if (n % coin >= 0) {
				result += (n / coin);
				n = n % coin;
			}
		}
		System.out.println(result);
	}
}