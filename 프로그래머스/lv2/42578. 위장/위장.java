import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hash = new HashMap<>();

        for (String[] cloth : clothes)
            hash.merge(cloth[1], 1, (a, b) -> hash.get(cloth[b]) + b);

        for (String cloth : hash.keySet())
            answer *= (hash.get(cloth) + 1);

        // 어느 옷도 선택하지 않는 경우
        answer--;
        
        return answer;
    }
}