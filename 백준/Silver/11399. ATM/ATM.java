import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] line = new int[n];
        int sum = 0;
        int result = 0;

        for (int i = 0; st.hasMoreTokens(); i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);

        for (int i = 0; i < n; i++) {
            sum += line[i];
            result += sum;
        }
        System.out.println(result);
    }
}