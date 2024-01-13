class Solution {
    public int[] solution(int n, int m) {
        int result = gcd(Math.max(n, m), Math.min(n, m));
        
        int[] answer = {result, n * m / result};
        
        return answer;
    }
    
    public int gcd(int m, int n) {
        if (m % n == 0) 
            return n;
        
        return gcd(n, m % n);
    }
}
