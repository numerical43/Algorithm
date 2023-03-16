import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list;
    static boolean[][] check;
    static int[][] map;
    static int n, m, k, count;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};
        int size = 1;

        queue.add(new Point(x, y));
        check[x][y] = true;
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n
                        || map[nextX][nextY] == 1 || check[nextX][nextY])
                    continue;

                size++;
                queue.add(new Point(nextX, nextY));
                check[nextX][nextY] = true;
            }
        }
        list.add(size);
        count++;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;

        check = new boolean[m][n];
        map = new int[m][n];
        int[] input = new int[4];

        while (--k >= 0) {
            st = new StringTokenizer(br.readLine(), " ");
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());
            input[2] = Integer.parseInt(st.nextToken());
            input[3] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= input[1] && i < input[3] && j >= input[0] && j < input[2])
                        map[i][j] = 1;
                    else if (map[i][j] != 1)
                        map[i][j] = 0;
                }
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !check[i][j])
                    BFS(i, j);
            }
        }

        Collections.sort(list);
        String result = list.toString().replaceAll(",", "").replace("[", "").replace("]", "");


        System.out.println(count + "\n" + result);
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