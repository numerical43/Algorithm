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
    static int[][] maze;
    static int n;
    static int m;

    public static void BFS(int x, int y) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));

        while (!queue.isEmpty()) {
            point nowPoint = queue.poll();

            // 현재 지점의 상 -> 하 -> 좌 -> 우 순서로 탐색한다.
            for (int i = 0; i < 4; i++) {
                int nextX = nowPoint.x + moveX[i];
                int nextY = nowPoint.y + moveY[i];

                // 미로를 벗어난 좌표, 이미 들렀던 좌표, 길이 아닌 좌표면 넘어간다.
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m
                        || check[nextX][nextY] || maze[nextX][nextY] == 0)
                    continue;

                // 다음 좌표가 길이라면 해당 좌표를 queue 에 저장한다.
                queue.add(new point(nextX, nextY));
                maze[nextX][nextY] = maze[nowPoint.x][nowPoint.y] + 1;
                check[nextX][nextY] = true;
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        check =  new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++)
                maze[i][j] = Integer.parseInt(input[j]);
        }

        check[0][0] = true;
        BFS(0, 0);

        System.out.println(maze[n - 1][m - 1]);
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