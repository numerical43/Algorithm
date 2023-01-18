import java.io.*;
import java.util.*;
import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        Integer[] B = new Integer[n];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(B, reverseOrder());
        
        for (int i = 0; i < n; i++)
            answer += A[i] * B[i];

        System.out.println(answer);
    }
}