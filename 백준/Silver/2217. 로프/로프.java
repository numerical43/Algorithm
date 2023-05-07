import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];

        for (int i = 0; i < n; i++)
            rope[i] = Integer.parseInt(br.readLine());

        Arrays.sort(rope);

        // 현재 배열이 오름차순으로 정렬되어 있으므로, 
        // 앞에서부터 '현재 무게 * 현재 무게보다 더 버틸 수 있는 로프 수' 를 계산해서 더 높은 무게를 선택한다.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            max = Math.max(max, rope[i] * (n - i));

        System.out.println(max);
    }
}