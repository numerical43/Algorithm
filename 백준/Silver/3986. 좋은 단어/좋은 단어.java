import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N-- > 0) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char chr : input.toCharArray()) {
                if (!stack.isEmpty()) {
                    if (chr == stack.peek())
                        stack.pop();
                    else
                        stack.add(chr);
                }
                else
                    stack.add(chr);
            }

            if (stack.isEmpty())
                count++;
        }
        System.out.println(count);
    }
}