import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, h;

    public static int BFS(Queue<point> queue, int[][][] box) {
        boolean[][][] check = new boolean[h][n][m];
        // 왼쪽, 오른쪽, 앞, 뒤, 위, 아래
        int[] moveX = {-1, 1, 0, 0, 0, 0};
        int[] moveY = {0, 0, -1, 1, 0, 0};
        int[] moveZ = {0, 0, 0, 0, -1, 1};
        int date = 0;

        while (!queue.isEmpty()) {
            point now = queue.poll();
            check[now.z][now.x][now.y] = true;

            // 현재 지점에서 왼쪽, 오른쪽, 앞, 뒤, 위, 아래로 탐색한다.
            for (int i = 0; i < 6; i++) {
                int nextZ = now.z + moveZ[i];
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                // 창고를 벗어나거나, 이미 들렀던 곳이거나, 토마토가 없거나, 이미 토마토가 익었으면 넘어간다.
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || nextZ < 0 || nextZ >= h
                        || check[nextZ][nextX][nextY] || box[nextZ][nextX][nextY] == -1 || box[nextZ][nextX][nextY] >= 1)
                    continue;

                // 그렇지않으면 지금 토마토가 익은 것이므로 queue 에 현재 지점을 저장한다.
                queue.add(new point(nextX, nextY, nextZ));
                // box[][][] 에 해당 토마토가 익은 날짜를 다시 저장한다. (현재 날짜 + 1)
                box[nextZ][nextX][nextY] = box[now.z][now.x][now.y] + 1;
                // 처음 시작 날짜가 1이기 때문에 box[][][] 에 저장된 날짜는 실제 익은 날짜 + 1이다.
                date = Math.max(date, box[nextZ][nextX][nextY]) - 1;
            }
        }

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    if (box[k][i][j] == 0)
                        return -1;
            }
        }

        return date;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][][] box = new int[h][n][m];


        Queue<point> queue = new LinkedList<>();
        // 창고에 있는 토마토 위치를  box[][][]와 queue 에 저장한다.
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());

                    if (box[k][i][j] == 1)
                        queue.add(new point(i, j, k));
                }
            }
        }

        System.out.println(BFS(queue, box));
    }
}

class point {
    int x;
    int y;
    int z;

    public point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}