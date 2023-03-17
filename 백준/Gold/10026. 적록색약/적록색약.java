import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static String[][] map;
    static boolean[][] check;

    public static void BFS(boolean flagGR, int x, int y) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            point now = queue.poll();
            // 현재 위치에서 상, 하, 좌, 우로 탐색한다.
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveX[i];
                int nextY = now.y + moveY[i];
                // map 의 범위를 벗어나거나 이미 방문했을 경우 그냥 넘어간다.
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || check[nextX][nextY])
                    continue;
                // 현재 위치의 색과 다음 위치의 색이 같지 않을 경우 적록 색약 플래그를 확인한다.
                if (!map[nextX][nextY].equals(map[now.x][now.y])) {
                    // 적록 색약일 경우 현재 위치와 다음 위치 중 하나가 "B" 이면 일치하지 않는게 맞으므로 그냥 넘어간다.
                    if (flagGR) {
                        if (map[nextX][nextY].equals("B") || map[now.x][now.y].equals("B"))
                            continue;
                    }
                    // 적록 색약이 아니면 무조건 일치하지 않는게 맞으므로 그냥 넘어간다.
                    else
                        continue;
                }
                // 위의 조건에 하나도 맞지 않으면 같은 색으로 판단되므로 queue 에 저장하고, 다음 위치의 check 를 true 로 바꿔준다.
                queue.add(new point(nextX, nextY));
                check[nextX][nextY] = true;
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        int count = 0;
        int countGR = 0;

        for (int i = 0; i < n; i++)
            map[i] = br.readLine().split("");

        // 적록 색약이 아닐 경우
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (!check[i][j]) {
                    BFS(false, i, j);
                    count++;
                }
        }

        // 적록 색약일 경우
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (!check[i][j]) {
                    BFS(true, i, j);
                    countGR++;
                }
        }

        System.out.println(count + " " + countGR);
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