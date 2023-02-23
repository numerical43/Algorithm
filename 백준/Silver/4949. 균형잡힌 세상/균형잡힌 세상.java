import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            String answer = "";

            if (str.equals("."))
                break;

            // label. 'break 라벨이름'을 하면 해당 라벨에 해당되는 반복문을 한 번에 빠져나올 수 있다. 
            // 아래에서는 for 문 안에 switch-case 문을 사용해서 안에서 break 를 하면 switch-case 문만 빠져나오기 때문에
            // 'loop' 라는 이름의 라벨을 사용해서 for 문을 빠져나올 수 있도록 만들었다.
            loop :
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    // java 14는 간단하게 콤마로 추가할 수 있다 (ex. case '(', '[' :)
                    case '(': case '[': {
                        stack.push(c);
                        break;
                    }
                    case ')' : {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            answer = "no";
                            break loop;
                        }
                        else
                            stack.pop();
                        break;
                    }
                    case ']' : {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            answer = "no";
                            break loop;
                        }
                        else
                            stack.pop();
                        break;
                    }
                }
            }

            if (answer.equals("")) {
                if (stack.isEmpty())
                    answer = "yes";
                else
                    answer = "no";
            }

            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }

}