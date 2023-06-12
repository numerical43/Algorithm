class Solution {
    public int solution(String t, String p) {
        long num = Long.parseLong(p);
        int length = p.length();
        int answer = 0;
                    long now;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            now = Long.parseLong(t.substring(i, i + length));

            if (now <= num)
                answer++;
        }

        return answer;
    }
}
