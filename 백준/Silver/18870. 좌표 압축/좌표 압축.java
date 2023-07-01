import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] sort = new int[n];
        int count = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            sort[i] = array[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sort);
        
        for (int i : sort) {
            if(!hashMap.containsKey(i)) {
                hashMap.put(i, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : array) {
            count = hashMap.get(key);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}