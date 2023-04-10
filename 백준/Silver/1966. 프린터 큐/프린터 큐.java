import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            int count = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++)
                queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });

            while (!queue.isEmpty()) {
                int[] doc = queue.poll();
                boolean flag = true;

                // queue 에 있는 문서들과 중요도 비교한다.
                for (int[] inQueue : queue) {
                    if (inQueue[1] > doc[1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                    if (doc[0] == m)
                        break;
                }
                else
                    queue.add(doc);

            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

}