import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[11];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());

            for (int j = 4; j <= input; j++)
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];

            sb.append(arr[input]).append('\n');
        }

        System.out.println(sb);
    }
}