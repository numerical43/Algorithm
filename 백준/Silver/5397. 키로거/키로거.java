import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            // stack 에는 답의 정방향 문자열이 들어간다.
            Stack<Character> stack = new Stack<>();
            Stack<Character> temp = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '-') {
                    if (!stack.isEmpty())
                        stack.pop();
                }
                else if (c == '<') {
                    if (!stack.isEmpty())
                        temp.push(stack.pop());
                }
                else if (c == '>') {
                    if (!temp.isEmpty())
                        stack.push(temp.pop());
                }
                else
                    stack.push(c);
            }
            // stack 에 temp.pop() 을 넣으면 문자열이 답의 정방향으로 들어간다.
            // 하지만 stack 은 후입선출이기 때문에 stack.pop() 을 sb에 넣으면 출력이 답의 역방향 문자열이 된다.
            // 그러므로 temp 에 stack.pop() 을 넣어서 temp 가 답의 역방향 문자열이 되도록 만들고,
            // sb에 temp.pop() 을 넣음으로써 sb가 답의 정방향 문자열이 되도록 한다.
            while (!stack.isEmpty())
                temp.push(stack.pop());
            while (!temp.isEmpty())
                sb.append(temp.pop());
            sb.append('\n');
        }
        System.out.print(sb);
    }
}