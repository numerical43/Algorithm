import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            int mushroom = Integer.parseInt(br.readLine());
            
            if (sum > 100)
                break;
            
            sum += mushroom;
            //Math.abs -> 지정된 숫자의 절대 값 반환
            if (Math.abs(result - 100) > Math.abs(sum - 100))
                result = sum;
            else if (Math.abs(result - 100) == Math.abs(sum - 100))
                result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}