import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] check;

    public static int BFS (int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k)
                return check[now];
            if (now - 1 >= 0 && check[now - 1] == 0) {
                check[now - 1] = check[now] + 1;
                queue.add(now - 1);
            }
            if (now + 1 <= 100000 && check[now + 1] == 0) {
                check[now + 1] = check[now] + 1;
                queue.add(now + 1);
            }
            if (now * 2 <= 100000 && check[now * 2] == 0) {
                check[now * 2] = check[now] + 1;
                queue.add(now * 2);
            }
        }
        return -1;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        check = new int[100001];

        System.out.println(BFS(n, k));
    }
}