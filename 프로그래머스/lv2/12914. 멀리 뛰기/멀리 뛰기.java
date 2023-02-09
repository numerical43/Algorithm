class Solution {
    public long solution(int n) {
        int[] array = new int[2001];
        array[0] = 1;
        array[1] = 2;
        
        for (int i = 2; i < 2001; i++)
          array[i] = (array[i - 2] + array[i - 1]) % 1234567;
      
        return array[n - 1];
  }
}