import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int bag = 0;
		
		while(true) {
			if ((n % 5) == 0) {
				bag += n / 5;
				System.out.println(bag);
				break;
			}
			else {
				n -= 3;
				bag++;
			}
			if (n < 0) {
				System.out.println(-1);
				break;
			}
		}
	}
}