class Solution {
public int[] solution(String s) {
        int length = s.length();
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && answer[i] == 0) 
                    answer[i] = i - j;
            }

            if (answer[i] == 0)
                answer[i] = -1;
        }

        return answer;
    }
}