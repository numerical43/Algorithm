class Solution {
    public int solution(int n) {
        // Integer.bitCount = 유효 비트 (1) 의 수를 반환
        int nOne = Integer.bitCount(n);
        int answer;

        while (true) {
            if (Integer.bitCount(++n) == nOne) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}