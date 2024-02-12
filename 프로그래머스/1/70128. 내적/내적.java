class Solution {
    public int solution(int[] a, int[] b) {
        int length = a.length;
        int answer = 0;
        
        for (int i = 0; i < length; i++)
            answer += (a[i] * b[i]);
        
        return answer;
    }
}