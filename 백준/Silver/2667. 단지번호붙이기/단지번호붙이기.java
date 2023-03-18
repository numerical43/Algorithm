import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] check;
    static String[][] complex;
    static int n;

    public static int BFS(int x, int y) {
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        check[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n
                        || check[nextX][nextY] || !complex[nextX][nextY].equals("1"))
                    continue;

                queue.add(new Point(nextX, nextY));
                check[nextX][nextY] = true;
                size++;
            }
        }
        return size;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Integer> count = new ArrayList<>();
        check = new boolean[n][n];
        complex = new String[n][n];
        int result = 0;

        for (int i = 0; i < n; i++)
            complex[i] = br.readLine().split("");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (complex[i][j].equals("1") && !check[i][j]) {
                    count.add(BFS(i, j));
                    result++;
                }
            }
        }

        Collections.sort(count);

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        for (int num : count)
            sb.append(num).append("\n");

        System.out.println(sb);
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