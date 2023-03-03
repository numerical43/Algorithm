import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] moveX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] map;
    static int n;

    public static int BFS(point find, point position) {
        if (position.x == find.x && position.y == find.y)
            return 0;

        Queue<point> queue = new LinkedList<>();
        queue.add(position);
        map[position.x][position.y] = 0;

        while (!queue.isEmpty()) {
            point now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX == find.x && nextY == find.y)
                    return map[now.x][now.y] + 1;
                else if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n
                        || map[nextX][nextY] != 0)
                    continue;

                queue.add(new point(nextX, nextY));
                map[nextX][nextY] = map[now.x][now.y] + 1;
            }
        }
        return map[find.x][find.y];
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    map[i][j] = 0;
            }

            st = new StringTokenizer(br.readLine(), " ");
            point position = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine(), " ");
            point find = new  point (Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(BFS(find, position)).append("\n");
        }
        System.out.print(sb);
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