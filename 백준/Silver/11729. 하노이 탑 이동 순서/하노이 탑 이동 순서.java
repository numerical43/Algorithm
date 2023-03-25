import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int count;

    public static void hanoi(int n, int from, int other, int to) {
        if (n == 0)
            return;
        count++;

        hanoi(n - 1, from, to, other);

        sb.append(from).append(" ").append(to).append('\n');

        hanoi(n - 1, other, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        count = 0;

        hanoi(n, 1, 2, 3);

        System.out.println(count);
        System.out.print(sb);


    }
}