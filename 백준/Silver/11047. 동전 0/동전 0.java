import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];
		int result = 0;

		// 배열 coins 에 주어진 동전 가치를 할당
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		// 동전가치가 오름차순으로 주어지므로 coins 를 뒤에서부터 앞으로 돌아야한다
		for (int i = (n -1); i >= 0; i--) {
			result += k / coins[i];
			k %= coins[i];
		}

		System.out.println(result);
	}
}