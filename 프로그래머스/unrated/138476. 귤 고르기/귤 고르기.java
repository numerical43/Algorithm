import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for (int tSize : tangerine)
            map.put(tSize, map.getOrDefault(tSize, 0) + 1);

        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int i = 0;
        while (k > 0) {
            k -= map.get(keys.get(i++));
            answer++;
        }
        return answer;
    }
}