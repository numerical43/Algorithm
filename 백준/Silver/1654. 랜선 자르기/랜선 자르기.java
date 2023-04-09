import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0;
        long min = 0;

        // 랜선 길이들을 저장하면서 max 를 찾는다.
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i])
                max = arr[i];
        }

        // max 가 1이고 min 이 0이면 mid 가 0이 되어 에러가 나므로 max + 1을 해준다.
        max++;

        while (min < max) {
            long mid = (max + min) / 2;
            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.
            for (int lan : arr)
                count += (lan / mid);

            if (count < n)
                max = mid;
            else
                min = mid + 1;
        }

        System.out.println(min - 1);
    }
}