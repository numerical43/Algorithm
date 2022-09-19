import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		//GetGCD(큰 수, 작은 수)
		int gcd = GetGCD(Math.max(a, b),Math.min(a, b));
		//두 수의 곱 == 최소공배수 * 최대공약수
		System.out.println(gcd + "\n" + ((a * b)/gcd));

	}

	//유클리드 호제법을 이용한 최대공약수 찾기
	// gcd(A, B) == gcd(B, A % B)
	static int GetGCD(int a, int b) {
		if ((a % b) == 0)
			return b;
		return GetGCD(b, (a % b));
	}
}