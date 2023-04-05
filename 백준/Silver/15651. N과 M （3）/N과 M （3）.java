import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] array;
    static int n, m;

    public static void DFS(int depth) {
        // 깊이가 최대 깊이이면 더이상 탐색할 자식노드가 없기 떄문에 return 한다.
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(array[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            array[depth] = i;
            DFS(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        array = new int[n];

        DFS(0);

        System.out.println(sb);
    }
}