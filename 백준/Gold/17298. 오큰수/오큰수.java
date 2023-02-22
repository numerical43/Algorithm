import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // stack 은 data 의 index 를 저장한다.
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++)
            data[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && data[stack.peek()] < data[i])
                // 현재 수가 해당 index 의 수보다 크다면 현재 수는 해당 index 의 수의 오큰수이다.
                // 해당 index 를 stack 에서 제거하고, 해당 index 의 수를 찾은 오큰수(현재 수)로 바꾼다.
                data[stack.pop()] = data[i];
            // stack 에 현재 수의 index 를 저장한다. (stack 에 남아있는 index 는 오큰수를 찾지 못한 수의 index 이다.)
            stack.push(i);
        }

        // for 문을 다 돌았음에도 stack 에 남아있는 index 는 오큰수가 없다는 뜻이므로 전부 -1로 값을 바꾼다.
        while(!stack.isEmpty())
            data[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(data[i]).append(' ');

        System.out.println(sb);
    }
}