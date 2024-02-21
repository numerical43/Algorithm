import java.util.*;

class Solution {
    public String solution(int[] food) {
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        deque.add(0);
        
        for (int i = food.length - 1; i > 0; i--) {
            int div = food[i] / 2;
            
            for (int j = 0; j < div; j++) {
                deque.addFirst(i);
                deque.addLast(i);
            }
        }
        
        for (int num : deque)
            sb.append(num);
        
        return sb.toString();
    }
}