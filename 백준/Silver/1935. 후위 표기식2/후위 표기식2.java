import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String postfix = br.readLine();

        // 피연산자 값을 저장할 배열
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = Integer.parseInt(br.readLine());

        // 후위 표기식 계산
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // 피연산자인 경우 스택에 쌓기
            if (c >= 'A' && c <= 'Z')
                stack.push((double) values[c - 'A']);
            // 연산자인 경우 스택에서 피연산자 2개 꺼내기
            else {
                double b = stack.pop();
                double a = stack.pop();
                double result = 0;
                switch (c) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                // 결과를 스택에 쌓기
                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}