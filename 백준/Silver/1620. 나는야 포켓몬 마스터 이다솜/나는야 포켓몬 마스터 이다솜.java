import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            hashMap1.put(i, str);
            hashMap2.put(str, i);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if ((str.charAt(0) <= 'z') && (str.charAt(0) >= 'A')) {
                sb.append(hashMap2.get(str)).append("\n");
            }
            else {
                sb.append(hashMap1.get(Integer.parseInt(str))).append("\n");
            }
        }
        System.out.println(sb);
    }
}