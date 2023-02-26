import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        int count = 0;
        char pre = 0;

        for (char chr : input.toCharArray()) {
            if (!stack.isEmpty()) {
                if (chr == ')') {
                    stack.pop();
                    // 이전 입력이 '(' 이면 레이저라는 뜻이므로 절단한 뒤 레이저 기준 왼쪽에 있는 조각의 갯수를 더한다.
                    if (pre == '(')
                        count += stack.size();
                        // 쇠막대기가 끝나면 레이저로 절단하지 않아도 조각이 하나 생기기 때문에 count++
                    else
                        count++;
                }
                else if (chr == '(')
                    stack.push(chr);
            }
            else
                stack.push(chr);
            pre = chr;
        }
        // 남은 오른쪽 조각들을 더한다.
        if (!stack.isEmpty())
            count += stack.size();
        System.out.println(count);
    }
}