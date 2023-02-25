import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++)
                deque.add(Integer.parseInt(st.nextToken()));

            AC(command, deque);
        }

        System.out.println(sb);
    }

    public static void AC(String command, Deque<Integer> deque) {
        boolean front = true;

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R')
                front = !front;
            else if (cmd == 'D') {
                if (!deque.isEmpty()) {
                    if (front)
                        deque.removeFirst();
                    else
                        deque.removeLast();
                }
                else {
                    sb.append("error").append('\n');
                    return;
                }
            }
        }

        List<Integer> temp = new ArrayList<>();
        String answer;
        if (front) {
            while (!deque.isEmpty())
                temp.add(deque.pollFirst());
        }
        else {
            while (!deque.isEmpty())
                temp.add(deque.pollLast());
        }
        answer = temp.toString().replaceAll(" ", "");
        sb.append(answer).append('\n');

    }
}
