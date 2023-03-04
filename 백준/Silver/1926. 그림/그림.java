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
    static int[][] paper;
    static int n, m, max, count;

    public static int BFS(int x, int y) {
        // 최초로 BFS 함수 진입 시 전달 받은 지점을 queue 에 저장하고 check 의 해당 지점을 true 로 바꾼다.
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));
        check[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            // queue 에 저장된 지점을 꺼내온다.
            point now = queue.poll();

            // 현재 지점에서 상, 하, 좌, 우로 움직여서 각각 그림인지 아닌지 판별한다.
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];

                // 상, 하, 좌, 우로 움직인 지점이 도화지를 벗어나거나, 이미 방문한 곳이거나, 그림이 아니면 다른 동작없이 넘어간다.
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n
                        || check[nextX][nextY] || paper[nextX][nextY] != 1)
                    continue;

                // 그림일 경우에는 해당 지점을 새롭게 queue 에 저장하고 check 의 해당 지점을 true 로 바꾼다.
                queue.add(new point(nextX, nextY));
                check[nextX][nextY] = true;
                // 그림 크기를 +1 한다.
                size++;
            }
        }
        // 그림 크기를 return 한다.
        return size;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        check = new boolean[m][n];
        paper = new int[m][n];
        count = 0;
        max = 0;

        // 종이에 그림을 표시한다.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++ )
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        // 하나씩 돌면서 그림인지 && 이미 check 되어 있는지 확인한다.
        // 그림이지만 check 가 안되어있다면(아직 방문한 적이 없다면) BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (paper[i][j] == 1 && !check[i][j]) {
                    // return 받는 값은 해당 그림의 크기이다.
                    // max 와 비교하여 더 큰 값을 다시 max 에 저장한다.
                    max = Math.max(BFS(i, j), max);
                    count++;
                }
            }
        }
        System.out.println(count + "\n" + max);
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