import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int quotient = n;
        List<Integer> list = new ArrayList<>();
        
        while (quotient > 0) {
            list.add(quotient % 3);
            quotient /= 3;
        }
        
        int num = 1;
        int index = list.size() - 1;
        for (int i = index; i >= 0; i--) {
            answer += (list.get(i) * num);
            num *= 3;
        }
        
        return answer;
    }
}