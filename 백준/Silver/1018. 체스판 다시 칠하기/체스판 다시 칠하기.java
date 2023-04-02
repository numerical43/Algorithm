import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];
        int answer = 64;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++)
                // 흰색은 true, 검은색은 false
                board[i][j] = str.charAt(j) == 'W';
        }

        int row = n - 7;
        int column = m - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                answer = Math.min(answer, paint(i, j));
        }

        System.out.println(answer);
    }


    public static int paint(int row, int column) {
        int endRow = row + 8;
        int endColumn = column + 8;
        int count = 0;

        // 첫번째 칸의 색
        boolean color = board[row][column];

        for (int i = row; i < endRow; i++) {
            for (int j = column; j < endColumn; j++) {
                // 올바른 색이 아닐경우 count + 1
                if (board[i][j] != color)
                    count++;

                color = !color;
            }
            color = !color;
        }

        // 흰색으로 칠하는 것과 검은색으로 칠하는 것 중 더 적은 횟수를 반환한다.
        // 예를 들어, 흰색으로 칠하는 것이 count 라면 검은색으로 칠하는 것은 64 - count 이다.
        return Math.min(count, 64 - count);
    }
}