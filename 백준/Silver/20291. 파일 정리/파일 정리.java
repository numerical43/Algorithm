import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("\\.");
            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        for (String key : keyList)
            System.out.println(key + " " + map.get(key));
    }
}