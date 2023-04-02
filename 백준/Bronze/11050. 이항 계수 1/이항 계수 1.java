import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int factorial(int num) {
        int result = 1;

        for (int i = 1; i <= num; i++)
            result *= i;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 이항계수 공식 = n! / (k! * (n - k)!)
        int answer = factorial(n) / (factorial(k) * factorial(n - k));

        System.out.println(answer);
    }
}