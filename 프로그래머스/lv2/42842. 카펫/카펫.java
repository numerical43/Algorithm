class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        int sum = brown + yellow;

        for (int row = 1; row <= sum; row++) {
            int col = sum / row;
            
            if (row > col)
                continue;
            
            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        return answer;
    }
}