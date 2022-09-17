import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		boolean[] array = new boolean[n + 1];
		array[0] = array[1] = true;

		// 에라토스테네스의 체
		// 2부터 시작, 소수의  제곱과 배수들을 제외한다.
		// ex) 2는 소수 -> 4, 6, 8, 10 ... 제외
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i ++) {
			for (int j = 2; j <= (n / i); j++) {
				if (!array[i * j]) {
					array[i * j] = true;
				}
			}
		}

		for (int i = m; i <= n ; i++){
			if (!array[i]) {
				System.out.println(i);
			}
		}
	}
}
