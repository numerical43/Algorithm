import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] check = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        check[0][0] = true;
        maps[0][0] = 1;

        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m
                    || maps[nextX][nextY] == 0 || check[nextX][nextY])
                    continue;

                queue.add(new Point(nextX, nextY));
                check[nextX][nextY] = true;
                maps[nextX][nextY] = maps[now.x][now.y] + 1;
            }

            if (maps[n - 1][m - 1] != 1)
                return maps[n - 1][m - 1];
        }

        return -1;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

