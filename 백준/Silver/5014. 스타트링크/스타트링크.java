import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] check;

    public static String BFS (int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        check[s] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == g)
                return String.valueOf(check[now] - 1);
            if (now - d > 0 && check[now - d] == 0) {
                check[now - d] = check[now] + 1;
                queue.add(now - d);
            }
            if (now + u <= f && check[now + u] == 0) {
                check[now + u] = check[now] + 1;
                queue.add(now + u);
            }
        }

        return "use the stairs";
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        check = new int[f + 1];

        System.out.println(BFS(f, s, g, u, d));
    }
}