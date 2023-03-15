import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<point> fire = new LinkedList<>();
    static Queue<point> person = new LinkedList<>();
    static int r, c;

    public static String BFS(String[][] map, boolean[][] check) {
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

                    if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c
                            || map[nextX][nextY].equals("#") || map[nextX][nextY].equals("F"))
                        continue;
                    // 불은 계속 번지면서 늘어나기 때문에 다음 위치도 "F"로 바꾸고, fire queue 에 넣는다.
                    map[nextX][nextY] = "F";
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
                    if (nextX < 0 || nextX >= r || nextY < 0 || nextY >= c)
                        return Integer.toString(count + 1);
                    if (map[nextX][nextY].equals("#") || map[nextX][nextY].equals("F")
                            || map[nextX][nextY].equals("J") || check[nextX][nextY])
                        continue;
                    // 사람은 이동하는 것이기 때문에 굳이 "J"로 바꾸지않고 person queue 에 넣기만 한다.
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        String[][] map = new String[r][c];
        // 중복 저장하게 되면 메모리 초과가 되기 때문에 이미 방문한 곳을 체크한다.
        boolean[][] check = new boolean[r][c];

        // map 을 만들면서 불 위치는 fire queue 에, 사람의 위치는 person queue 에 저장한다.
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
            
            for (int j = 0; j < c; j++) {
                if(map[i][j].equals("F"))
                    fire.add(new point(i, j));
                else if (map[i][j].equals("J")) {
                    person.add(new point(i, j));
                    check[i][j] = true;
                }
            }
        }

        System.out.println(BFS(map, check));
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