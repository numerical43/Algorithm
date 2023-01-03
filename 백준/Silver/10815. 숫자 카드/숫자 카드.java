import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Map<Integer, Boolean> cardMap = new HashMap<>();
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) 
            cardMap.put(Integer.parseInt(input[i]), true);

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(input[i]);
            if (cardMap.containsKey(num))
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb.toString().trim());
    }
}