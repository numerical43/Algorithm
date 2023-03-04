import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String result = "";
        int[] array = new int[8];

        for (int i = 0; i < 8; i++)
            array[i] = Integer.parseInt(st.nextToken());

        // 1~8까지의 숫자가 한 번씩만 나오기 때문에 한 번 틀리면 무조건 mixed 가 결과값이 된다.
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1] + 1)
                result = "ascending";
            else if (array[i] == array[i - 1] - 1)
                result = "descending";
            else {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);
    }
}