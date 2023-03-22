import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] check;

    public static int BFS(int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, true));
        check[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == n - 1 && now.y == m - 1)
                return now.count;

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;

                if (map[nextX][nextY] == 0) {
                    if (now.wall && !check[nextX][nextY][0]) {
                        check[nextX][nextY][0] = true;
                        queue.add(new Point(nextX, nextY, now.count + 1, true));
                    }
                    else if (!now.wall && !check[nextX][nextY][1]) {
                        check[nextX][nextY][1] = true;
                        queue.add(new Point(nextX, nextY, now.count + 1, false));
                    }
                }
                else if (map[nextX][nextY] == 1) {
                    if (now.wall && !check[nextX][nextY][1]){
                        check[nextX][nextY][1] = true;
                        queue.add(new Point(nextX, nextY, now.count + 1, false));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int answer = BFS(n, m);

        System.out.println(answer);
    }
}

class Point {
    int x;
    int y;
    int count;
    boolean wall;

    public Point(int x, int y, int count, boolean wall) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.wall = wall;
    }
}