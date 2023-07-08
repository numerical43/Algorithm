import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            hashMap.put(book, hashMap.getOrDefault(book, 0) + 1);
            max = Math.max(max, hashMap.get(book));
        }

        String bestBook = null;
        String now;
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == max) {
                if (bestBook != null) {
                    now = entry.getKey();
                    if (now.compareTo(bestBook) > 0)
                        continue;
                }
                bestBook = entry.getKey();
            }
        }

        System.out.print(bestBook);
    }
}