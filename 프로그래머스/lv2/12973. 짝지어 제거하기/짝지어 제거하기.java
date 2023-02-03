import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if (stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}