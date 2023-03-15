import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] check;
    // 상, 하, 좌, 우
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int[][] field;
    static int n, m, t, c, count;

    public static void BFS(int x, int y) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));

        while (!queue.isEmpty()) {
            point now = queue.poll();
            check[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n
                        || check[nextX][nextY] || field[nextX][nextY] != 1)
                    continue;

                queue.add(new point(nextX, nextY));
                check[nextX][nextY] = true;
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            check = new boolean[m][n];
            field = new int[m][n];
            count = 0;

            for (int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] == 1 && !check[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}

class point {
    int x;
    int y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}