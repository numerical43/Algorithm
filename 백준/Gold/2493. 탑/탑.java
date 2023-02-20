import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Top {
    int num;
    int height;

    public Top(int i, int height) {
        this.num = i;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (!stack.isEmpty()) {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append(0).append('\n');
                        stack.push(new Top(i, height));
                        break;
                    }

                    Top top = stack.peek();

                    if (top.height<= height)
                        stack.pop();
                    else {
                        sb.append(top.num).append('\n');
                        stack.push(new Top(i, height));
                        break;
                    }
                }
            }
            else {
                sb.append(0).append('\n');
                stack.push(new Top(i, height));
            }
        }

        System.out.println(sb);
    }

}