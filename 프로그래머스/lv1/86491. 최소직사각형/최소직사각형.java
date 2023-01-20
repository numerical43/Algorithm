class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_row = 0; //가로
        int max_col = 0; //세로
        
        // 각 명함의 긴 부분을 row로, 짧은 부분을 col로 설정
        for (int i = 0; i < sizes.length; i++) {
            max_row = Math.max(max_row, Math.max(sizes[i][0], sizes[i][1]));
            max_col = Math.max(max_col, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        answer = max_row * max_col;
        
        return answer;
    }
}