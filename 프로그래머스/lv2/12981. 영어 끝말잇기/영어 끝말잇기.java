import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        List<String> list = new ArrayList<>();

        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String now = words[i];

            if (list.contains(now) || (pre.charAt(pre.length() - 1) != now.charAt(0))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            list.add(words[i]);
        }

        return answer;
    }
}
