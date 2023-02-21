import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int max = 0;

        while (num > 0) {
            arr[num % 10]++;
            num /= 10;
        }

        int temp = arr[6] + arr[9];
        arr[6] = (temp % 2 != 0) ? temp / 2 + 1 : temp / 2;

        for (int i = 0; i < 9; i++)
            max = Math.max(arr[i], max);

        System.out.println(max);
    }
}