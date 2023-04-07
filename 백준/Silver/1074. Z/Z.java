import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        // 2의 n 제곱 : 한 변의 길이
        int size = (int) Math.pow(2, n);

        find(size, row, column);

        System.out.println(count);
    }

    private static void find(int size, int row, int column) {
        if (size == 1)
            return;

        int half = size / 2;

        if (row < half && column < half)
            find(half, row, column);
        else if (row < half && column >= half) {
            count += size * size / 4;
            find(half, row, (column - half));
        }
        else if (row >= half && column < half) {
            count += (size * size / 4) * 2;
            find(half, (row - half), column);
        }
        else {
            count += (size * size / 4) * 3;
            find(half, (row - half), (column - half));
        }
    }
}