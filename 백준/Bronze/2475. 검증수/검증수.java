import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        int temp;

        for (int i = 0; i < 5; i++) {
            temp = Integer.parseInt(st.nextToken());
            result += temp * temp;
        }

        result %= 10;

        System.out.println(result);
    }
}