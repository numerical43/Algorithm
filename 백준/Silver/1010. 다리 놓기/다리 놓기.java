import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[30][30];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(combination(n, m)).append('\n');
        }

        System.out.println(sb);
    }

    // 조합 공식 (nCr)
    static int combination(int r, int n) {
        if (dp[n][r] > 0)
            return dp[n][r];

        if ((n == r) || (r == 0))
            return dp[n][r] = 1;

        return dp[n][r] = ( combination((r - 1), (n - 1)) + combination(r, (n - 1)) );
    }
}