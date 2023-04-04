import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (!hashMap.containsKey(input))
                hashMap.put(input, 1);
            else
                hashMap.put(input, hashMap.get(input) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());

            if (hashMap.containsKey(card))
                sb.append(hashMap.get(card)).append(' ');
            else
                sb.append(0).append(' ');
        }

        System.out.println(sb);
    }
}