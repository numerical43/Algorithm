import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>();

        for (int i = 0 ; i < n ; i++)
            set.add(Integer.parseInt(st.nextToken()));

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list); 
        
        StringBuilder sb = new StringBuilder();
        for (int value : list)
            sb.append(value).append(" ");
        
        System.out.println(sb);
    }
}