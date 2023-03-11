import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder(s);
            String str = sb.substring(0, i);
            sb.delete(0, i);
            sb.append(str);

            stack.push(sb.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                char chr = sb.charAt(j);
                
                if (stack.isEmpty())
                    stack.push(chr);
                else if (chr == '{' || chr == '[' || chr == '(')
                    stack.push(chr);
                else if (chr == '}') {
                    if (stack.peek() != '{')
                        break;
                    stack.pop();
                }
                else if (chr == ']') {
                    if (stack.peek() != '[')
                        break;
                    stack.pop();
                }
                else if (chr == ')') {
                    if (stack.peek() != '(')
                        break;
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                answer++;
        }

        return answer;
    }
}