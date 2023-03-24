import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][][] map;
    static int L, R, C;

    public static String BFS(Point person) {
        Queue<Point> queue = new LinkedList<>();
        int[] moveX = {-1, 1, 0, 0, 0, 0};
        int[] moveY = {0, 0, -1, 1, 0, 0};
        int[] moveZ = {0, 0, 0, 0, -1, 1};

        queue.add(person);

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];
                int nextZ = now.z + moveZ[i];

                if (nextX < 0 || nextX >= L || nextY < 0 || nextY >= R || nextZ < 0 || nextZ >= C
                        || map[nextX][nextY][nextZ] == '#' || map[nextX][nextY][nextZ] == 'X')
                    continue;

                if (map[nextX][nextY][nextZ] == 'E')
                    return "Escaped in " + (now.count + 1) + " minute(s).";

                queue.add(new Point(nextX, nextY, nextZ, now.count + 1));
                // 한 번 방문한 위치를 표시하기 위해 해당 위치를 'X'로 바꾼다.
                map[nextX][nextY][nextZ] = 'X';
            }
        }
        return "Trapped!";
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0"))
                break;

            StringTokenizer st = new StringTokenizer(input, " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[L][R][C];
            Point person = new Point(0, 0, 0, 0);

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char chr = str.charAt(k);

                        if (chr == 'S')
                            person = new Point(i, j, k, 0);

                        map[i][j][k] = chr;
                    }
                }
                br.readLine();
            }

            sb.append(BFS(person)).append('\n');
        }

        System.out.println(sb);
    }
}

class Point {
    int x;
    int y;
    int z;
    int count;

    public Point(int x, int y, int z, int count) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
    }
}