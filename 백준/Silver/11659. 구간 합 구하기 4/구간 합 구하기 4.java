import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int[] sum;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 구간 합을 계산하기 위해 접두사 합을 계산
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            sb.append(sum[right + 1] - sum[left]).append("\n");
        }
        
        System.out.print(sb);
    }
}