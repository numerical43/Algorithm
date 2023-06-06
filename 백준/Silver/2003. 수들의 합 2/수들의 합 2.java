import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        int count = 0;
        int front = 0;
        int end = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        while (front < n) {
            if (sum > m || end == n)
                sum -= array[front++];
            else
                sum += array[end++];

            if (sum == m)
                count++;
        }

        System.out.println(count);
    }
}
