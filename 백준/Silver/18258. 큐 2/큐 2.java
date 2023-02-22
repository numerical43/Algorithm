import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int temp = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input) {
                case "push": {
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    temp = num;
                    break;
                }
                case "pop": {
                    if (!queue.isEmpty())
                        sb.append(queue.poll()).append('\n');
                    else
                        sb.append(-1).append('\n');
                    break;
                }
                case "front": {
                    if (!queue.isEmpty())
                        sb.append(queue.peek()).append('\n');
                    else
                        sb.append(-1).append('\n');
                    break;
                }
                case "back": {
                    if (!queue.isEmpty())
                        sb.append(temp).append('\n');
                    else
                        sb.append(-1).append('\n');
                    break;
                }
                case "size": {
                    sb.append(queue.size()).append('\n');
                    break;
                }
                case "empty": {
                    if (queue.isEmpty())
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}