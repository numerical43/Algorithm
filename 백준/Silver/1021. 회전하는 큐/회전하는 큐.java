import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        LinkedList<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= n; i++)
            deque.offer(i);

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int find = Integer.parseInt(st.nextToken());
            int findPoint = deque.indexOf(find);
            // 중간 지점 초기화
            int halfPoint = (deque.size() % 2 == 0) ? deque.size() / 2 - 1 : deque.size() / 2;

            // 찾는 수가 중간 지점보다 앞에 있거나 같으면 앞의 수를 뺴서 뒤에 넣는다. (앞으로 접근)
            if (findPoint <= halfPoint) {
                for (int i = 0; i < findPoint; i++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            // 찾는 수가 중간 지점보다 뒤에 있으면 뒤의 수를 뺴서 앞에 넣는다. (뒤로 접근)
            else {
                for (int i = 0; i < deque.size() - findPoint; i++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}