import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 정수값으로 구성된 입력을 처리할 수 있도록 정수 집합(Set)을 생성
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (set.contains(x))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.print(sb);
    }
}