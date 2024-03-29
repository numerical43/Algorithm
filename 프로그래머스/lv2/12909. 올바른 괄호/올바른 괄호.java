import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push('(');
			else {
				if (stack.empty())
					return false;
				else
					stack.pop();
				}
		}
        answer = stack.isEmpty();
        return answer;
	}
}