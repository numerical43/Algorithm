import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        int result = 0;
        int num = 1;

        // '(', '[' 로 num 을 계산하고 ')', ']' 로 num 을 초기화한다.
        for (int i = 0; i < input.length(); i++) {
            char chr = input.charAt(i);

            if (chr == '(') {
                stack.push(chr);
                num *= 2;
            }
            else if (chr == '[') {
                stack.push(chr);
                num *= 3;
            }
            else if (chr == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                else if (input.charAt(i - 1) == '(')
                    result += num;

                stack.pop();
                // num 을 초기화 시키는 과정
                num /= 2;
            }
            else if (chr == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                else if (input.charAt(i - 1) == '[')
                    result += num;

                stack.pop();
                // num 을 초기화 시키는 과정
                num /= 3;
            }
        }

        if (!stack.isEmpty())
            result = 0;

        System.out.println(result);
    }
}