import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] check;
    static int[][] map;
    static int n;

    public static void BFS(int x, int y, int k) {
        Queue<Point> queue = new LinkedList<>();
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};

        queue.add(new Point(x, y));
        check[x][y] = true;
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n
                        || map[nextX][nextY] <= k || check[nextX][nextY])
                    continue;

                queue.add(new Point(nextX, nextY));
                check[nextX][nextY] = true;
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int result = 0;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(temp[j]);
        }

        for (int k = 0; k <= 100; k++) {
            check = new boolean[n][n];
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > k && !check[i][j]) {
                        BFS(i, j, k);
                        temp++;
                    }
                }
            }
            result = Math.max(temp, result);
        }
        System.out.println(result);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}