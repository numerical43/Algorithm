import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long GCD(long a, long b) {
        return ((b == 0) ? a : GCD(b, a % b));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] num = new long[n];

            for (int i = 0; i < n; i++)
                num[i] = Integer.parseInt(st.nextToken());

            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++)
                        sum += GCD(num[i], num[j]);
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}