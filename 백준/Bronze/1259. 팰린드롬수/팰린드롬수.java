import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals("0"))
                break;
            
            boolean check = true;
            int n = str.length();

            for (int i = 0; i <= n / 2; i++) {
                if (str.charAt(i) != str.charAt(n - i - 1)) {
                    check = false;
                    break;
                }
            }

            if (check)
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }

        System.out.print(sb);
    }
}