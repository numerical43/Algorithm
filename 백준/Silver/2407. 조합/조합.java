import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger N = BigInteger.ONE;
		BigInteger M = BigInteger.ONE;

		for (int i = 0; i < m; i++) {
			N = N.multiply(new BigInteger(String.valueOf(n - i)));
			M = M.multiply(new BigInteger(String.valueOf(1 + i)));
		}
		
		System.out.print(N.divide(M));
	}
}