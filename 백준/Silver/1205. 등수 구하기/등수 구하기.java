import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] arr = new int[p];
        
        if (n != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (p == n && arr[0] >= t) {
            System.out.println(-1);
            return;
        }

        int count = 1;

        for (int i = p - 1; i >= 0; i--) {
            if (arr[i] > t)
                count++;
            else
                break;
        }

        System.out.println(count);
    }
}