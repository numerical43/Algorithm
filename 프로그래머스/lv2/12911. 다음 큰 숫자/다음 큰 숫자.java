class Solution {
    public int solution(int n) {
        // Integer.bitCount = 유효 비트 (1) 의 수를 반환
        int nOne = Integer.bitCount(n);
        int answer;

        for (int k = n + 1; ; k++) {
            int kOne = Integer.bitCount(k);

            if (kOne == nOne) {
                answer = k;
                break;
            }
        }

        return answer;
    }
}