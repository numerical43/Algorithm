import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if (tree[i] > max)
                max = tree[i];
        }

        while (max > min) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int length : tree) {
                if (length - mid > 0)
                    sum += length - mid;
            }

            if (sum < m)
                max = mid;
            else
                min = mid + 1;
        }

        System.out.println(min - 1);
    }
}