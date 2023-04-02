import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int find(int n, int m, int[] array) {
        int result = 0;
        
        for (int i = 0; i < n - 2; i++) {
            if (array[i] > m)
                continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (array[i] + array[j] > m)
                    continue;
                for (int k = j + 1; k < n; k++) {
                    int sum = array[i] + array[j] + array[k];

                    if (sum == m)
                        return sum;

                    if (sum < m && sum > result)
                        result = sum;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(array);

        System.out.println(find(n, m, array));
    }
}