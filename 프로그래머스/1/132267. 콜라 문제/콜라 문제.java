public class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;
		int bottle = n;

        while (bottle >= a) {
            count += (bottle / a) * b;
            bottle = ((bottle / a) * b) + (bottle % a);
        }
        
		return count;
    }
}