import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

class Solution {
    public String solution(String s) {
        String answer;
        StringTokenizer st = new StringTokenizer(s, " ");
        int max = MIN_VALUE;
        int min = MAX_VALUE;

        while(st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (now >= max)
                max = now;
            if (now <= min)
                min = now;
        }

        answer = min + " " + max;

        return answer;
    }
}