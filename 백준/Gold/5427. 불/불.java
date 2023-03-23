import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int h, w;

    public static String BFS(String[][] map, boolean[][] check, Queue<point> fire, Queue<point> person) {
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};
        int count = 0;

        while (!person.isEmpty()) {
            // 각각 현재 fire, person 에 저장되어있는만큼 돌아야하기 때문에 size 를 미리 저장한다.
            int sizeF = fire.size();
            int sizeP = person.size();
            // 불
            while (sizeF-- > 0) {
                point nowFire = fire.poll();
                // 현재 위치에서 상, 하, 좌, 우로 탐색
                for (int i = 0; i < 4; i++) {
                    int nextX = nowFire.x + moveX[i];
                    int nextY = nowFire.y + moveY[i];

                    if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w
                            || map[nextX][nextY].equals("#") || map[nextX][nextY].equals("*"))
                        continue;
                    // 불은 계속 번지면서 늘어나기 때문에 다음 위치도 "*"로 바꾸고, fire queue 에 넣는다.
                    map[nextX][nextY] = "*";
                    fire.add(new point(nextX, nextY));
                }
            }

            while (sizeP-- > 0) {
                point nowPerson = person.poll();
                // 현재 위치에서 상, 하, 좌, 우로 탐색
                for (int i = 0; i < 4; i++) {
                    int nextX = nowPerson.x + moveX[i];
                    int nextY = nowPerson.y + moveY[i];

                    // map 의 범위를 벗어나면 탈출했다는 뜻이므로 count + 1 을 return 한다.
                    if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w)
                        return Integer.toString(count + 1);
                    if (map[nextX][nextY].equals("#") || map[nextX][nextY].equals("*")
                            || map[nextX][nextY].equals("@") || check[nextX][nextY])
                        continue;
                    // 사람은 이동하는 것이기 때문에 굳이 "@"로 바꾸지않고 person queue 에 넣기만 한다.
                    person.add(new point(nextX, nextY));
                    check[nextX][nextY] = true;
                }
            }
            count++;
        }

        return "IMPOSSIBLE";
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        // map 을 그리면서 불 위치는 fire queue 에, 사람의 위치는 person queue 에 저장한다.
        while (t-- > 0) {
            Queue<point> fire = new LinkedList<>();
            Queue<point> person = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            String[][] map = new String[h][w];
            // 중복 저장하게 되면 메모리 초과가 되기 때문에 이미 방문한 곳을 체크한다.
            boolean[][] check = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().split("");

                for (int j = 0; j < w; j++) {
                    if (map[i][j].equals("*"))
                        fire.add(new point(i, j));
                    else if (map[i][j].equals("@")) {
                        person.add(new point(i, j));
                        check[i][j] = true;
                    }
                }
            }
            sb.append(BFS(map, check, fire, person)).append("\n");
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