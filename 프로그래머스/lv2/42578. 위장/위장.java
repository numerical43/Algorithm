import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hash = new HashMap<>();

        for (String[] cloth : clothes)
            hash.put(cloth[1], hash.getOrDefault(cloth[1], 0) + 1);

        for (String cloth : hash.keySet())
            answer *= (hash.get(cloth) + 1);

        // 어느 옷도 선택하지 않는 경우
        answer--;

        return answer;
    }
}