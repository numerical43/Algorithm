import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++)
            list.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++)
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer num : list)
            sb.append(num).append(' ');

        System.out.println(sb);
    }
}