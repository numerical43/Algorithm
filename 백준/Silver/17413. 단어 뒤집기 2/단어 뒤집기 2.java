import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                
                while(true) {
                    if (str.charAt(i) == '>') {
                        sb.append(str.charAt(i));
                        break;
                    }
                    sb.append(str.charAt(i++));
                }
            }
            else if (str.charAt(i) == ' ') {
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(' ');
            }
            else
                stack.push(String.valueOf(str.charAt(i)));
        }
        
        if (!stack.isEmpty()) {
            while(!stack.isEmpty())
                sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
}