import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] dp = new int[n + 10];
        int[][] arr = new int[n + 10][2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= (n + 1); i++) {
            int t = arr[i][0];
            int p = arr[i][1];

            dp[i] = Math.max(dp[i], max);
            // Math.max 로 이전에 저장한 최대 수익과 이번에 생긴 최대 수익 비교하여 저장
            if ((i + t) <= (n + 1))
                dp[t + i] = Math.max(dp[t + i], dp[i] + p);
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}