import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }

        // collections.sort 는 O(n) ~ O(nlogn)을 보장한다.
        // 단, 배열이 아니라 리스트를 사용해야함
        Collections.sort(numList);
        
        for (int num : numList) {
           sb.append(num).append("\n"); 
        }
        System.out.print(sb);
    }
}