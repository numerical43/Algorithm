import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num, count = 0;
		
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			if (CheckPrime(num))
				count++;
		}
		
		System.out.println(count);
	}

	static boolean CheckPrime(int num) {
		if (num < 2)
			return false;
		for (int i = 2; (i * i) <= num; i++) {
			if ((num % i) == 0)
				return false;
		}
		return true;
	}
}