import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사실 제대로 성능을 내고 싶으면 Arrays.sort 가 아니라 counting 정렬을 사용하는 것이 좋다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] cntList = new int[8001];
        int[] arr = new int[n];
        int sum = 0;
        int mode = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++)
            cntList[arr[i] + 4000]++;
        
        for (int i = 0; i < 8001; i++) {
            if (max < cntList[i])
                max = cntList[i];
        }
        
        for (int i = 0; i < 8001; i++) {
            if (max == cntList[i]) {
                count++;
                mode = i - 4000;
            }
            if (count == 2)
                break;
        }

        sb.append(Math.round((float)sum / n)).append('\n');
        sb.append(arr[n / 2]).append('\n');
        sb.append(mode).append('\n');
        sb.append(arr[n - 1] - arr[0]);

        System.out.println(sb);
    }
}