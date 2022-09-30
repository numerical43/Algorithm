import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		// 정렬
		Arrays.sort(arr, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			else {
				return s1.length() - s2.length();
			}
		});

		sb.append(arr[0]).append("\n");

		// 중복 빼고 string builder 에 추가
		for (int i = 1; i < n; i++) {
			if (!arr[i].equals(arr[i - 1])){
				sb.append(arr[i]).append("\n");
			}
		}

		System.out.print(sb);
	}
}