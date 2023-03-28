import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] array;
    public static int n, m;

    public static void DFS(int p, int depth) {
        // 깊이가 m 이랑 같다면 sb 에 저장한다.
        if (depth == m) {
            for (int num : array)
                sb.append(num).append(' ');

            sb.append('\n');
            return;
        }

        // 재귀로 백트래킹
        for (int i = p; i <= n; i++) {
            array[depth] = i;
            DFS(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];

        DFS(1, 0);

        System.out.print(sb);
    }
}