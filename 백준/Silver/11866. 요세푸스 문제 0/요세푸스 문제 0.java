import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            queue.offer(i);

        sb.append("<");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (k - 1); j++)
                queue.offer(queue.poll());
            sb.append(queue.poll()).append(", ");
        }
        //맨 뒤의 ', ' 삭제
        sb.setLength(sb.length() - 2);
        sb.append(">");

        System.out.println(sb);

    }
}