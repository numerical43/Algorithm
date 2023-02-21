import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        // n 이 최대 80,000 까지 입력되기 떄문에 int 의 범위를 초과할 수 있다.
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                // 현재 건물의 크기보다 같거나 작으면 현재 건물과 다음 건물들의 옥상을 볼 수 없기 때문에 pop
                if (stack.peek() <= height)
                    stack.pop();
                else
                    break;
            }
            // 남아있는 건물들은 현재 건물의 옥상을 볼 수 있는 건물 뿐이기 때문에 stack.size() 로 더한다.
            sum += stack.size();
            // 현재 건물 추가
            stack.push(height);
        }
        System.out.println(sum);
    }
}
