import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] points;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        points = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        // x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");

        System.out.print(sb);
    }
}