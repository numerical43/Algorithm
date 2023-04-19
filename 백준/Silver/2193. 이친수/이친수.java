import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // n이 90까지라서 int 의 범위를 넘어갈 수 있다.
        long[] dp = new long[n + 2];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        if (n < 3)
            System.out.println(dp[n]);
        else {
            for (int i = 3; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 2];

            System.out.println(dp[n]);
        }
    }
}