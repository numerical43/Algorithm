class Solution {
    public int[] solution(int n, int s) {
        int quotient = s / n;
        int remainder = s % n;
        int[] answer = new int [n];

        if (quotient == 0)
            return new int[] { -1 };
        else {
            for (int i = 0; i < n; i++)
                answer[i] = quotient;
            for (int i = 0; i < remainder ; i++)
                answer[n - 1 - i] += 1;
        }

        return answer;
    }
}